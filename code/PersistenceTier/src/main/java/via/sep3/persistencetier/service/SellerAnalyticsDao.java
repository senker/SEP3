package via.sep3.persistencetier.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import via.sep3.persistencetier.database.seller.Seller;
import via.sep3.persistencetier.database.seller.SellerAnalytics;
import via.sep3.persistencetier.database.seller.SellerAnalyticsRepository;
import via.sep3.persistencetier.database.seller.SellerRepository;
import via.sep3.persistencetier.protobuf.*;

@GRpcService
public class SellerAnalyticsDao extends SellerAnalyticsServiceGrpc.SellerAnalyticsServiceImplBase {

    private final SellerRepository sellerRepository;
    private final SellerAnalyticsRepository sellerAnalyticsRepository;


    @Autowired
    public SellerAnalyticsDao(SellerRepository sellerRepository,
                              SellerAnalyticsRepository sellerAnalyticsRepository) {
        this.sellerRepository = sellerRepository;
        this.sellerAnalyticsRepository = sellerAnalyticsRepository;
    }



    @Override
    public void createSellerAnalytics(CreateSellerAnalyticsRequest request, StreamObserver<SellerAnalyticsResponse> responseObserver)
    {
        Seller seller = sellerRepository.findByCvr((long) request.getCvr());
        SellerAnalytics sellerAnalytics = new SellerAnalytics(
                seller,
                request.getRating()
        );
        var savedSellerAnalytics = sellerAnalyticsRepository.save(sellerAnalytics);


        sellerAnalyticsResponseBuilder(savedSellerAnalytics, responseObserver);
        responseObserver.onCompleted();
    }

    public void getAnalyticsBySellerCvr(SellerAnalyticsRatingRequest request, StreamObserver<SellerAnalyticsResponse> responseObserver)
    {
        sellerAnalyticsRepository.findByCvr(request.getCvr());
    }

    private void sellerAnalyticsResponseBuilder(SellerAnalytics sellerAnalytics, StreamObserver<SellerAnalyticsResponse> responseObserver){

        SellerAnalyticsResponse.Builder builder = SellerAnalyticsResponse.newBuilder()
                .setRating(sellerAnalytics.getRating())
                .setCvr(sellerAnalytics.getSeller().getCvr().intValue());


        var response = builder.build();

        responseObserver.onNext(response);
    }
}
