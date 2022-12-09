package via.sep3.persistencetier.service;

import com.google.protobuf.Message;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import via.sep3.persistencetier.database.customer.CustomerRepository;
import via.sep3.persistencetier.database.foodPack.FoodPack;
import via.sep3.persistencetier.database.foodPack.PackRepository;
import via.sep3.persistencetier.database.reservation.Reservation;
import via.sep3.persistencetier.database.reservation.ReservationRepository;
import via.sep3.persistencetier.database.seller.Seller;
import via.sep3.persistencetier.database.seller.SellerRepository;
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
    @Autowired
    private SellerRepository sellerRepository;

    @Override
    public void createReservation(CreateReservationRequest reservationRequest, StreamObserver<ReservationResponse> responseObserver) {
        FoodPack foodPack = foodPackRepository.findById(reservationRequest.getFoodPackId());

        Reservation reservation = new Reservation(
                // int32 customer_id = 1;
                //  int32 foodPackId = 2;
                "reserved",
                customerRepository.findByEmail(reservationRequest.getCustomerId()),
                foodPack);

        var savedReservation = reservationRepository.save(reservation);
        reservationResponseBuilder(savedReservation, responseObserver);

    }


    @Override
    public void getReservationsBySellerCvr(ReservationSellerRequest reservationRequest, StreamObserver<ReservationResponse> responseObserver) {
        Seller seller = sellerRepository.findByCvr((long) reservationRequest.getCvr());
        reservationRepository.findBySellerCvr(seller);
    }

    @Override
    public void deleteReservationById(ReservationRequest reservationRequest, StreamObserver<ReservationResponse> responseObserver) {
        Reservation reservation = reservationRepository.findById(reservationRequest.getId());
        reservationRepository.deleteById(reservationRequest.getId());
        reservationResponseBuilder(reservation, responseObserver);
    }







    private void reservationResponseBuilder(Reservation reservation, StreamObserver<ReservationResponse> responseObserver){
        ReservationResponse.Builder builder = ReservationResponse.newBuilder()
                .setId(reservation.getId())
                .setStatus(reservation.getStatus())
                .setFoodPackId(reservation.getFoodPackId().getId())
                .setCustomerId(reservation.getCustomerId().getEmail())
                .setCvr(reservation.getFoodPackId().getSeller().getCvr().intValue());

        var response = builder.build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();

    }
}
