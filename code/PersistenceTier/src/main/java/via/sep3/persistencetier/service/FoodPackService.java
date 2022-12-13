package via.sep3.persistencetier.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import via.sep3.persistencetier.database.userInfo.AddressRepository;
import via.sep3.persistencetier.database.foodPack.FoodPack;
import via.sep3.persistencetier.database.foodPack.PackRepository;
import via.sep3.persistencetier.database.seller.Seller;
import via.sep3.persistencetier.database.seller.SellerRepository;
import via.sep3.persistencetier.protobuf.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

@GRpcService
@Transactional
public class FoodPackService extends FoodPackServiceGrpc.FoodPackServiceImplBase {

final
PackRepository packRepository;

final
SellerRepository sellerRepository;

final
AddressRepository addressRepository;
@Autowired
    public FoodPackService(PackRepository packRepository, SellerRepository sellerRepository, AddressRepository addressRepository) {
        this.packRepository = packRepository;
        this.sellerRepository = sellerRepository;
        this.addressRepository = addressRepository;
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
            sellerRepository.findByCvr((long) packRequest.getCvr())
    );
    var savedFoodPack = packRepository.save(foodPack);
    foodPackResponseBuilder(responseObserver, savedFoodPack);
}

@Override
    public void getAllFoodPacks(EmptyFoodPack packRequest, StreamObserver<FoodPackResponse> responseObserver)
{
    FoodPackResponse.Builder foodPackResponseBuilder = FoodPackResponse.newBuilder();
    Stream<FoodPack> foodPackStream = packRepository.findAllStream();

    foodPackStream.forEach(pack ->{
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
    var foodPack = packRepository.findById(foodPackRequest.getId());
    foodPackResponseBuilder(responseObserver, foodPack);
}

@Override
public void getFoodPacksBySellerCvr(FoodPackSellerRequest foodPackSellerRequest, StreamObserver<FoodPackResponse> responseObserver)
{
    System.out.println("Inside get food packs by seller cvr");
    FoodPackResponse.Builder response = FoodPackResponse.newBuilder();
    Seller seller = sellerRepository.findByCvr((long) foodPackSellerRequest.getCvr());
    Stream<FoodPack> foodPackStream = packRepository.findBySeller(seller.getCvr().intValue());

    foodPackStream.forEach(pack ->{
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
    });
    responseObserver.onCompleted();
}


@Override
public void deleteFoodPackById(FoodPackRequest foodPackRequest, StreamObserver<FoodPackResponse> responseObserver) {
    FoodPack foodPack = packRepository.findById(foodPackRequest.getId());
    packRepository.deleteById(foodPackRequest.getId());
    foodPackResponseBuilder(responseObserver, foodPack);
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

            Long address_id = addressRepository.findByPostCode(postCode);

            Stream<FoodPack> streamOfSellers;

            Long cvr = sellerRepository.findByAddressId(address_id);

           if(price==0)
           {
               streamOfSellers = packRepository.searchPacks(title, isPrepared, type, cvr);
           }
           else{
               streamOfSellers = packRepository.searchPacks(title, isPrepared, type, price, cvr);
           }

           streamOfSellers.forEach(pack -> {
               foodPackResponseBuilder
                       .setId(pack.getId())
                       .setTitle(pack.getTitle())
                       .setDescription(pack.getDescription())
                       .setType(pack.getType())
                       .setIsPrepared(pack.isIs_prepared())
                       .setPrice(pack.getPrice());
               responseObserver.onNext(foodPackResponseBuilder.build());
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
    responseObserver.onCompleted();




}


}
