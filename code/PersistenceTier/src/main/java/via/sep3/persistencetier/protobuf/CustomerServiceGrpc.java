package via.sep3.persistencetier.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: CustomerProto.proto")
public final class CustomerServiceGrpc {

  private CustomerServiceGrpc() {}

  public static final String SERVICE_NAME = "customer.CustomerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.CreateCustomerRequest,
      via.sep3.persistencetier.protobuf.CustomerResponse> getCreateCustomerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createCustomer",
      requestType = via.sep3.persistencetier.protobuf.CreateCustomerRequest.class,
      responseType = via.sep3.persistencetier.protobuf.CustomerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.CreateCustomerRequest,
      via.sep3.persistencetier.protobuf.CustomerResponse> getCreateCustomerMethod() {
    io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.CreateCustomerRequest, via.sep3.persistencetier.protobuf.CustomerResponse> getCreateCustomerMethod;
    if ((getCreateCustomerMethod = CustomerServiceGrpc.getCreateCustomerMethod) == null) {
      synchronized (CustomerServiceGrpc.class) {
        if ((getCreateCustomerMethod = CustomerServiceGrpc.getCreateCustomerMethod) == null) {
          CustomerServiceGrpc.getCreateCustomerMethod = getCreateCustomerMethod =
              io.grpc.MethodDescriptor.<via.sep3.persistencetier.protobuf.CreateCustomerRequest, via.sep3.persistencetier.protobuf.CustomerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createCustomer"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.CreateCustomerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.CustomerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CustomerServiceMethodDescriptorSupplier("createCustomer"))
              .build();
        }
      }
    }
    return getCreateCustomerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.CustomerRequest,
      via.sep3.persistencetier.protobuf.CustomerResponse> getGetCustomerByEmailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getCustomerByEmail",
      requestType = via.sep3.persistencetier.protobuf.CustomerRequest.class,
      responseType = via.sep3.persistencetier.protobuf.CustomerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.CustomerRequest,
      via.sep3.persistencetier.protobuf.CustomerResponse> getGetCustomerByEmailMethod() {
    io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.CustomerRequest, via.sep3.persistencetier.protobuf.CustomerResponse> getGetCustomerByEmailMethod;
    if ((getGetCustomerByEmailMethod = CustomerServiceGrpc.getGetCustomerByEmailMethod) == null) {
      synchronized (CustomerServiceGrpc.class) {
        if ((getGetCustomerByEmailMethod = CustomerServiceGrpc.getGetCustomerByEmailMethod) == null) {
          CustomerServiceGrpc.getGetCustomerByEmailMethod = getGetCustomerByEmailMethod =
              io.grpc.MethodDescriptor.<via.sep3.persistencetier.protobuf.CustomerRequest, via.sep3.persistencetier.protobuf.CustomerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getCustomerByEmail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.CustomerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.CustomerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CustomerServiceMethodDescriptorSupplier("getCustomerByEmail"))
              .build();
        }
      }
    }
    return getGetCustomerByEmailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.CustomerRequest,
      via.sep3.persistencetier.protobuf.CustomerResponse> getDeleteCustomerByEmailMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteCustomerByEmail",
      requestType = via.sep3.persistencetier.protobuf.CustomerRequest.class,
      responseType = via.sep3.persistencetier.protobuf.CustomerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.CustomerRequest,
      via.sep3.persistencetier.protobuf.CustomerResponse> getDeleteCustomerByEmailMethod() {
    io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.CustomerRequest, via.sep3.persistencetier.protobuf.CustomerResponse> getDeleteCustomerByEmailMethod;
    if ((getDeleteCustomerByEmailMethod = CustomerServiceGrpc.getDeleteCustomerByEmailMethod) == null) {
      synchronized (CustomerServiceGrpc.class) {
        if ((getDeleteCustomerByEmailMethod = CustomerServiceGrpc.getDeleteCustomerByEmailMethod) == null) {
          CustomerServiceGrpc.getDeleteCustomerByEmailMethod = getDeleteCustomerByEmailMethod =
              io.grpc.MethodDescriptor.<via.sep3.persistencetier.protobuf.CustomerRequest, via.sep3.persistencetier.protobuf.CustomerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteCustomerByEmail"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.CustomerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.CustomerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CustomerServiceMethodDescriptorSupplier("deleteCustomerByEmail"))
              .build();
        }
      }
    }
    return getDeleteCustomerByEmailMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.EmptyCustomer,
      via.sep3.persistencetier.protobuf.CustomerResponse> getGetAllCustomersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllCustomers",
      requestType = via.sep3.persistencetier.protobuf.EmptyCustomer.class,
      responseType = via.sep3.persistencetier.protobuf.CustomerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.EmptyCustomer,
      via.sep3.persistencetier.protobuf.CustomerResponse> getGetAllCustomersMethod() {
    io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.EmptyCustomer, via.sep3.persistencetier.protobuf.CustomerResponse> getGetAllCustomersMethod;
    if ((getGetAllCustomersMethod = CustomerServiceGrpc.getGetAllCustomersMethod) == null) {
      synchronized (CustomerServiceGrpc.class) {
        if ((getGetAllCustomersMethod = CustomerServiceGrpc.getGetAllCustomersMethod) == null) {
          CustomerServiceGrpc.getGetAllCustomersMethod = getGetAllCustomersMethod =
              io.grpc.MethodDescriptor.<via.sep3.persistencetier.protobuf.EmptyCustomer, via.sep3.persistencetier.protobuf.CustomerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllCustomers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.EmptyCustomer.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.CustomerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new CustomerServiceMethodDescriptorSupplier("getAllCustomers"))
              .build();
        }
      }
    }
    return getGetAllCustomersMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static CustomerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CustomerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CustomerServiceStub>() {
        @java.lang.Override
        public CustomerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CustomerServiceStub(channel, callOptions);
        }
      };
    return CustomerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CustomerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CustomerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CustomerServiceBlockingStub>() {
        @java.lang.Override
        public CustomerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CustomerServiceBlockingStub(channel, callOptions);
        }
      };
    return CustomerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static CustomerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CustomerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<CustomerServiceFutureStub>() {
        @java.lang.Override
        public CustomerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new CustomerServiceFutureStub(channel, callOptions);
        }
      };
    return CustomerServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class CustomerServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createCustomer(via.sep3.persistencetier.protobuf.CreateCustomerRequest request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.CustomerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateCustomerMethod(), responseObserver);
    }

    /**
     */
    public void getCustomerByEmail(via.sep3.persistencetier.protobuf.CustomerRequest request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.CustomerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetCustomerByEmailMethod(), responseObserver);
    }

    /**
     */
    public void deleteCustomerByEmail(via.sep3.persistencetier.protobuf.CustomerRequest request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.CustomerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteCustomerByEmailMethod(), responseObserver);
    }

    /**
     */
    public void getAllCustomers(via.sep3.persistencetier.protobuf.EmptyCustomer request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.CustomerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllCustomersMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateCustomerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.persistencetier.protobuf.CreateCustomerRequest,
                via.sep3.persistencetier.protobuf.CustomerResponse>(
                  this, METHODID_CREATE_CUSTOMER)))
          .addMethod(
            getGetCustomerByEmailMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.persistencetier.protobuf.CustomerRequest,
                via.sep3.persistencetier.protobuf.CustomerResponse>(
                  this, METHODID_GET_CUSTOMER_BY_EMAIL)))
          .addMethod(
            getDeleteCustomerByEmailMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.persistencetier.protobuf.CustomerRequest,
                via.sep3.persistencetier.protobuf.CustomerResponse>(
                  this, METHODID_DELETE_CUSTOMER_BY_EMAIL)))
          .addMethod(
            getGetAllCustomersMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                via.sep3.persistencetier.protobuf.EmptyCustomer,
                via.sep3.persistencetier.protobuf.CustomerResponse>(
                  this, METHODID_GET_ALL_CUSTOMERS)))
          .build();
    }
  }

  /**
   */
  public static final class CustomerServiceStub extends io.grpc.stub.AbstractAsyncStub<CustomerServiceStub> {
    private CustomerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CustomerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CustomerServiceStub(channel, callOptions);
    }

    /**
     */
    public void createCustomer(via.sep3.persistencetier.protobuf.CreateCustomerRequest request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.CustomerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateCustomerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getCustomerByEmail(via.sep3.persistencetier.protobuf.CustomerRequest request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.CustomerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCustomerByEmailMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteCustomerByEmail(via.sep3.persistencetier.protobuf.CustomerRequest request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.CustomerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCustomerByEmailMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllCustomers(via.sep3.persistencetier.protobuf.EmptyCustomer request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.CustomerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetAllCustomersMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class CustomerServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<CustomerServiceBlockingStub> {
    private CustomerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CustomerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CustomerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public via.sep3.persistencetier.protobuf.CustomerResponse createCustomer(via.sep3.persistencetier.protobuf.CreateCustomerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateCustomerMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.persistencetier.protobuf.CustomerResponse getCustomerByEmail(via.sep3.persistencetier.protobuf.CustomerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCustomerByEmailMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.persistencetier.protobuf.CustomerResponse deleteCustomerByEmail(via.sep3.persistencetier.protobuf.CustomerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCustomerByEmailMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<via.sep3.persistencetier.protobuf.CustomerResponse> getAllCustomers(
        via.sep3.persistencetier.protobuf.EmptyCustomer request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetAllCustomersMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class CustomerServiceFutureStub extends io.grpc.stub.AbstractFutureStub<CustomerServiceFutureStub> {
    private CustomerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CustomerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CustomerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.persistencetier.protobuf.CustomerResponse> createCustomer(
        via.sep3.persistencetier.protobuf.CreateCustomerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateCustomerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.persistencetier.protobuf.CustomerResponse> getCustomerByEmail(
        via.sep3.persistencetier.protobuf.CustomerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCustomerByEmailMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.persistencetier.protobuf.CustomerResponse> deleteCustomerByEmail(
        via.sep3.persistencetier.protobuf.CustomerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCustomerByEmailMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_CUSTOMER = 0;
  private static final int METHODID_GET_CUSTOMER_BY_EMAIL = 1;
  private static final int METHODID_DELETE_CUSTOMER_BY_EMAIL = 2;
  private static final int METHODID_GET_ALL_CUSTOMERS = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final CustomerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(CustomerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_CUSTOMER:
          serviceImpl.createCustomer((via.sep3.persistencetier.protobuf.CreateCustomerRequest) request,
              (io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.CustomerResponse>) responseObserver);
          break;
        case METHODID_GET_CUSTOMER_BY_EMAIL:
          serviceImpl.getCustomerByEmail((via.sep3.persistencetier.protobuf.CustomerRequest) request,
              (io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.CustomerResponse>) responseObserver);
          break;
        case METHODID_DELETE_CUSTOMER_BY_EMAIL:
          serviceImpl.deleteCustomerByEmail((via.sep3.persistencetier.protobuf.CustomerRequest) request,
              (io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.CustomerResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_CUSTOMERS:
          serviceImpl.getAllCustomers((via.sep3.persistencetier.protobuf.EmptyCustomer) request,
              (io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.CustomerResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class CustomerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CustomerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return via.sep3.persistencetier.protobuf.CustomerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CustomerService");
    }
  }

  private static final class CustomerServiceFileDescriptorSupplier
      extends CustomerServiceBaseDescriptorSupplier {
    CustomerServiceFileDescriptorSupplier() {}
  }

  private static final class CustomerServiceMethodDescriptorSupplier
      extends CustomerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    CustomerServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (CustomerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new CustomerServiceFileDescriptorSupplier())
              .addMethod(getCreateCustomerMethod())
              .addMethod(getGetCustomerByEmailMethod())
              .addMethod(getDeleteCustomerByEmailMethod())
              .addMethod(getGetAllCustomersMethod())
              .build();
        }
      }
    }
    return result;
  }
}
