package com.vitor.cordeiro.grpcStudies.greeting.client;

import com.proto.greet.*;
import com.proto.sum.Sum;
import com.proto.sum.SumRequest;
import com.proto.sum.SumResponse;
import com.proto.sum.SumServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    public static void main(String[] args) {
        System.out.println("gRPC Greetings started Client");

        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext() //Force SSL to be ignore! User only in development
                .build();

        // create a greet service client (blocking - synchronous)
        GreetServiceGrpc.GreetServiceBlockingStub greetClient = GreetServiceGrpc.newBlockingStub(channel);
        SumServiceGrpc.SumServiceBlockingStub sumClient = SumServiceGrpc.newBlockingStub(channel);

        callGreet(greetClient);
        callSum(sumClient);
        callGreetManyTimes(greetClient);

        System.out.println("Shutting down channel");
        channel.shutdown();
    }

    public static void callGreetManyTimes(GreetServiceGrpc.GreetServiceBlockingStub greetClient){
        GreetManyTimesRequest request = GreetManyTimesRequest.newBuilder()
                .setGreeting(Greeting.newBuilder().setFirstName("Fulano"))
                .build();
        greetClient.greetManyTimes(request).forEachRemaining(resp ->{
            System.out.println("Response GREET MANY TIMES: " + resp.getResult());
        });
    }

    public static void callGreet(GreetServiceGrpc.GreetServiceBlockingStub greetClient){
        // create a protocol buffer greeting message
        Greeting greeting = Greeting.newBuilder()
                .setFirstName("Fulano")
                .setLastName("De Tal")
                .build();

        // do the call
        GreetRequest request = GreetRequest.newBuilder()
                .setGreeting(greeting)
                .build();
        GreetResponse response = greetClient.greet(request);

        System.out.println("Response GREET: " + response.getResult());
    }

    public static void callSum(SumServiceGrpc.SumServiceBlockingStub sumClient){
        // create a protocol buffer greeting message
        Sum sum = Sum.newBuilder()
                .setVal1(10)
                .setVal2(3)
                .build();

        // do the call
        SumRequest request = SumRequest.newBuilder()
                .setSum(sum)
                .build();

        SumResponse response = sumClient.sum(request);

        System.out.println("Response SUM: " + response.getResult());
    }

}
