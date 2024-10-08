package com.proto.sum;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.65.0)",
    comments = "Source: sum/sum.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class SqrtServiceGrpc {

  private SqrtServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "sum.SqrtService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.proto.sum.SqrtRequest,
      com.proto.sum.SqrtResponse> getSqrtMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "sqrt",
      requestType = com.proto.sum.SqrtRequest.class,
      responseType = com.proto.sum.SqrtResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.proto.sum.SqrtRequest,
      com.proto.sum.SqrtResponse> getSqrtMethod() {
    io.grpc.MethodDescriptor<com.proto.sum.SqrtRequest, com.proto.sum.SqrtResponse> getSqrtMethod;
    if ((getSqrtMethod = SqrtServiceGrpc.getSqrtMethod) == null) {
      synchronized (SqrtServiceGrpc.class) {
        if ((getSqrtMethod = SqrtServiceGrpc.getSqrtMethod) == null) {
          SqrtServiceGrpc.getSqrtMethod = getSqrtMethod =
              io.grpc.MethodDescriptor.<com.proto.sum.SqrtRequest, com.proto.sum.SqrtResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "sqrt"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.sum.SqrtRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.proto.sum.SqrtResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SqrtServiceMethodDescriptorSupplier("sqrt"))
              .build();
        }
      }
    }
    return getSqrtMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SqrtServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqrtServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SqrtServiceStub>() {
        @java.lang.Override
        public SqrtServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SqrtServiceStub(channel, callOptions);
        }
      };
    return SqrtServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SqrtServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqrtServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SqrtServiceBlockingStub>() {
        @java.lang.Override
        public SqrtServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SqrtServiceBlockingStub(channel, callOptions);
        }
      };
    return SqrtServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SqrtServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SqrtServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SqrtServiceFutureStub>() {
        @java.lang.Override
        public SqrtServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SqrtServiceFutureStub(channel, callOptions);
        }
      };
    return SqrtServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void sqrt(com.proto.sum.SqrtRequest request,
        io.grpc.stub.StreamObserver<com.proto.sum.SqrtResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSqrtMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service SqrtService.
   */
  public static abstract class SqrtServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return SqrtServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service SqrtService.
   */
  public static final class SqrtServiceStub
      extends io.grpc.stub.AbstractAsyncStub<SqrtServiceStub> {
    private SqrtServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqrtServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqrtServiceStub(channel, callOptions);
    }

    /**
     */
    public void sqrt(com.proto.sum.SqrtRequest request,
        io.grpc.stub.StreamObserver<com.proto.sum.SqrtResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSqrtMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service SqrtService.
   */
  public static final class SqrtServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<SqrtServiceBlockingStub> {
    private SqrtServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqrtServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqrtServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.proto.sum.SqrtResponse sqrt(com.proto.sum.SqrtRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSqrtMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service SqrtService.
   */
  public static final class SqrtServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<SqrtServiceFutureStub> {
    private SqrtServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SqrtServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SqrtServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.proto.sum.SqrtResponse> sqrt(
        com.proto.sum.SqrtRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSqrtMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SQRT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SQRT:
          serviceImpl.sqrt((com.proto.sum.SqrtRequest) request,
              (io.grpc.stub.StreamObserver<com.proto.sum.SqrtResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getSqrtMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              com.proto.sum.SqrtRequest,
              com.proto.sum.SqrtResponse>(
                service, METHODID_SQRT)))
        .build();
  }

  private static abstract class SqrtServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SqrtServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.proto.sum.Sum.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SqrtService");
    }
  }

  private static final class SqrtServiceFileDescriptorSupplier
      extends SqrtServiceBaseDescriptorSupplier {
    SqrtServiceFileDescriptorSupplier() {}
  }

  private static final class SqrtServiceMethodDescriptorSupplier
      extends SqrtServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    SqrtServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (SqrtServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SqrtServiceFileDescriptorSupplier())
              .addMethod(getSqrtMethod())
              .build();
        }
      }
    }
    return result;
  }
}
