package via.sep3.persistencetier.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: SellerProto.proto")
public final class SellerServiceGrpc {

  private SellerServiceGrpc() {}

  public static final String SERVICE_NAME = "seller.SellerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.CreateSellerRequest,
      via.sep3.persistencetier.protobuf.SellerResponse> getCreateSellerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createSeller",
      requestType = via.sep3.persistencetier.protobuf.CreateSellerRequest.class,
      responseType = via.sep3.persistencetier.protobuf.SellerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.CreateSellerRequest,
      via.sep3.persistencetier.protobuf.SellerResponse> getCreateSellerMethod() {
    io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.CreateSellerRequest, via.sep3.persistencetier.protobuf.SellerResponse> getCreateSellerMethod;
    if ((getCreateSellerMethod = SellerServiceGrpc.getCreateSellerMethod) == null) {
      synchronized (SellerServiceGrpc.class) {
        if ((getCreateSellerMethod = SellerServiceGrpc.getCreateSellerMethod) == null) {
          SellerServiceGrpc.getCreateSellerMethod = getCreateSellerMethod =
              io.grpc.MethodDescriptor.<via.sep3.persistencetier.protobuf.CreateSellerRequest, via.sep3.persistencetier.protobuf.SellerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createSeller"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.CreateSellerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.SellerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SellerServiceMethodDescriptorSupplier("createSeller"))
              .build();
        }
      }
    }
    return getCreateSellerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.SellerRequest,
      via.sep3.persistencetier.protobuf.SellerResponse> getGetSellerByCvrMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getSellerByCvr",
      requestType = via.sep3.persistencetier.protobuf.SellerRequest.class,
      responseType = via.sep3.persistencetier.protobuf.SellerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.SellerRequest,
      via.sep3.persistencetier.protobuf.SellerResponse> getGetSellerByCvrMethod() {
    io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.SellerRequest, via.sep3.persistencetier.protobuf.SellerResponse> getGetSellerByCvrMethod;
    if ((getGetSellerByCvrMethod = SellerServiceGrpc.getGetSellerByCvrMethod) == null) {
      synchronized (SellerServiceGrpc.class) {
        if ((getGetSellerByCvrMethod = SellerServiceGrpc.getGetSellerByCvrMethod) == null) {
          SellerServiceGrpc.getGetSellerByCvrMethod = getGetSellerByCvrMethod =
              io.grpc.MethodDescriptor.<via.sep3.persistencetier.protobuf.SellerRequest, via.sep3.persistencetier.protobuf.SellerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getSellerByCvr"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.SellerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.SellerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SellerServiceMethodDescriptorSupplier("getSellerByCvr"))
              .build();
        }
      }
    }
    return getGetSellerByCvrMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.Empty,
      via.sep3.persistencetier.protobuf.SellerResponse> getGetAllSellersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getAllSellers",
      requestType = via.sep3.persistencetier.protobuf.Empty.class,
      responseType = via.sep3.persistencetier.protobuf.SellerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.Empty,
      via.sep3.persistencetier.protobuf.SellerResponse> getGetAllSellersMethod() {
    io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.Empty, via.sep3.persistencetier.protobuf.SellerResponse> getGetAllSellersMethod;
    if ((getGetAllSellersMethod = SellerServiceGrpc.getGetAllSellersMethod) == null) {
      synchronized (SellerServiceGrpc.class) {
        if ((getGetAllSellersMethod = SellerServiceGrpc.getGetAllSellersMethod) == null) {
          SellerServiceGrpc.getGetAllSellersMethod = getGetAllSellersMethod =
              io.grpc.MethodDescriptor.<via.sep3.persistencetier.protobuf.Empty, via.sep3.persistencetier.protobuf.SellerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getAllSellers"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.SellerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SellerServiceMethodDescriptorSupplier("getAllSellers"))
              .build();
        }
      }
    }
    return getGetAllSellersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.SellerRequest,
      via.sep3.persistencetier.protobuf.SellerResponse> getDeleteSellerByCvrMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteSellerByCvr",
      requestType = via.sep3.persistencetier.protobuf.SellerRequest.class,
      responseType = via.sep3.persistencetier.protobuf.SellerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.SellerRequest,
      via.sep3.persistencetier.protobuf.SellerResponse> getDeleteSellerByCvrMethod() {
    io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.SellerRequest, via.sep3.persistencetier.protobuf.SellerResponse> getDeleteSellerByCvrMethod;
    if ((getDeleteSellerByCvrMethod = SellerServiceGrpc.getDeleteSellerByCvrMethod) == null) {
      synchronized (SellerServiceGrpc.class) {
        if ((getDeleteSellerByCvrMethod = SellerServiceGrpc.getDeleteSellerByCvrMethod) == null) {
          SellerServiceGrpc.getDeleteSellerByCvrMethod = getDeleteSellerByCvrMethod =
              io.grpc.MethodDescriptor.<via.sep3.persistencetier.protobuf.SellerRequest, via.sep3.persistencetier.protobuf.SellerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteSellerByCvr"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.SellerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.SellerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SellerServiceMethodDescriptorSupplier("deleteSellerByCvr"))
              .build();
        }
      }
    }
    return getDeleteSellerByCvrMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SellerServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SellerServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SellerServiceStub>() {
        @java.lang.Override
        public SellerServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SellerServiceStub(channel, callOptions);
        }
      };
    return SellerServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SellerServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SellerServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SellerServiceBlockingStub>() {
        @java.lang.Override
        public SellerServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SellerServiceBlockingStub(channel, callOptions);
        }
      };
    return SellerServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SellerServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SellerServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SellerServiceFutureStub>() {
        @java.lang.Override
        public SellerServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SellerServiceFutureStub(channel, callOptions);
        }
      };
    return SellerServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SellerServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createSeller(via.sep3.persistencetier.protobuf.CreateSellerRequest request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.SellerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateSellerMethod(), responseObserver);
    }

