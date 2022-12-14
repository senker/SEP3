package via.sep3.persistencetier.DAO;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import via.sep3.persistencetier.database.customer.Customer;
import via.sep3.persistencetier.database.customer.CustomerRepository;
import via.sep3.persistencetier.database.seller.Seller;
import via.sep3.persistencetier.database.seller.SellerRepository;
import via.sep3.persistencetier.database.subscription.Subscription;
import via.sep3.persistencetier.database.subscription.SubscriptionRepository;
import via.sep3.persistencetier.protobuf.*;

import javax.transaction.Transactional;

@GRpcService
@Transactional
public class SubscriptionDao extends SubscriptionServiceGrpc.SubscriptionServiceImplBase {

    final
    SubscriptionRepository subscriptionRepository;

    final
    SellerRepository sellerRepository;

    final
    CustomerRepository customerRepository;
@Autowired
    public SubscriptionDao(SubscriptionRepository subscriptionRepository, SellerRepository sellerRepository, CustomerRepository customerRepository) {
        this.subscriptionRepository = subscriptionRepository;
        this.sellerRepository = sellerRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void createSubscription(CreateSubscriptionRequest request, StreamObserver<CreateSubscriptionResponse> responseObserver)
    {

        Seller seller = sellerRepository.findByCvr((long) request.getCvr());
        System.out.println(seller.getRating());
        System.out.println(seller.getCompanyName());

        Customer customer = customerRepository.findByEmail(request.getCustomerEmail());

        Subscription subscription = new Subscription(
                seller,
                customer
        );
        subscriptionRepository.save(subscription);

        subscriptionResponseBuilder(responseObserver, subscription);
    }

    private void subscriptionResponseBuilder(StreamObserver<CreateSubscriptionResponse> responseObserver, Subscription subscription) {
        CreateSubscriptionResponse.Builder builder = CreateSubscriptionResponse.newBuilder();
        builder
                .setCvr(subscription.getSellerId().getCvr().intValue())
                .setCustomerEmail(subscription.getCustomerId().getEmail());

        var response = builder
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
