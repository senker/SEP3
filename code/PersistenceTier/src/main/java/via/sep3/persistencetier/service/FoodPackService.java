package via.sep3.persistencetier.service;

import io.grpc.stub.StreamObserver;
import net.bytebuddy.utility.nullability.AlwaysNull;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import via.sep3.persistencetier.database.AddressRepository;
import via.sep3.persistencetier.database.foodPack.FoodPack;
import via.sep3.persistencetier.database.foodPack.PackRepository;
import via.sep3.persistencetier.database.seller.Seller;
import via.sep3.persistencetier.database.seller.SellerRepository;
import via.sep3.persistencetier.protobuf.*;

import javax.transaction.Transactional;
import java.util.stream.Stream;

@GRpcService
@Transactional
public class FoodPackService extends FoodPackServiceGrpc.FoodPackServiceImplBase {

@Autowired
PackRepository packRepository;

@Autowired
    SellerRepository sellerRepository;

@Autowired
    AddressRepository addressRepository;

@Override
    public void createFoodPack(CreateFoodPackRequest packRequest, StreamObserver<FoodPackResponse> responseObserver){
    FoodPack foodPack = new FoodPack(
            packRequest.getTitle(),
            packRequest.getDescription(),
            packRequest.getType(),
            packRequest.getIsPrepared(),
            packRequest.getPrice(),
            sellerRepository.findByCvr((long) packRequest.getCvr())
    );
    var savedFoodPack = packRepository.save(foodPack);
    foodPackResponseBuilder(responseObserver, savedFoodPack);
}

@Override
    public void getAllFoodPacks(EmptyFoodPack packRequest, StreamObserver<FoodPackResponse> responseObserver)
{
    FoodPackResponse.Builder foodPackResponseBuilder = FoodPackResponse.newBuilder();
    Stream<FoodPack> foodPackStream = packRepository.findAllStream();

    foodPackStream.forEach(pack ->{
       foodPackResponseBuilder
               .setId(pack.getId())
               .setTitle(pack.getTitle())
               .setDescription(pack.getDescription())
               .setIsPrepared(pack.isIs_prepared())
               .setPrice(pack.getPrice());
        responseObserver.onNext(foodPackResponseBuilder.build());
    });
    responseObserver.onCompleted();
}

@Override
public void getFoodPackById(FoodPackRequest foodPackRequest, StreamObserver<FoodPackResponse> responseObserver) {
    var foodPack = packRepository.findById(foodPackRequest.getId());
    foodPackResponseBuilder(responseObserver, foodPack);
}

@Override
public void getFoodPacksBySellerCvr(FoodPackSellerRequest foodPackSellerRequest, StreamObserver<FoodPackResponse> responseObserver)
{
    System.out.println("Inside get food packs by seller cvr");
    FoodPackResponse.Builder response = FoodPackResponse.newBuilder();
    Seller seller = sellerRepository.findByCvr((long) foodPackSellerRequest.getCvr());
    Stream<FoodPack> foodPackStream = packRepository.findBySeller(seller);

    foodPackStream.forEach(pack ->{
        response
                .setId(pack.getId())
                .setTitle(pack.getTitle())
                .setDescription(pack.getDescription())
                .setType(pack.getType())
                .setIsPrepared(pack.isIs_prepared())
                .setPrice(pack.getPrice());
        responseObserver.onNext(response.build());
    });
    responseObserver.onCompleted();
}


@Override
public void deleteFoodPackById(FoodPackRequest foodPackRequest, StreamObserver<FoodPackResponse> responseObserver) {
    FoodPack foodPack = packRepository.findById(foodPackRequest.getId());
    packRepository.deleteById(foodPackRequest.getId());
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
            price = request.getPrice();

            Long address_id = addressRepository.findByPostCode(postCode);

            Stream<FoodPack> streamOfSellers;

            Long cvr = sellerRepository.findByAddressId(address_id);

           if(price==0)
           {
               streamOfSellers = packRepository.searchPacks(title, isPrepared, type, cvr);
           }
           else{
               streamOfSellers = packRepository.searchPacks(title, isPrepared, type, price, cvr);
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
