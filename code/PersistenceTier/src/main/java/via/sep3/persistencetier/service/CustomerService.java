package via.sep3.persistencetier.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import via.sep3.persistencetier.database.userInfo.Address;
import via.sep3.persistencetier.database.customer.Customer;
import via.sep3.persistencetier.database.customer.CustomerRepository;
import via.sep3.persistencetier.database.customer.Preference;
import via.sep3.persistencetier.database.customer.PreferenceRepository;
import via.sep3.persistencetier.database.foodPack.PackRepository;
import via.sep3.persistencetier.protobuf.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@GRpcService
@Transactional
public class CustomerService extends CustomerServiceGrpc.CustomerServiceImplBase{

    final
    CustomerRepository CUSTOMER_REPOSITORY;

    final
    PackRepository PACK_REPOSITORY;

    final
    PreferenceRepository PREFERENCE_REPOSITORY;
    @Autowired
    public CustomerService(CustomerRepository customerRepository, PackRepository packRepository, PreferenceRepository preferenceRepository) {
        this.CUSTOMER_REPOSITORY = customerRepository;
        this.PACK_REPOSITORY = packRepository;
        this.PREFERENCE_REPOSITORY = preferenceRepository;
    }


    @Override
    public void createCustomer(CreateCustomerRequest request, StreamObserver<CustomerResponse> responseObserver) {
        System.out.println("Creating a new customer");

        List<Preference> preferenceList = new ArrayList<>();

        Customer customer = new Customer(
                request.getUser().getFirstName(),
                request.getUser().getLastName(),
                new Address(
                        request.getUser().getAddress().getCity(),
                        request.getUser().getAddress().getStreetName(),
                        request.getUser().getAddress().getPostCode()
                ),
                (long) request.getUser().getPhoneNumber(),
                request.getUser().getPassword(),
                request.getUser().getEmail(),
                request.getUser().getRole(),
                preferenceList
        );
        for(String preference : request.getPreferenceList())
        {
            preferenceList.add(new Preference(preference, customer));
        }

        var savedCustomer = CUSTOMER_REPOSITORY.save(customer);

        customerResponseBuilder(responseObserver, savedCustomer);
    }

    @Override
    public void getAllCustomers(EmptyCustomer empty, StreamObserver<CustomerResponse> responseObserver)
    {
        CustomerResponse.Builder customerResponseBuilder = CustomerResponse.newBuilder();
        Stream<Customer> customerList = CUSTOMER_REPOSITORY.findAllStream();
        customerList.forEach(customer ->{

            customerResponseBuilder
                    .setUser(
                            UserModelResponseCustomer.newBuilder()
                                    .setFirstName(customer.getFirstName())
                                    .setLastName(customer.getLastName())
                                    .setAddress(
                                            AddressModelCustomer.newBuilder()
                                                    .setCity(customer.getAddress().getCity())
                                                    .setStreetName(customer.getAddress().getStreetName())
                                                    .setPostCode(customer.getAddress().getPostcode())
                                    )
                                    .setPhoneNumber(customer.getPhoneNumber().intValue())
                                    .setEmail(customer.getEmail())
                                    .setPassword(customer.getPassword())
                    );

            List<String> preferences = new ArrayList<>();
            for(int i=0; i<customer.getPreference().size(); i++)
            {
                preferences.add(customer.getPreference().get(i).getPreference());
            }
            customerResponseBuilder.addAllPreference(preferences);

            System.out.println(customer.getEmail());
            responseObserver.onNext(customerResponseBuilder.build());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getCustomerByEmail(CustomerRequest request, StreamObserver<CustomerResponse> responseObserver) {
        var customer = CUSTOMER_REPOSITORY.findByEmail(request.getEmail());
        customerResponseBuilder(responseObserver, customer);
    }

    @Override
    public void deleteCustomerByEmail(CustomerRequest request, StreamObserver<CustomerResponse> responseObserver) {


        Customer customer = CUSTOMER_REPOSITORY.findByEmail(request.getEmail());
        PREFERENCE_REPOSITORY.deleteByCustomer(customer);
        CUSTOMER_REPOSITORY.deleteByEmail(request.getEmail());
        customerResponseBuilder(responseObserver, customer);

/*

        Stream<Preference> preferencesToRemove = preferenceRepository.findByEmail(request.getEmail());
        preferencesToRemove.forEach(preference -> {
            System.out.println(preference.getPreference());
            preferenceRepository.deleteById(preference.getId());
        });
        Customer customer = customerRepository.findByEmail(request.getEmail());
        customerRepository.deleteByEmail(request.getEmail());
        customerResponseBuilder(responseObserver, customerRepository.findByEmail(request.getEmail()));


 */
        /*
        Stream<String> preferencesToRemove = preferenceRepository.findByEmail(request.getEmail());
        Customer customer = customerRepository.findByEmail(request.getEmail());

        preferencesToRemove.forEach(preference ->{
            customer.getPreference().remove(preference);
        });
        preferenceRepository.delete();

        customerResponseBuilder(responseObserver, customer);
  */
    }

    private void customerResponseBuilder(StreamObserver<CustomerResponse> responseObserver, Customer customer) {
        CustomerResponse.Builder builder = CustomerResponse.newBuilder();
        if(customer == null)
        {
            builder.setUser(
                    UserModelResponseCustomer.newBuilder()
                            .setFirstName("")
                            .setLastName("")
                            .setAddress(
                                    AddressModelCustomer.newBuilder()
                                            .setCity("")
                                            .setStreetName("")
                                            .setPostCode(0)
                            )
                            .setPhoneNumber(0)
                            .setEmail("")
            )
                    .addPreference("");
        }
        else{
            builder.setUser(
                    UserModelResponseCustomer.newBuilder()
                            .setFirstName(customer.getFirstName())
                            .setLastName(customer.getLastName())
                            .setAddress(
                                    AddressModelCustomer.newBuilder()
                                            .setCity(customer.getAddress().getCity())
                                            .setStreetName(customer.getAddress().getStreetName())
                                            .setPostCode(customer.getAddress().getPostcode())
                            )
                            .setPhoneNumber(customer.getPhoneNumber().intValue())
                            .setEmail(customer.getEmail())
            );
            if(customer.getPreference() == null)
            {
                builder.setPreference(0, "");
            }
            else{
                List<String> tempList = new ArrayList<>();
                for(int i=0; i<customer.getPreference().size(); i++)
                {
                    tempList.add(customer.getPreference().get(i).getPreference());
                }
                builder.addAllPreference(tempList);
            }
        }

        var response = builder
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