    /**
     */
    public void getSellerByCvr(via.sep3.persistencetier.protobuf.SellerRequest request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.SellerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSellerByCvrMethod(), responseObserver);
    }

    /**
     */
    public void getAllSellers(via.sep3.persistencetier.protobuf.Empty request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.SellerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllSellersMethod(), responseObserver);
    }

    /**
     */
    public void deleteSellerByCvr(via.sep3.persistencetier.protobuf.SellerRequest request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.SellerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteSellerByCvrMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateSellerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.persistencetier.protobuf.CreateSellerRequest,
                via.sep3.persistencetier.protobuf.SellerResponse>(
                  this, METHODID_CREATE_SELLER)))
          .addMethod(
            getGetSellerByCvrMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.persistencetier.protobuf.SellerRequest,
                via.sep3.persistencetier.protobuf.SellerResponse>(
                  this, METHODID_GET_SELLER_BY_CVR)))
          .addMethod(
            getGetAllSellersMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                via.sep3.persistencetier.protobuf.Empty,
                via.sep3.persistencetier.protobuf.SellerResponse>(
                  this, METHODID_GET_ALL_SELLERS)))
          .addMethod(
            getDeleteSellerByCvrMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.persistencetier.protobuf.SellerRequest,
                via.sep3.persistencetier.protobuf.SellerResponse>(
                  this, METHODID_DELETE_SELLER_BY_CVR)))
          .build();
    }
  }

  /**
   */
  public static final class SellerServiceStub extends io.grpc.stub.AbstractAsyncStub<SellerServiceStub> {
    private SellerServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SellerServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SellerServiceStub(channel, callOptions);
    }

    /**
     */
    public void createSeller(via.sep3.persistencetier.protobuf.CreateSellerRequest request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.SellerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSellerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getSellerByCvr(via.sep3.persistencetier.protobuf.SellerRequest request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.SellerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSellerByCvrMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getAllSellers(via.sep3.persistencetier.protobuf.Empty request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.SellerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetAllSellersMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteSellerByCvr(via.sep3.persistencetier.protobuf.SellerRequest request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.SellerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteSellerByCvrMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SellerServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SellerServiceBlockingStub> {
    private SellerServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SellerServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SellerServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public via.sep3.persistencetier.protobuf.SellerResponse createSeller(via.sep3.persistencetier.protobuf.CreateSellerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSellerMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.persistencetier.protobuf.SellerResponse getSellerByCvr(via.sep3.persistencetier.protobuf.SellerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSellerByCvrMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<via.sep3.persistencetier.protobuf.SellerResponse> getAllSellers(
        via.sep3.persistencetier.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetAllSellersMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.persistencetier.protobuf.SellerResponse deleteSellerByCvr(via.sep3.persistencetier.protobuf.SellerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteSellerByCvrMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SellerServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SellerServiceFutureStub> {
    private SellerServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SellerServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SellerServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.persistencetier.protobuf.SellerResponse> createSeller(
        via.sep3.persistencetier.protobuf.CreateSellerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSellerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.persistencetier.protobuf.SellerResponse> getSellerByCvr(
        via.sep3.persistencetier.protobuf.SellerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSellerByCvrMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.persistencetier.protobuf.SellerResponse> deleteSellerByCvr(
        via.sep3.persistencetier.protobuf.SellerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteSellerByCvrMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SELLER = 0;
  private static final int METHODID_GET_SELLER_BY_CVR = 1;
  private static final int METHODID_GET_ALL_SELLERS = 2;
  private static final int METHODID_DELETE_SELLER_BY_CVR = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SellerServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SellerServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_SELLER:
          serviceImpl.createSeller((via.sep3.persistencetier.protobuf.CreateSellerRequest) request,
              (io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.SellerResponse>) responseObserver);
          break;
        case METHODID_GET_SELLER_BY_CVR:
          serviceImpl.getSellerByCvr((via.sep3.persistencetier.protobuf.SellerRequest) request,
              (io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.SellerResponse>) responseObserver);
          break;
        case METHODID_GET_ALL_SELLERS:
          serviceImpl.getAllSellers((via.sep3.persistencetier.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.SellerResponse>) responseObserver);
          break;
        case METHODID_DELETE_SELLER_BY_CVR:
          serviceImpl.deleteSellerByCvr((via.sep3.persistencetier.protobuf.SellerRequest) request,
              (io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.SellerResponse>) responseObserver);
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

  private static abstract class SellerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SellerServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return via.sep3.persistencetier.protobuf.SellerProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SellerService");
    }
  }

  private static final class SellerServiceFileDescriptorSupplier
      extends SellerServiceBaseDescriptorSupplier {
    SellerServiceFileDescriptorSupplier() {}
  }

  private static final class SellerServiceMethodDescriptorSupplier
      extends SellerServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SellerServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (SellerServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SellerServiceFileDescriptorSupplier())
              .addMethod(getCreateSellerMethod())
              .addMethod(getGetSellerByCvrMethod())
              .addMethod(getGetAllSellersMethod())
              .addMethod(getDeleteSellerByCvrMethod())
              .build();
        }
      }
    }
    return result;
  }
}
