package via.sep3.persistencetier.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import via.sep3.persistencetier.database.customer.Customer;
import via.sep3.persistencetier.database.customer.CustomerRepository;
import via.sep3.persistencetier.database.rating.RatingHistory;
import via.sep3.persistencetier.database.rating.RatingHistoryRepository;
import via.sep3.persistencetier.database.seller.Seller;
import via.sep3.persistencetier.database.seller.SellerAnalyticsRepository;
import via.sep3.persistencetier.database.seller.SellerRepository;
import via.sep3.persistencetier.protobuf.*;

import java.util.List;

@GRpcService
public class RatingHistoryDao extends RatingHistoryServiceGrpc.RatingHistoryServiceImplBase {
    private final CustomerRepository customerRepository;
    private final SellerRepository sellerRepository;
    private final RatingHistoryRepository ratingHistoryRepository;
    private final SellerAnalyticsRepository sellerAnalyticsRepository;

    @Autowired
    public RatingHistoryDao(CustomerRepository customerRepository,
                            SellerRepository sellerRepository, RatingHistoryRepository ratingHistoryRepository,
                            SellerAnalyticsRepository sellerAnalyticsRepository) {
        this.customerRepository = customerRepository;
        this.sellerRepository = sellerRepository;
        this.ratingHistoryRepository = ratingHistoryRepository;
        this.sellerAnalyticsRepository = sellerAnalyticsRepository;
    }


    @Override
    public void createRating(CreateRatingHistoryRequest request, StreamObserver<RatingHistoryResponse> responseObserver) {
        Customer customer = customerRepository.findByEmail(request.getCustomerEmail());
        Seller seller = sellerRepository.findByCvr((long) request.getCvr());

        RatingHistory reservation = new RatingHistory(
                request.getRating(),
                customer,
                seller
        );

        var ratingHistory = ratingHistoryRepository.save(reservation);


        List<Float> ratings = ratingHistoryRepository.getAllRatingsBySeller(seller.getCvr().intValue());

        double averageRating = ratings.stream().mapToDouble(d->d).average().orElse(0.0);
        sellerAnalyticsRepository.updateRating(averageRating, seller);


        ratingHistoryResponseBuilder(ratingHistory, responseObserver);
        responseObserver.onCompleted();
    }

    private void ratingHistoryResponseBuilder(RatingHistory ratingHistory, StreamObserver<RatingHistoryResponse> responseObserver){

        RatingHistoryResponse.Builder builder = RatingHistoryResponse.newBuilder()
                .setRating(ratingHistory.getRating())
                .setCvr(ratingHistory.getSeller().getCvr().intValue())
                .setCustomerEmail(ratingHistory.getCustomer().getEmail());


        var response = builder.build();

        responseObserver.onNext(response);
    }
}
