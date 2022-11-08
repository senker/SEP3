package via.sep3.persistencetier.service;

import io.grpc.stub.StreamObserver;
import via.sep3.persistencetier.database.Seller;
import via.sep3.persistencetier.database.SellerRepository;
import via.sep3.persistencetier.protobuf.CreateSellerResponse;
import via.sep3.persistencetier.protobuf.SellerRequest;
import via.sep3.persistencetier.protobuf.SellerResponse;
import via.sep3.persistencetier.protobuf.SellerServiceGrpc;
import via.sep3.persistencetier.server.DB;

public class SellerService extends SellerServiceGrpc.SellerServiceImplBase {

    @Override
    public void createSeller(CreateSellerResponse request, StreamObserver<SellerResponse> responseObserver) {
        Seller sellerFromDB = DB.createSeller(request);


    }

    @Override
    public void getSellerById(SellerRequest request, StreamObserver<SellerResponse> responseObserver) {
        super.getSellerById(request, responseObserver);
    }
}
