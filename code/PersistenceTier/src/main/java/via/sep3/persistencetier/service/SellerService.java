package via.sep3.persistencetier.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import via.sep3.persistencetier.database.Address;
import via.sep3.persistencetier.database.Seller;
import via.sep3.persistencetier.database.SellerRepository;
import via.sep3.persistencetier.protobuf.*;

@GRpcService
public class SellerService extends SellerServiceGrpc.SellerServiceImplBase {

    @Autowired
    SellerRepository sellerRepository;
    @Override
    public void createSeller(CreateSellerRequest request, StreamObserver<SellerResponse> responseObserver) {
        System.out.println("Creating a new seller");

        Seller seller = new Seller(
                request.getUser().getFirstName(),
                request.getUser().getLastName(),
                new Address(
                        request.getUser().getAddress().getCity(),
                        request.getUser().getAddress().getStreetName(),
                        request.getUser().getAddress().getPostCode()
                ),
                (long) request.getUser().getPhoneNumber(),
                request.getUser().getEmail(),
                (long) request.getCvr(),
                request.getCompanyName(),
                request.getDescription(),
                request.getType(),
                request.getWebsite(),
                request.getRating()
        );

        var savedSeller = sellerRepository.save(seller);

        sellerResponseBuilder(responseObserver, savedSeller);
    }

    @Override
    public void getSellerByCvr(SellerRequest request, StreamObserver<SellerResponse> responseObserver) {
        var seller = sellerRepository.getReferenceById((long) request.getId());
        sellerResponseBuilder(responseObserver, seller);
    }

    @Override
    public void deleteSellerByCvr(SellerRequest request, StreamObserver<SellerResponse> responseObserver) {
        Seller seller = sellerRepository.getReferenceById((long) request.getId());
        sellerRepository.delete(seller);

        sellerResponseBuilder(responseObserver, seller);
    }

    private void sellerResponseBuilder(StreamObserver<SellerResponse> responseObserver, Seller seller) {
        SellerResponse.Builder builder = SellerResponse.newBuilder();
        builder.setUser(
                UserModelResponseSeller.newBuilder()
                        .setId(seller.getCvr().intValue())
                        .setFirstName(seller.getFirstName())
                        .setLastName(seller.getLastName())
                        .setAddress(
                                AddressModelSeller.newBuilder()
                                        .setCity(seller.getAddress().getCity())
                                        .setStreetName(seller.getAddress().getStreetName())
                                        .setPostCode(seller.getAddress().getPostcode())
                        )
                        .setPhoneNumber(seller.getPhoneNumber().intValue())
                        .setEmail(seller.getEmail())
        );
        builder.setCvr(seller.getCvr().intValue());
        builder.setCompanyName(seller.getCompanyName());
        builder.setDescription(seller.getDescription());
        builder.setType(seller.getType());
        builder.setWebsite(seller.getWebsite());
        builder.setRating(seller.getRating().floatValue());
        var response = builder
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
