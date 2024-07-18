package Sum.client;

import com.proto.sum.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class SumClient {

    private static void doSum(ManagedChannel channel){
        SumServiceGrpc.SumServiceBlockingStub stub=SumServiceGrpc.newBlockingStub(channel);
        SumRequest message=SumRequest.newBuilder().setNum1(21).setNum2(31).build();
        SumResponse response=stub.sum(message);
        System.out.println("Sum of "+message.getNum1()+" & "+message.getNum2()+": "+response.getResult());
    }

    private static void doSqrt(ManagedChannel channel){
        System.out.println("Entered doSqrt");
        SqrtServiceGrpc.SqrtServiceBlockingStub stub=SqrtServiceGrpc.newBlockingStub(channel);
        SqrtResponse response=stub.sqrt(SqrtRequest.newBuilder().setNumber(25).build());
        System.out.println(response.getResult());

        try{
            response=stub.sqrt(SqrtRequest.newBuilder().setNumber(-1).build());
            System.out.println(response.getResult());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ManagedChannel channel= ManagedChannelBuilder
                .forAddress("localhost",50051)
                .usePlaintext()
                .build();

        doSqrt(channel);
        channel.shutdown();
    }
}
