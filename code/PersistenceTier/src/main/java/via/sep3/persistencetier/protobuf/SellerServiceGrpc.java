package via.sep3.persistencetier.protobuf;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: SellerProto.proto")
public final class SellerServiceGrpc {

  private SellerServiceGrpc() {}

  public static final String SERVICE_NAME = "SellerService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.CreateSellerResponse,
      via.sep3.persistencetier.protobuf.SellerResponse> getCreateSellerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "createSeller",
      requestType = via.sep3.persistencetier.protobuf.CreateSellerResponse.class,
      responseType = via.sep3.persistencetier.protobuf.SellerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.CreateSellerResponse,
      via.sep3.persistencetier.protobuf.SellerResponse> getCreateSellerMethod() {
    io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.CreateSellerResponse, via.sep3.persistencetier.protobuf.SellerResponse> getCreateSellerMethod;
    if ((getCreateSellerMethod = SellerServiceGrpc.getCreateSellerMethod) == null) {
      synchronized (SellerServiceGrpc.class) {
        if ((getCreateSellerMethod = SellerServiceGrpc.getCreateSellerMethod) == null) {
          SellerServiceGrpc.getCreateSellerMethod = getCreateSellerMethod =
              io.grpc.MethodDescriptor.<via.sep3.persistencetier.protobuf.CreateSellerResponse, via.sep3.persistencetier.protobuf.SellerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "createSeller"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.CreateSellerResponse.getDefaultInstance()))
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
      via.sep3.persistencetier.protobuf.SellerResponse> getGetSellerByIdMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "getSellerById",
      requestType = via.sep3.persistencetier.protobuf.SellerRequest.class,
      responseType = via.sep3.persistencetier.protobuf.SellerResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.SellerRequest,
      via.sep3.persistencetier.protobuf.SellerResponse> getGetSellerByIdMethod() {
    io.grpc.MethodDescriptor<via.sep3.persistencetier.protobuf.SellerRequest, via.sep3.persistencetier.protobuf.SellerResponse> getGetSellerByIdMethod;
    if ((getGetSellerByIdMethod = SellerServiceGrpc.getGetSellerByIdMethod) == null) {
      synchronized (SellerServiceGrpc.class) {
        if ((getGetSellerByIdMethod = SellerServiceGrpc.getGetSellerByIdMethod) == null) {
          SellerServiceGrpc.getGetSellerByIdMethod = getGetSellerByIdMethod =
              io.grpc.MethodDescriptor.<via.sep3.persistencetier.protobuf.SellerRequest, via.sep3.persistencetier.protobuf.SellerResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "getSellerById"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.SellerRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  via.sep3.persistencetier.protobuf.SellerResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SellerServiceMethodDescriptorSupplier("getSellerById"))
              .build();
        }
      }
    }
    return getGetSellerByIdMethod;
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
    public void createSeller(via.sep3.persistencetier.protobuf.CreateSellerResponse request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.SellerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateSellerMethod(), responseObserver);
    }

    /**
     */
    public void getSellerById(via.sep3.persistencetier.protobuf.SellerRequest request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.SellerResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetSellerByIdMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCreateSellerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.persistencetier.protobuf.CreateSellerResponse,
                via.sep3.persistencetier.protobuf.SellerResponse>(
                  this, METHODID_CREATE_SELLER)))
          .addMethod(
            getGetSellerByIdMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                via.sep3.persistencetier.protobuf.SellerRequest,
                via.sep3.persistencetier.protobuf.SellerResponse>(
                  this, METHODID_GET_SELLER_BY_ID)))
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
    public void createSeller(via.sep3.persistencetier.protobuf.CreateSellerResponse request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.SellerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateSellerMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getSellerById(via.sep3.persistencetier.protobuf.SellerRequest request,
        io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.SellerResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetSellerByIdMethod(), getCallOptions()), request, responseObserver);
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
    public via.sep3.persistencetier.protobuf.SellerResponse createSeller(via.sep3.persistencetier.protobuf.CreateSellerResponse request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateSellerMethod(), getCallOptions(), request);
    }

    /**
     */
    public via.sep3.persistencetier.protobuf.SellerResponse getSellerById(via.sep3.persistencetier.protobuf.SellerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetSellerByIdMethod(), getCallOptions(), request);
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
        via.sep3.persistencetier.protobuf.CreateSellerResponse request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateSellerMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<via.sep3.persistencetier.protobuf.SellerResponse> getSellerById(
        via.sep3.persistencetier.protobuf.SellerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetSellerByIdMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SELLER = 0;
  private static final int METHODID_GET_SELLER_BY_ID = 1;

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
          serviceImpl.createSeller((via.sep3.persistencetier.protobuf.CreateSellerResponse) request,
              (io.grpc.stub.StreamObserver<via.sep3.persistencetier.protobuf.SellerResponse>) responseObserver);
          break;
        case METHODID_GET_SELLER_BY_ID:
          serviceImpl.getSellerById((via.sep3.persistencetier.protobuf.SellerRequest) request,
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
              .addMethod(getGetSellerByIdMethod())
              .build();
        }
      }
    }
    return result;
  }
}
