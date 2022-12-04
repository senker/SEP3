package via.sep3.persistencetier.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import via.sep3.persistencetier.database.foodPack.FoodPack;
import via.sep3.persistencetier.database.foodPack.PackRepository;
import via.sep3.persistencetier.protobuf.*;

import javax.transaction.Transactional;

@GRpcService
@Transactional
public class FoodPackService extends FoodPackServiceGrpc.FoodPackServiceImplBase {

@Autowired
PackRepository packRepository;

@Override
    public void createFoodPack(createFoodPackRequest packRequest, StreamObserver<foodPackRespons> responseObserver){
    FoodPack foodPack = new FoodPack(
            packRequest.getId(),
            packRequest.getTitle(),
            packRequest.getDescription(),
            packRequest.getType(),
            packRequest.getIsPrepared(),
            packRequest.getPrice(),
            null
    );
    var savedFoodPack = packRepository.save(foodPack);
    foodPackResponseBuilder(responseObserver, savedFoodPack);
}

@Override
public void getFoodPackById(foodPackRequest foodPackRequest, StreamObserver<foodPackRespons> responseObserver) {
    var foodPack = packRepository.findById(foodPackRequest);
    foodPackResponseBuilder(responseObserver, foodPack);
}

@Override
public void deleteFoodPack(foodPackRequest foodPackRequest, StreamObserver<foodPackRespons> responseObserver) {
    var foodPack = packRepository.deleteById(foodPackRequest);
    foodPackResponseBuilder(responseObserver, foodPack);
}


private void foodPackResponseBuilder(StreamObserver<foodPackRespons> responseObserver, FoodPack foodPack){
    foodPackRespons.Builder builder = foodPackRespons.newBuilder()
            .setId(foodPack.getId())
            .setType(foodPack.getType())
            .setDescription(foodPack.getDescription())
            .setTitle(foodPack.getTitle())
            .setPrice(foodPack.getPrice())
            .setIsPrepared(foodPack.isIs_prepared());

            var response = builder.build();

    responseObserver.onNext(response);
    responseObserver.onCompleted();




}


}
