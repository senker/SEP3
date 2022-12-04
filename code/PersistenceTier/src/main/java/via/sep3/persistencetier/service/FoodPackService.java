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


    @Override
    public void searchFoodPacks(SearchFoodPacks request, StreamObserver<FoodPackResponse> responseObserver)
    {
        FoodPackResponse.Builder foodPackResponseBuilder = FoodPackResponse.newBuilder();

            String title;
            boolean isPrepared;
            String type;
            Double price;
            Integer postCode;

            title = request.getTitle();
            isPrepared=request.getIsPrepared();
            type = request.getType();
            postCode = request.getPostcode();
            price = request.getPrice()==0 ? 0 : request.getPrice();


            Stream<FoodPack> streamOfSellers;

           if(price==0)
           {
               streamOfSellers = packRepository.searchPacks(title, isPrepared, type, postCode);
           }
           else{
               streamOfSellers = packRepository.searchPacks(title, isPrepared, type, price, postCode);
           }

           streamOfSellers.forEach(pack -> {
               foodPackResponseBuilder
                       .setId(pack.getId())
                       .setTitle(pack.getTitle())
                       .setDescription(pack.getDescription())
                       .setType(pack.getType())
                       .setIsPrepared(pack.isIs_prepared())
                       .setPrice(pack.getPrice());
               responseObserver.onNext(foodPackResponseBuilder.build());
           });
        responseObserver.onCompleted();

    }



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
