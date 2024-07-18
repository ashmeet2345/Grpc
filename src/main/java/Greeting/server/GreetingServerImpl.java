package Greeting.server;

import com.proto.greeting.Greeting;
import com.proto.greeting.GreetingRequest;
import com.proto.greeting.GreetingResponse;
import com.proto.greeting.GreetingServiceGrpc;
import io.grpc.stub.StreamObserver;

import java.util.stream.Stream;

public class GreetingServerImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

    @Override
    public void greet(GreetingRequest request, StreamObserver<GreetingResponse> response){
        response.onNext(GreetingResponse.newBuilder().setResult("Hello "+request.getFirstName()).build());
        response.onCompleted();
    }

    @Override
    public void greetManyTimes(GreetingRequest request,StreamObserver<GreetingResponse> response){
        GreetingResponse res=GreetingResponse.newBuilder().setResult("Hello "+request.getFirstName()).build();
        for(int i=0;i<10;i++){
            response.onNext(res);
        }
        response.onCompleted();
    }

    @Override
    public StreamObserver<GreetingRequest> longGreet(StreamObserver<GreetingResponse> response){
        StringBuilder sb=new StringBuilder();
        return new StreamObserver<GreetingRequest>() {
            @Override
            public void onNext(GreetingRequest request) {
                sb.append("Hello ").append(request.getFirstName()).append("!\n");
            }

            @Override
            public void onError(Throwable throwable) {
                response.onError(throwable);
            }

            @Override
            public void onCompleted() {
                response.onNext(GreetingResponse.newBuilder().setResult(sb.toString()).build());
                response.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<GreetingRequest> greetEveryone(StreamObserver<GreetingResponse> response) {
        return new StreamObserver<GreetingRequest>() {
            @Override
            public void onNext(GreetingRequest request) {
                response.onNext(GreetingResponse.newBuilder().setResult("Hello "+request.getFirstName()).build());
            }

            @Override
            public void onError(Throwable throwable) {
                response.onError(throwable);
            }

            @Override
            public void onCompleted() {
                response.onCompleted();
            }
        };
    }
}
