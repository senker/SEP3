package via.sep3.persistencetier.service;


import com.google.common.base.Splitter;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import via.sep3.persistencetier.database.userInfo.Address;
import via.sep3.persistencetier.database.foodPack.PackRepository;
import via.sep3.persistencetier.database.seller.Image;
import via.sep3.persistencetier.database.seller.ImageRepository;
import via.sep3.persistencetier.database.seller.Seller;
import via.sep3.persistencetier.database.seller.SellerRepository;
import via.sep3.persistencetier.database.userInfo.AddressRepository;
import via.sep3.persistencetier.protobuf.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@GRpcService
@Transactional
public class SellerDao extends SellerServiceGrpc.SellerServiceImplBase {

    final
    SellerRepository sellerRepository;

    final
    PackRepository packRepository;

    final
    ImageRepository imageRepository;

    final AddressRepository addressRepository;

    @Autowired
    public SellerDao(SellerRepository sellerRepository,
                     PackRepository packRepository,
                     ImageRepository imageRepository,
                     AddressRepository addressRepository
                         ) {
        this.sellerRepository = sellerRepository;
        this.packRepository = packRepository;
        this.imageRepository = imageRepository;
        this.addressRepository = addressRepository;
    }


    @Override
    public void createSeller(CreateSellerRequest request, StreamObserver<SellerResponse> responseObserver) {
        String s = request.getImage().getImageUrl();
        int chunkSize = 8000;
        Iterable<String> chunks = Splitter.fixedLength(chunkSize).split(s);

        List<Image> listOfPartialImage = new ArrayList<>();

           // byte[] byteData = request.getImage().getImageUrl().getBytes();

      //  Address address = addressRepository.findByStreet(request.getUser().getAddress().getStreetName());

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
                    request.getUser().getPassword(),
                    request.getUser().getRole(),
                    (long) request.getCvr(),
                    request.getCompanyName(),
                    request.getDescription(),
                    request.getType(),
                    request.getWebsite(),
                    request.getRating(),
                    null,
                    null
            );

        for(String chunk : chunks)
        {
            listOfPartialImage.add(new Image(chunk, seller));
        }

        seller.setImage(listOfPartialImage);


        var savedSeller = sellerRepository.save(seller);

        sellerResponseBuilder(responseObserver, savedSeller);
    }

    @Override
    public void getAllSellers(EmptySeller empty, StreamObserver<SellerResponse> responseObserver)
    {


        SellerResponse.Builder sellerResponseBuilder = SellerResponse.newBuilder();
        Stream<Seller> sellerList = sellerRepository.findAllStream();
        sellerList.forEach(seller ->{

                    String fullImageUrl="";
                    List<Image> sellerPartialImages = seller.getImage();
                    if(sellerPartialImages == null) System.out.println("seller images list is null");
                    for(Image image : sellerPartialImages)
                    {
                        System.out.println("partial image");
                        System.out.println("partial image url: " + image.getPartialImage());
                        fullImageUrl+=image.getPartialImage();
                    }
                    System.out.println("full image Url: " + fullImageUrl);


                    sellerResponseBuilder
                            .setUser(
                                    UserModelResponseSeller.newBuilder()
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
                            )
                            .setCvr(seller.getCvr().intValue())
                            .setCompanyName(seller.getCompanyName())
                            .setDescription(seller.getDescription())
                            .setType(seller.getType())
                            .setWebsite(seller.getWebsite())
                            .setRating(seller.getRating())
                            .setImage(
                                    ImageModelRequestSeller.newBuilder()
                                            .setImageUrl(fullImageUrl)
                            );
            System.out.println(seller.getCvr());
                            responseObserver.onNext(sellerResponseBuilder.build());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getSellerByCvr(SellerRequest request, StreamObserver<SellerResponse> responseObserver) {
        var seller = sellerRepository.findByCvr((long) request.getCvr());
        sellerResponseBuilder(responseObserver, seller);
    }

    @Override
    public void deleteSellerByCvr(SellerRequest request, StreamObserver<SellerResponse> responseObserver) {
        Seller seller = sellerRepository.findByCvr((long) request.getCvr());

        packRepository.deleteBySeller(seller);
        imageRepository.deleteBySeller(seller);
        sellerRepository.deleteByCvr((long) request.getCvr());
        sellerResponseBuilder(responseObserver, seller);
    }

    private void sellerResponseBuilder(StreamObserver<SellerResponse> responseObserver, Seller seller) {
        String fullImageUrl="";
        List<Image> sellerPartialImages = seller.getImage();
        for(Image image : sellerPartialImages)
        {
            fullImageUrl+=image.getPartialImage();
        }

        SellerResponse.Builder builder = SellerResponse.newBuilder();
        builder.setUser(
                UserModelResponseSeller.newBuilder()
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
        builder.setImage(ImageModelRequestSeller.newBuilder().setImageUrl(fullImageUrl));
        var response = builder
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void getSellerByEmail(SellerRequestEmail request, StreamObserver<SellerResponse> responseObserver) {
        var seller = sellerRepository.findByEmail(request.getEmail());
        sellerResponseBuilder(responseObserver, seller);
    }
}
