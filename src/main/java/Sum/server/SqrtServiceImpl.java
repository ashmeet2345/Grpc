package Sum.server;

import com.proto.sum.SqrtRequest;
import com.proto.sum.SqrtResponse;
import com.proto.sum.SqrtServiceGrpc;
import io.grpc.Status;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;

public class SqrtServiceImpl extends SqrtServiceGrpc.SqrtServiceImplBase {
    @Override
    public void sqrt(SqrtRequest request, StreamObserver<SqrtResponse> response){
        int number=request.getNumber();
        if( number < 0){
            response.onError(Status.INVALID_ARGUMENT
                            .withDescription("Number entered is invalid")
                            .augmentDescription("Number: "+number)
                            .asException());
            return;
        }

        response.onNext(SqrtResponse.newBuilder().setResult(Math.sqrt(number)).build());
        response.onCompleted();
    }
}
