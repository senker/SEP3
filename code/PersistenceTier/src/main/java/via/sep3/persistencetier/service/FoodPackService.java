package via.sep3.persistencetier.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import via.sep3.persistencetier.database.foodPack.FoodPack;
import via.sep3.persistencetier.database.foodPack.PackRepository;
import via.sep3.persistencetier.protobuf.*;

import javax.transaction.Transactional;
import java.util.stream.Stream;

@GRpcService
@Transactional
public class FoodPackService extends FoodPackServiceGrpc.FoodPackServiceImplBase {

@Autowired
PackRepository packRepository;

@Override
    public void createFoodPack(CreateFoodPackRequest packRequest, StreamObserver<FoodPackResponse> responseObserver){
    FoodPack foodPack = new FoodPack(
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
public void getFoodPackById(FoodPackRequest foodPackRequest, StreamObserver<FoodPackResponse> responseObserver) {
    var foodPack = packRepository.findById(foodPackRequest.getId());
    foodPackResponseBuilder(responseObserver, foodPack);
}

@Override
public void deleteFoodPackById(FoodPackRequest foodPackRequest, StreamObserver<FoodPackResponse> responseObserver) {
    var foodPack = packRepository.deleteById(foodPackRequest.getId());
    foodPackResponseBuilder(responseObserver, foodPack);
}

/*
    @Override
    public void searchFoodPacks(SearchFoodPacks request, StreamObserver<FoodPackResponse> responseObserver)
    {
        FoodPackResponse.Builder foodPackResponseBuilder = FoodPackResponse.newBuilder();
        Stream<FoodPack> foodPackList = packRepository.findAllStream();
        foodPackList.forEach(pack ->{

            String title = "";
            boolean isPrepared = false;
            String type = "";
            Double price = Double.valueOf(0);
            Integer postCode = 0;

            if(pack.getTitle().toLowerCase().contains(request.getTitle().toLowerCase())) title = request.getTitle();
            if(pack.isIs_prepared() == request.getIsPrepared() == true) isPrepared=true;
            if(pack.getType().toLowerCase().equals().)
            && ())



            pack.getTitle().equals(request.getTitle()) ?


                    foodPackResponseBuilder
                            .setTitle()
                            .setDescription()
        });
    }

 */


private void foodPackResponseBuilder(StreamObserver<FoodPackResponse> responseObserver, FoodPack foodPack){
    FoodPackResponse.Builder builder = FoodPackResponse.newBuilder()
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
