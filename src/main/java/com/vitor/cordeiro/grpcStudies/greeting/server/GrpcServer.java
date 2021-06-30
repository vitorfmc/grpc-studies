package com.vitor.cordeiro.grpcStudies.greeting.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("gRPC Greetings started Server");

        io.grpc.Server server = ServerBuilder.forPort(50051)
                .addService(new GreetServiceImpl())
                .addService(new SumServiceImpl())
                .build();
        server.start();

        //Everytime Java Runtime shutdown, shutdown our service as well
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received Shutdown Request");
            server.shutdown();
            System.out.println("Successfully stopped the server");
        }));

        server.awaitTermination();
    }

}
