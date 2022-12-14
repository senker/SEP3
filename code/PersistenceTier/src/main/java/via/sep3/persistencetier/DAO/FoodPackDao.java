package via.sep3.persistencetier.DAO;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import via.sep3.persistencetier.database.userInfo.Address;
import via.sep3.persistencetier.database.reservation.Reservation;
import via.sep3.persistencetier.database.reservation.ReservationRepository;
import via.sep3.persistencetier.database.userInfo.AddressRepository;
import via.sep3.persistencetier.database.foodPack.FoodPack;
import via.sep3.persistencetier.database.foodPack.PackRepository;
import via.sep3.persistencetier.database.seller.Seller;
import via.sep3.persistencetier.database.seller.SellerRepository;
import via.sep3.persistencetier.protobuf.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@GRpcService
@Transactional
public class FoodPackDao extends FoodPackServiceGrpc.FoodPackServiceImplBase {

    final ReservationRepository RESERVATION_REPOSITORY;
final
PackRepository PACK_REPOSITORY;

final
SellerRepository SELLER_REPOSITORY;

final
AddressRepository ADDRESS_REPOSITORY;
@Autowired
    public FoodPackDao(PackRepository packRepository, SellerRepository sellerRepository, AddressRepository addressRepository, ReservationRepository reservationRepository) {
        this.PACK_REPOSITORY = packRepository;
        this.SELLER_REPOSITORY = sellerRepository;
        this.ADDRESS_REPOSITORY = addressRepository;
        this.RESERVATION_REPOSITORY = reservationRepository;
    }

    @Override
    public void createFoodPack(CreateFoodPackRequest packRequest, StreamObserver<FoodPackResponse> responseObserver){
    System.out.println("year: " + packRequest.getStartTime().getYear());
    System.out.println("month: " + packRequest.getStartTime().getMonth());
    System.out.println("day: " + packRequest.getStartTime().getDay());
    System.out.println("hour: " + packRequest.getStartTime().getHour());
    System.out.println("minute: " + packRequest.getStartTime().getMinutes());
    FoodPack foodPack = new FoodPack(
            packRequest.getTitle(),
            packRequest.getDescription(),
            packRequest.getType(),
            packRequest.getIsPrepared(),
            packRequest.getPrice(),
            //int year, int month, int day, int hour, int minute
            LocalDateTime.of(
                    packRequest.getStartTime().getYear(),
                    packRequest.getStartTime().getMonth(),
                    packRequest.getStartTime().getDay(),
                    packRequest.getStartTime().getHour(),
                    packRequest.getStartTime().getMinutes()
            ).truncatedTo(ChronoUnit.MINUTES),
            LocalDateTime.of(
                    packRequest.getEndTime().getYear(),
                    packRequest.getEndTime().getMonth(),
                    packRequest.getEndTime().getDay(),
                    packRequest.getEndTime().getHour(),
                    packRequest.getEndTime().getMinutes()
            ).truncatedTo(ChronoUnit.MINUTES),
            SELLER_REPOSITORY.findByCvr((long) packRequest.getCvr())
    );
    var savedFoodPack = PACK_REPOSITORY.save(foodPack);
    sendToMessageQueue();
    foodPackResponseBuilder(responseObserver, savedFoodPack);
    responseObserver.onCompleted();
}

@Override
    public void getAllFoodPacks(EmptyFoodPack packRequest, StreamObserver<FoodPackResponse> responseObserver)
{
    FoodPackResponse.Builder foodPackResponseBuilder = FoodPackResponse.newBuilder();
    Stream<FoodPack> foodPackStream = PACK_REPOSITORY.findAllStream();

    foodPackStream.forEach(pack ->{
        System.out.println("pack ");
       foodPackResponseBuilder
               .setId(pack.getId())
               .setTitle(pack.getTitle())
               .setDescription(pack.getDescription())
               .setIsPrepared(pack.isIs_prepared())
               .setPrice(pack.getPrice());
        responseObserver.onNext(foodPackResponseBuilder.build());
    });
    responseObserver.onCompleted();
}

@Override
public void getFoodPackById(FoodPackRequest foodPackRequest, StreamObserver<FoodPackResponse> responseObserver) {
    var foodPack = PACK_REPOSITORY.findById(foodPackRequest.getId());
    foodPackResponseBuilder(responseObserver, foodPack);
    responseObserver.onCompleted();
}

@Override
public void getFoodPacksBySellerCvr(FoodPackSellerRequest foodPackSellerRequest, StreamObserver<FoodPackResponse> responseObserver)
{
    System.out.println("Inside get food packs by seller cvr");
    FoodPackResponse.Builder response = FoodPackResponse.newBuilder();
    Seller seller = SELLER_REPOSITORY.findByCvr((long) foodPackSellerRequest.getCvr());
    Stream<FoodPack> foodPackStream = PACK_REPOSITORY.findBySeller(seller.getCvr().intValue());
    Stream<Reservation> reservationStream = RESERVATION_REPOSITORY.findAllStream();

    var reservationsList = reservationStream.collect(Collectors.toList());

    foodPackStream.forEach(pack ->{
        boolean isReservationFound = false;

        for (Reservation reservation : reservationsList) {
            if (reservation.getFoodPackId().getId() == pack.getId()) {
                isReservationFound = true;
                break;
            }
        }

        if (!isReservationFound) {
            response
                    .setId(pack.getId())
                    .setTitle(pack.getTitle())
                    .setDescription(pack.getDescription())
                    .setType(pack.getType())
                    .setIsPrepared(pack.isIs_prepared())
                    .setStartTime(
                            DateTimeFoodPack.newBuilder()
                                    .setDay(pack.getDateTimeStart().getDayOfMonth())
                                    .setMonth(pack.getDateTimeStart().getMonthValue())
                                    .setYear(pack.getDateTimeStart().getYear())
                                    .setHour(pack.getDateTimeStart().getHour())
                                    .setMinutes(pack.getDateTimeStart().getMinute()).build()
                    )
                    .setEndTime(
                            DateTimeFoodPack.newBuilder()
                                    .setDay(pack.getDateTimeEnd().getDayOfMonth())
                                    .setMonth(pack.getDateTimeEnd().getMonthValue())
                                    .setYear(pack.getDateTimeEnd().getYear())
                                    .setHour(pack.getDateTimeEnd().getHour())
                                    .setMinutes(pack.getDateTimeEnd().getMinute()).build()
                    )
                    .setPrice(pack.getPrice());

            responseObserver.onNext(response.build());
        }
    });

    responseObserver.onCompleted();
}


@Override
public void deleteFoodPackById(FoodPackRequest foodPackRequest, StreamObserver<FoodPackResponse> responseObserver) {
    FoodPack foodPack = PACK_REPOSITORY.findById(foodPackRequest.getId());
    PACK_REPOSITORY.deleteById(foodPackRequest.getId());
    foodPackResponseBuilder(responseObserver, foodPack);
    responseObserver.onCompleted();
}


