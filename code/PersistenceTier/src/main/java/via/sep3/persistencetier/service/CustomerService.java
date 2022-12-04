package via.sep3.persistencetier.service;

import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;
import via.sep3.persistencetier.database.Address;
import via.sep3.persistencetier.database.customer.Customer;
import via.sep3.persistencetier.database.customer.CustomerRepository;
import via.sep3.persistencetier.database.customer.Preference;
import via.sep3.persistencetier.protobuf.*;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@GRpcService
@Transactional
public class CustomerService extends CustomerServiceGrpc.CustomerServiceImplBase{

    @Autowired
    CustomerRepository customerRepository;


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
                request.getUser().getEmail(),
                request.getUser().getPassword(),
                preferenceList
        );
        for(String preference : request.getPreferenceList())
        {
            preferenceList.add(new Preference(preference, customer));
        }

        var savedCustomer = customerRepository.save(customer);

        customerResponseBuilder(responseObserver, savedCustomer);
    }

    @Override
    public void getAllCustomers(EmptyCustomer empty, StreamObserver<CustomerResponse> responseObserver)
    {
        CustomerResponse.Builder customerResponseBuilder = CustomerResponse.newBuilder();
        Stream<Customer> customerList = customerRepository.findAllStream();
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
            for(int i=0; i<customer.getPreference().size(); i++)
            {
                customerResponseBuilder.setPreference(i, customer.getPreference().get(i).getPreference());
            }
            System.out.println(customer.getEmail());
            responseObserver.onNext(customerResponseBuilder.build());
        });
        responseObserver.onCompleted();
    }

    @Override
    public void getCustomerByEmail(CustomerRequest request, StreamObserver<CustomerResponse> responseObserver) {
        var customer = customerRepository.findByEmail(request.getEmail());
        customerResponseBuilder(responseObserver, customer);
    }

    @Override
    public void deleteCustomerByEmail(CustomerRequest request, StreamObserver<CustomerResponse> responseObserver) {
        var customer = customerRepository.deleteByEmail(request.getEmail());
        customerResponseBuilder(responseObserver, customer);
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
        for(int i=0; i<customer.getPreference().size(); i++)
        {
            builder.setPreference(i, customer.getPreference().get(i).getPreference());
        }

        var response = builder
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }






}
