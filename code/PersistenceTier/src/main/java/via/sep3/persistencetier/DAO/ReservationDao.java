package via.sep3.persistencetier.DAO;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import via.sep3.persistencetier.database.userInfo.Address;
import via.sep3.persistencetier.database.customer.CustomerRepository;
import via.sep3.persistencetier.database.foodPack.FoodPack;
import via.sep3.persistencetier.database.foodPack.PackRepository;
import via.sep3.persistencetier.database.reservation.Reservation;
import via.sep3.persistencetier.database.reservation.ReservationRepository;
import via.sep3.persistencetier.database.seller.SellerRepository;
import via.sep3.persistencetier.protobuf.*;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

@GRpcService
@Transactional
public class ReservationDao extends ReservationServiceGrpc.ReservationServiceImplBase{
    final
    ReservationRepository reservationRepository;
    final
    PackRepository foodPackRepository;
    final
    CustomerRepository customerRepository;
    private final SellerRepository sellerRepository;

    @Autowired
    public ReservationDao(ReservationRepository reservationRepository, PackRepository foodPackRepository, CustomerRepository customerRepository, SellerRepository sellerRepository) {
        this.reservationRepository = reservationRepository;
        this.foodPackRepository = foodPackRepository;
        this.customerRepository = customerRepository;
        this.sellerRepository = sellerRepository;
    }

    @Override
    public void createReservation(CreateReservationRequest reservationRequest, StreamObserver<ReservationResponse> responseObserver) {
        FoodPack foodPack = foodPackRepository.findById(reservationRequest.getFoodPackId());
        Reservation reservation = new Reservation(
                // int32 customer_id = 1;
                //  int32 foodPackId = 2;
                "active",
                foodPack,
                customerRepository.findByEmail(reservationRequest.getCustomerId())
                );

         var savedReservation = reservationRepository.save(reservation);
        reservationResponseBuilder(savedReservation, responseObserver);
        responseObserver.onCompleted();
    }


    @Override
    public void getReservationsBySellerCvr(ReservationSellerRequest reservationRequest, StreamObserver<ReservationResponse> responseObserver) {
     //   Seller seller = sellerRepository.findByCvr((long) reservationRequest.getCvr());
        Stream<FoodPack> foodPacks = foodPackRepository.findBySeller(reservationRequest.getCvr());


        foodPacks.forEach(foodPack ->{
            Stream<Reservation> reservations = reservationRepository.findByFoodPack(foodPack);
            reservations.forEach(reservation->{
                reservationResponseBuilder(reservation, responseObserver);
            });
        });
        responseObserver.onCompleted();
    }


    @Override
    public void getReservationsByCustomerEmail(ReservationCustomerRequest reservationRequest, StreamObserver<ReservationResponse> responseObserver)
    {
        Stream<Reservation> reservations = reservationRepository.findByCustomerEmail(reservationRequest.getEmail());
        reservations.forEach(reservation ->{
            reservationResponseBuilder(reservation, responseObserver);
        });
        responseObserver.onCompleted();
    }







    private void reservationResponseBuilder(Reservation reservation, StreamObserver<ReservationResponse> responseObserver){

        LocalDateTime startDateTime = reservation.getFoodPackId().getDateTimeStart();
        LocalDateTime endDateTime = reservation.getFoodPackId().getDateTimeEnd();

        DateTimeFormatter customFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedStartDateTime = startDateTime.format(customFormat);
        String formattedEndDateTime = endDateTime.format(customFormat);

        //StreetName, PostCode City
        Address addressObject = reservation.getFoodPackId().getSeller().getAddress();
        String address = addressObject.getStreetName()+ ", "
                + addressObject.getPostcode() + " " + addressObject.getCity();

        ReservationResponse.Builder builder = ReservationResponse.newBuilder()
                .setStatus(reservation.getStatus())
                .setFoodPack(FoodPackModel.newBuilder()
                        .setId(reservation.getFoodPackId().getId())
                        .setTitle(reservation.getFoodPackId().getTitle())
                        .setDescription(reservation.getFoodPackId().getDescription())
                        .setType(reservation.getFoodPackId().getType())
                        .setIsPrepared(reservation.getFoodPackId().isIs_prepared())
                        .setPrice(reservation.getFoodPackId().getPrice())
                        .setStartPickupTime(formattedStartDateTime)
                        .setEndPickupTime(formattedEndDateTime)
                )
                .setCustomerId(reservation.getCustomerId().getEmail())
                .setCvr(reservation.getFoodPackId().getSeller().getCvr().intValue())
                .setFullAddress(address);

        var response = builder.build();

        responseObserver.onNext(response);
    }
}