    @Override
    public void searchFoodPacks(SearchFoodPacks request, StreamObserver<FoodPackResponse> responseObserver)
    {
        FoodPackResponse.Builder foodPackResponseBuilder = FoodPackResponse.newBuilder();

            String title;
            boolean isPrepared;
            String type;
            Double price;
            Integer postCode;

            title = request.getTitle();
            isPrepared=request.getIsPrepared();
            type = request.getType();
            postCode = request.getPostcode();
            price = request.getPrice();

            Stream<Address> address_list = ADDRESS_REPOSITORY.findByPostCode(request.getPostcode());


            address_list.forEach(address -> {
                System.out.println("city: " + address.getId());

                Stream<Seller> sellerList = SELLER_REPOSITORY.findByAddress(address.getId());
                sellerList.forEach(seller ->
                {
                    System.out.println("cvr: " + seller.getCvr());
                    Stream<FoodPack> streamOfSellers = PACK_REPOSITORY.searchPacks(title, isPrepared, type, price, seller.getCvr());

                    streamOfSellers.forEach(pack -> {
                        System.out.println("packId: " + pack.getId());
                        foodPackResponseBuilder(responseObserver, pack);
                    });
                });
            });
        responseObserver.onCompleted();

    }



private void foodPackResponseBuilder(StreamObserver<FoodPackResponse> responseObserver, FoodPack foodPack){
    FoodPackResponse.Builder builder = FoodPackResponse.newBuilder()
            .setId(foodPack.getId())
            .setType(foodPack.getType())
            .setDescription(foodPack.getDescription())
            .setTitle(foodPack.getTitle())
            .setPrice(foodPack.getPrice())
            .setStartTime(
                    DateTimeFoodPack.newBuilder()
                            .setDay(foodPack.getDateTimeStart().getDayOfMonth())
                            .setMonth(foodPack.getDateTimeStart().getMonthValue())
                            .setYear(foodPack.getDateTimeStart().getYear())
                            .setHour(foodPack.getDateTimeStart().getHour())
                            .setMinutes(foodPack.getDateTimeStart().getMinute()).build()
            )
            .setEndTime(DateTimeFoodPack.newBuilder()
                    .setDay(foodPack.getDateTimeEnd().getDayOfMonth())
                    .setMonth(foodPack.getDateTimeEnd().getMonthValue())
                    .setYear(foodPack.getDateTimeEnd().getYear())
                    .setHour(foodPack.getDateTimeEnd().getHour())
                    .setMinutes(foodPack.getDateTimeEnd().getMinute()).build())
            .setIsPrepared(foodPack.isIs_prepared());

            var response = builder.build();

    responseObserver.onNext(response);




}


public void sendToMessageQueue()
{
    String QUEUE_NAME = "subscribe.queue";
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");

    try(Connection conn = factory.newConnection(); Channel channel=conn.createChannel())
    {
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "First rabbitMQ message";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println("Message sent: " + message);
    }catch(Exception e)
    {
        System.out.println(e.getMessage());
    }
}


}
