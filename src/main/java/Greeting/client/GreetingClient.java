package Greeting.client;

import com.proto.greeting.GreetingRequest;
import com.proto.greeting.GreetingResponse;
import com.proto.greeting.GreetingServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class GreetingClient {

    private static void doGreet(ManagedChannel channel){
        System.out.println("Entered doGreet function");
        //stubs helps call function directly on server
        GreetingServiceGrpc.GreetingServiceBlockingStub stub=GreetingServiceGrpc.newBlockingStub(channel);
        GreetingResponse response=stub.greet(GreetingRequest.newBuilder().setFirstName("Ashmeet").build());

        System.out.println("Greeting: "+ response.getResult());
    }

    private static void doGreetManyTimes(ManagedChannel channel){
        System.out.println("Entered doGreetManyTimes function");
        GreetingServiceGrpc.GreetingServiceBlockingStub stub=GreetingServiceGrpc.newBlockingStub(channel);

        stub.greetManyTimes(GreetingRequest.newBuilder().setFirstName("Ashmeet").build())
                .forEachRemaining(response -> {
                    System.out.println(response.getResult());
                });
    }

    private static void doLongGreet(ManagedChannel channel) throws InterruptedException {
        System.out.println("Entered doLongGreet function");
        GreetingServiceGrpc.GreetingServiceStub stub=GreetingServiceGrpc.newStub(channel);
        List<String> names=new ArrayList<>();
        CountDownLatch latch=new CountDownLatch(1);
        /* As we are in an async stub, we might receive response at any time.
        * So we will wait for one response, then after that, latch becomes 0
        * */

        Collections.addAll(names,"Ashmeet","Sameer","Sanchit");

        StreamObserver<GreetingRequest> stream=stub.longGreet(new StreamObserver<GreetingResponse>() {
            @Override
            public void onNext(GreetingResponse greetingResponse) {
                System.out.println(greetingResponse.getResult());
            }

            @Override
            public void onError(Throwable throwable) {
            }

            @Override
            public void onCompleted() {
                latch.countDown();
            }
        });

        for(String name:names){
            stream.onNext(GreetingRequest.newBuilder().setFirstName(name).build());
        }

        stream.onCompleted();
        latch.await(1, TimeUnit.MINUTES);
    }

    private static void doGreetEveryone(ManagedChannel channel) throws InterruptedException {
        System.out.println("Entered doGreetEveryone Function");
        GreetingServiceGrpc.GreetingServiceStub stub=GreetingServiceGrpc.newStub(channel);
        CountDownLatch latch=new CountDownLatch(1);
        StreamObserver<GreetingRequest> stream=stub.greetEveryone(new StreamObserver<GreetingResponse>() {
            @Override
            public void onNext(GreetingResponse response) {
                System.out.println(response.getResult());
            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onCompleted() {
                latch.countDown();
            }
        });

        Arrays.asList("Ashmeet","Sameer","Sanchit")
                .forEach(s->stream.onNext(GreetingRequest.newBuilder().setFirstName(s).build()));

        stream.onCompleted();
        latch.await();
    }

    public static void main(String[] args) throws InterruptedException {
        if(args.length == 0){
            System.out.println("Need one argument to work");
            return;
        }
        //channels are object which will create TCP connection between client and server
        ManagedChannel channel= ManagedChannelBuilder.
                forAddress("localhost",50051)
                .usePlaintext()//because we are not dealing with SSL certificates as of now, so using usePlainText()
                .build();

        //do something
        switch(args[0]){
            case "greet": doGreet(channel); break;
            case "greet_many_times": doGreetManyTimes(channel); break;
            case "long_greet": doLongGreet(channel); break;
            case "greet_everyone": doGreetEveryone(channel); break;
            default:
                System.out.println("Keyword invalid: "+args[0]);
        }
        System.out.println("Shutting down");
        channel.shutdown();
    }
}
