package via.sep3.persistencetier.service;

import io.grpc.stub.StreamObserver;
import org.springframework.beans.factory.annotation.Autowired;
import via.sep3.persistencetier.database.Address;
import via.sep3.persistencetier.database.customer.Customer;
import via.sep3.persistencetier.database.customer.CustomerRepository;
import via.sep3.persistencetier.protobuf.*;


public class CustomerService extends CustomerServiceGrpc.CustomerServiceImplBase{

    @Autowired
    CustomerRepository customerRepository;


    @Override
    public void createCustomer(CreateCustomerRequest request, StreamObserver<CustomerResponse> responseObserver) {
        System.out.println("Creating a new customer");


        Customer customer = new Customer(
                request.getUser().getFirstName(),
                request.getUser().getLastName(),
                new Address(
                        request.getUser().getAddress().getCity(),
                        request.getUser().getAddress().getStreetName(),
                        request.getUser().getAddress().getPostCode()
                ),
                (long) request.getUser().getPhoneNumber(),
                request.getUser().getEmail(),
                request.getPreference()
        );

        var savedCustomer = customerRepository.save(customer);

        customerResponseBuilder(responseObserver, savedCustomer);
    }



    private void customerResponseBuilder(StreamObserver<CustomerResponse> responseObserver, Customer customer) {
        CustomerResponse.Builder builder = CustomerResponse.newBuilder();
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
        builder.setPreference(customer.getPreferences());

        var response = builder
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }






}
