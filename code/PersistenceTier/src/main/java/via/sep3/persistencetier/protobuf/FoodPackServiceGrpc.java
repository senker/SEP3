package via.sep3.persistencetier.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: FoodPack.proto")
public final class FoodPackServiceGrpc {

  private FoodPackServiceGrpc() {}

  public static final String SERVICE_NAME = "packPackage.FoodPackService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.createFoodPackRequest,
      via.sep3.persistencetier.protobuf.foodPackRespons> getCreateFoodPackMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createFoodPack",
      requestType = via.sep3.persistencetier.protobuf.createFoodPackRequest.class,
      responseType = via.sep3.persistencetier.protobuf.foodPackRespons.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.createFoodPackRequest,
      via.sep3.persistencetier.protobuf.foodPackRespons> getCreateFoodPackMethod() {
    io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.createFoodPackRequest, via.sep3.persistencetier.protobuf.foodPackRespons> getCreateFoodPackMethod;
    if ((getCreateFoodPackMethod = FoodPackServiceGrpc.getCreateFoodPackMethod) == null) {
      synchronized (FoodPackServiceGrpc.class) {
        if ((getCreateFoodPackMethod = FoodPackServiceGrpc.getCreateFoodPackMethod) == null) {
          FoodPackServiceGrpc.getCreateFoodPackMethod = getCreateFoodPackMethod =
              io.grpc.MethodDescriptor.<via.sep3.persistencetier.protobuf.createFoodPackRequest, via.sep3.persistencetier.protobuf.foodPackRespons>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createFoodPack"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.createFoodPackRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.foodPackRespons.getDefaultInstance()))
              .setSchemaDescriptor(new FoodPackServiceMethodDescriptorSupplier("createFoodPack"))
              .build();
        }
      }
    }
    return getCreateFoodPackMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.foodPackRequest,
      via.sep3.persistencetier.protobuf.foodPackRespons> getGetFoodPackByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getFoodPackById",
      requestType = via.sep3.persistencetier.protobuf.foodPackRequest.class,
      responseType = via.sep3.persistencetier.protobuf.foodPackRespons.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.foodPackRequest,
      via.sep3.persistencetier.protobuf.foodPackRespons> getGetFoodPackByIdMethod() {
    io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.foodPackRequest, via.sep3.persistencetier.protobuf.foodPackRespons> getGetFoodPackByIdMethod;
    if ((getGetFoodPackByIdMethod = FoodPackServiceGrpc.getGetFoodPackByIdMethod) == null) {
      synchronized (FoodPackServiceGrpc.class) {
        if ((getGetFoodPackByIdMethod = FoodPackServiceGrpc.getGetFoodPackByIdMethod) == null) {
          FoodPackServiceGrpc.getGetFoodPackByIdMethod = getGetFoodPackByIdMethod =
              io.grpc.MethodDescriptor.<via.sep3.persistencetier.protobuf.foodPackRequest, via.sep3.persistencetier.protobuf.foodPackRespons>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getFoodPackById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.foodPackRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.foodPackRespons.getDefaultInstance()))
              .setSchemaDescriptor(new FoodPackServiceMethodDescriptorSupplier("getFoodPackById"))
              .build();
        }
      }
    }
    return getGetFoodPackByIdMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.EmptyPack,
      via.sep3.persistencetier.protobuf.foodPackRespons> getSearchFoodPacksMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "searchFoodPacks",
      requestType = via.sep3.persistencetier.protobuf.EmptyPack.class,
      responseType = via.sep3.persistencetier.protobuf.foodPackRespons.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.EmptyPack,
      via.sep3.persistencetier.protobuf.foodPackRespons> getSearchFoodPacksMethod() {
    io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.EmptyPack, via.sep3.persistencetier.protobuf.foodPackRespons> getSearchFoodPacksMethod;
    if ((getSearchFoodPacksMethod = FoodPackServiceGrpc.getSearchFoodPacksMethod) == null) {
      synchronized (FoodPackServiceGrpc.class) {
        if ((getSearchFoodPacksMethod = FoodPackServiceGrpc.getSearchFoodPacksMethod) == null) {
          FoodPackServiceGrpc.getSearchFoodPacksMethod = getSearchFoodPacksMethod =
              io.grpc.MethodDescriptor.<via.sep3.persistencetier.protobuf.EmptyPack, via.sep3.persistencetier.protobuf.foodPackRespons>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "searchFoodPacks"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.EmptyPack.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.foodPackRespons.getDefaultInstance()))
              .setSchemaDescriptor(new FoodPackServiceMethodDescriptorSupplier("searchFoodPacks"))
              .build();
        }
      }
    }
    return getSearchFoodPacksMethod;
  }

  private static volatile io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.foodPackRequest,
      via.sep3.persistencetier.protobuf.foodPackRespons> getDeleteFoodPackMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "deleteFoodPack",
      requestType = via.sep3.persistencetier.protobuf.foodPackRequest.class,
      responseType = via.sep3.persistencetier.protobuf.foodPackRespons.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.foodPackRequest,
      via.sep3.persistencetier.protobuf.foodPackRespons> getDeleteFoodPackMethod() {
    io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.foodPackRequest, via.sep3.persistencetier.protobuf.foodPackRespons> getDeleteFoodPackMethod;
    if ((getDeleteFoodPackMethod = FoodPackServiceGrpc.getDeleteFoodPackMethod) == null) {
      synchronized (FoodPackServiceGrpc.class) {
        if ((getDeleteFoodPackMethod = FoodPackServiceGrpc.getDeleteFoodPackMethod) == null) {
          FoodPackServiceGrpc.getDeleteFoodPackMethod = getDeleteFoodPackMethod =
              io.grpc.MethodDescriptor.<via.sep3.persistencetier.protobuf.foodPackRequest, via.sep3.persistencetier.protobuf.foodPackRespons>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "deleteFoodPack"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.foodPackRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.foodPackRespons.getDefaultInstance()))
              .setSchemaDescriptor(new FoodPackServiceMethodDescriptorSupplier("deleteFoodPack"))
              .build();
        }
      }
    }
    return getDeleteFoodPackMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static FoodPackServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FoodPackServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FoodPackServiceStub>() {
        @java.lang.Override
        public FoodPackServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FoodPackServiceStub(channel, callOptions);
        }
      };
    return FoodPackServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FoodPackServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FoodPackServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FoodPackServiceBlockingStub>() {
        @java.lang.Override
        public FoodPackServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FoodPackServiceBlockingStub(channel, callOptions);
        }
      };
    return FoodPackServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static FoodPackServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FoodPackServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<FoodPackServiceFutureStub>() {
        @java.lang.Override
        public FoodPackServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new FoodPackServiceFutureStub(channel, callOptions);
        }
      };
    return FoodPackServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class FoodPackServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void createFoodPack(via.sep3.persistencetier.protobuf.createFoodPackRequest request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.foodPackRespons> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateFoodPackMethod(), responseObserver);
    }

    /**
     */
    public void getFoodPackById(via.sep3.persistencetier.protobuf.foodPackRequest request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.foodPackRespons> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetFoodPackByIdMethod(), responseObserver);
    }

    /**
     */
    public void searchFoodPacks(via.sep3.persistencetier.protobuf.EmptyPack request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.foodPackRespons> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSearchFoodPacksMethod(), responseObserver);
    }

    /**
     */
    public void deleteFoodPack(via.sep3.persistencetier.protobuf.foodPackRequest request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.foodPackRespons> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteFoodPackMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateFoodPackMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.persistencetier.protobuf.createFoodPackRequest,
                via.sep3.persistencetier.protobuf.foodPackRespons>(
                  this, METHODID_CREATE_FOOD_PACK)))
          .addMethod(
            getGetFoodPackByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.persistencetier.protobuf.foodPackRequest,
                via.sep3.persistencetier.protobuf.foodPackRespons>(
                  this, METHODID_GET_FOOD_PACK_BY_ID)))
          .addMethod(
            getSearchFoodPacksMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                via.sep3.persistencetier.protobuf.EmptyPack,
                via.sep3.persistencetier.protobuf.foodPackRespons>(
                  this, METHODID_SEARCH_FOOD_PACKS)))
          .addMethod(
            getDeleteFoodPackMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.persistencetier.protobuf.foodPackRequest,
                via.sep3.persistencetier.protobuf.foodPackRespons>(
                  this, METHODID_DELETE_FOOD_PACK)))
          .build();
    }
  }

  /**
   */
  public static final class FoodPackServiceStub extends io.grpc.stub.AbstractAsyncStub<FoodPackServiceStub> {
    private FoodPackServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FoodPackServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FoodPackServiceStub(channel, callOptions);
    }

    /**
     */
    public void createFoodPack(via.sep3.persistencetier.protobuf.createFoodPackRequest request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.foodPackRespons> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateFoodPackMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getFoodPackById(via.sep3.persistencetier.protobuf.foodPackRequest request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.foodPackRespons> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFoodPackByIdMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void searchFoodPacks(via.sep3.persistencetier.protobuf.EmptyPack request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.foodPackRespons> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSearchFoodPacksMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void deleteFoodPack(via.sep3.persistencetier.protobuf.foodPackRequest request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.foodPackRespons> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteFoodPackMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class FoodPackServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<FoodPackServiceBlockingStub> {
    private FoodPackServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FoodPackServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FoodPackServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public via.sep3.persistencetier.protobuf.foodPackRespons createFoodPack(via.sep3.persistencetier.protobuf.createFoodPackRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateFoodPackMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.persistencetier.protobuf.foodPackRespons getFoodPackById(via.sep3.persistencetier.protobuf.foodPackRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFoodPackByIdMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<via.sep3.persistencetier.protobuf.foodPackRespons> searchFoodPacks(
        via.sep3.persistencetier.protobuf.EmptyPack request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSearchFoodPacksMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.persistencetier.protobuf.foodPackRespons deleteFoodPack(via.sep3.persistencetier.protobuf.foodPackRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteFoodPackMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class FoodPackServiceFutureStub extends io.grpc.stub.AbstractFutureStub<FoodPackServiceFutureStub> {
    private FoodPackServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FoodPackServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FoodPackServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.persistencetier.protobuf.foodPackRespons> createFoodPack(
        via.sep3.persistencetier.protobuf.createFoodPackRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateFoodPackMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.persistencetier.protobuf.foodPackRespons> getFoodPackById(
        via.sep3.persistencetier.protobuf.foodPackRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFoodPackByIdMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.persistencetier.protobuf.foodPackRespons> deleteFoodPack(
        via.sep3.persistencetier.protobuf.foodPackRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteFoodPackMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_FOOD_PACK = 0;
  private static final int METHODID_GET_FOOD_PACK_BY_ID = 1;
  private static final int METHODID_SEARCH_FOOD_PACKS = 2;
  private static final int METHODID_DELETE_FOOD_PACK = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final FoodPackServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(FoodPackServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_FOOD_PACK:
          serviceImpl.createFoodPack((via.sep3.persistencetier.protobuf.createFoodPackRequest) request,
              (io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.foodPackRespons>) responseObserver);
          break;
        case METHODID_GET_FOOD_PACK_BY_ID:
          serviceImpl.getFoodPackById((via.sep3.persistencetier.protobuf.foodPackRequest) request,
              (io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.foodPackRespons>) responseObserver);
          break;
        case METHODID_SEARCH_FOOD_PACKS:
          serviceImpl.searchFoodPacks((via.sep3.persistencetier.protobuf.EmptyPack) request,
              (io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.foodPackRespons>) responseObserver);
          break;
        case METHODID_DELETE_FOOD_PACK:
          serviceImpl.deleteFoodPack((via.sep3.persistencetier.protobuf.foodPackRequest) request,
              (io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.foodPackRespons>) responseObserver);
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

  private static abstract class FoodPackServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FoodPackServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return via.sep3.persistencetier.protobuf.FoodPack.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FoodPackService");
    }
  }

  private static final class FoodPackServiceFileDescriptorSupplier
      extends FoodPackServiceBaseDescriptorSupplier {
    FoodPackServiceFileDescriptorSupplier() {}
  }

  private static final class FoodPackServiceMethodDescriptorSupplier
      extends FoodPackServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    FoodPackServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (FoodPackServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new FoodPackServiceFileDescriptorSupplier())
              .addMethod(getCreateFoodPackMethod())
              .addMethod(getGetFoodPackByIdMethod())
              .addMethod(getSearchFoodPacksMethod())
              .addMethod(getDeleteFoodPackMethod())
              .build();
        }
      }
    }
    return result;
  }
}
