package via.sep3.persistencetier.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import via.sep3.persistencetier.database.Address;
import via.sep3.persistencetier.database.Seller;
import via.sep3.persistencetier.database.SellerRepository;
import via.sep3.persistencetier.protobuf.CreateSellerResponse;
import via.sep3.persistencetier.protobuf.SellerRequest;
import via.sep3.persistencetier.protobuf.SellerResponse;
import via.sep3.persistencetier.protobuf.SellerServiceGrpc;

@GRpcService
public class SellerService extends SellerServiceGrpc.SellerServiceImplBase {

    @Autowired
    SellerRepository sellerRepository;
    @Override
    public void createSeller(CreateSellerResponse request, StreamObserver<SellerResponse> responseObserver) {


        Seller seller = new Seller(
                request.getUser().getFirstName(),
                request.getUser().getLastName(),
                new Address(
                        request.getUser().getAddress().getCity(),
                        request.getUser().getAddress().getStreetName(),
                        request.getUser().getAddress().getPostCode()),
                (long) request.getUser().getPhoneNumber(),
                request.getUser().getEmail(),
                (long) request.getCvr(),
                request.getCompanyName(),
                request.getDescription(),
                request.getType(),
                request.getWebsite(),
                request.getRating()
        );



        sellerRepository.save(seller);

        SellerResponse.Builder response = SellerResponse.newBuilder();

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();

    }

    @Override
    public void getSellerById(SellerRequest request, StreamObserver<SellerResponse> responseObserver) {
        super.getSellerById(request, responseObserver);

        sellerRepository.getReferenceById((long) request.getId());
        SellerResponse.Builder response = SellerResponse.newBuilder();
        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}