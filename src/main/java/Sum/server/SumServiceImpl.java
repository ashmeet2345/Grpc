package Sum.server;

import com.proto.sum.SumRequest;
import com.proto.sum.SumResponse;
import com.proto.sum.SumServiceGrpc;
import io.grpc.stub.StreamObserver;

public class SumServiceImpl extends SumServiceGrpc.SumServiceImplBase {
    @Override
    public void sum(SumRequest request, StreamObserver<SumResponse> response){
        int result=request.getNum1()+request.getNum2();
        response.onNext(SumResponse.newBuilder().setResult(result).build());
        response.onCompleted();
    }
}
