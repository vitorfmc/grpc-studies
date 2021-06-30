package com.vitor.cordeiro.grpcStudies.greeting.server;

import com.proto.sum.Sum;
import com.proto.sum.SumRequest;
import com.proto.sum.SumResponse;
import com.proto.sum.SumServiceGrpc;
import io.grpc.stub.StreamObserver;

public class SumServiceImpl extends SumServiceGrpc.SumServiceImplBase {

    @Override
    public void sum(SumRequest request, StreamObserver<SumResponse> responseObserver) {
        // extract the fields we need
        Sum sum = request.getSum();
        int total = sum.getVal1() + sum.getVal2();

        // create the response
        SumResponse response = SumResponse.newBuilder()
                .setResult(total)
                .build();

        // send the response
        responseObserver.onNext(response);

        //complete the RPC call
        responseObserver.onCompleted();
    }
}
