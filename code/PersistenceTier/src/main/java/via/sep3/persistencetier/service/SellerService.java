package via.sep3.persistencetier.service;

import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import via.sep3.persistencetier.database.Seller;
import via.sep3.persistencetier.database.SellerRepository;
import via.sep3.persistencetier.protobuf.CreateSellerResponse;
import via.sep3.persistencetier.protobuf.SellerRequest;
import via.sep3.persistencetier.protobuf.SellerResponse;
import via.sep3.persistencetier.protobuf.SellerServiceGrpc;

public class SellerService extends SellerServiceGrpc.SellerServiceImplBase {

    @Autowired
    SellerRepository sellerRepository;
    @Override
    public void createSeller(CreateSellerResponse request, StreamObserver<SellerResponse> responseObserver) {
        Seller seller = new Seller(
                request.getUser().getFirstName(),
                request.getUser().getLastName(),
                request.getUser().getAddress(),
                request.getUser().getPhoneNumber(),
                request.get);

        sellerRepository.save(seller);


    }

    @Override
    public void getSellerById(SellerRequest request, StreamObserver<SellerResponse> responseObserver) {
        super.getSellerById(request, responseObserver);

        sellerRepository.getReferenceById((long) request.getId());
    }
}
