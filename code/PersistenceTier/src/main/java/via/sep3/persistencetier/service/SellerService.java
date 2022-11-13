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

        var response = SellerResponse.newBuilder()
                .setUser(
                        UserModelResponse.newBuilder()
                                .setId(savedSeller.getCvr().intValue())
                                .setFirstName(savedSeller.getFirstName())
                                .setLastName(savedSeller.getLastName())
                                .setAddress(
                                        AddressModel.newBuilder()
                                                .setCity(savedSeller.getAddress().getCity())
                                                .setStreetName(savedSeller.getAddress().getStreetName())
                                                .setPostCode(savedSeller.getAddress().getPostcode())
                                )
                                .setPhoneNumber(savedSeller.getPhoneNumber().intValue())
                                .setEmail(savedSeller.getEmail())
                )
                .setCvr(savedSeller.getCvr().intValue())
                .setCompanyName(savedSeller.getCompanyName())
                .setDescription(savedSeller.getDescription())
                .setType(savedSeller.getType())
                .setWebsite(savedSeller.getWebsite())
                .setRating(savedSeller.getRating().floatValue())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getSellerByCvr(SellerRequest request, StreamObserver<SellerResponse> responseObserver) {
        super.getSellerByCvr(request, responseObserver);

        sellerRepository.getReferenceById((long) request.getId());
        SellerResponse.Builder response = SellerResponse.newBuilder();
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
