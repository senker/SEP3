package via.sep3.persistencetier.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import via.sep3.persistencetier.database.customer.CustomerRepository;
import via.sep3.persistencetier.database.foodPack.FoodPack;
import via.sep3.persistencetier.database.foodPack.PackRepository;
import via.sep3.persistencetier.database.reservation.Reservation;
import via.sep3.persistencetier.database.reservation.ReservationRepository;
import via.sep3.persistencetier.protobuf.ReservationServiceGrpc;
import via.sep3.persistencetier.protobuf.*;

import javax.transaction.Transactional;

@GRpcService
@Transactional
public class ReservationService extends ReservationServiceGrpc.ReservationServiceImplBase{
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    PackRepository foodPackRepository;
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void createReservation(CreateReservationRequest reservationRequest, StreamObserver<ReservationResponse> responseObserver) {

    }

    @Override
    public void getReservationById(ReservationRequest request, StreamObserver<ReservationResponse> responseObserver) {
        super.getReservationById(request, responseObserver);
    }

    @Override
    public void getReservationsBySellerCvr(ReservationSellerRequest request, StreamObserver<ReservationResponse> responseObserver) {
        super.getReservationsBySellerCvr(request, responseObserver);
    }

    @Override
    public void deleteReservationById(ReservationRequest request, StreamObserver<ReservationResponse> responseObserver) {
        super.deleteReservationById(request, responseObserver);
    }

    @Override
    public void searchReservation(SearchReservation request, StreamObserver<ReservationResponse> responseObserver) {
        super.searchReservation(request, responseObserver);
    }

    @Override
    public void getAllReservations(EmptyReservation request, StreamObserver<ReservationResponse> responseObserver) {
        super.getAllReservations(request, responseObserver);
    }

    private void reservationResponseBuilder(Reservation reservation, StreamObserver<ReservationResponse> responseObserver){
        ReservationResponse.Builder builder = ReservationResponse.newBuilder()
                .setId(reservation.getId())
                .setStatus(reservation.getStatus())
                .setFoodPackId(reservation.getFoodPackId().getId())
                .setCustomerId(reservation.getCustomerId().getEmail())
                .setStartPickupTime(reservation.getStartPickupTime().getCalendarType())
                .setEndPickupTime(reservation.getEndPickupTime().getCalendarType())
                .setCvr(reservation.getFoodPackId().getSeller().getCvr().intValue());

        var response = builder.build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}
