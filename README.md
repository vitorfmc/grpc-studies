## 1. About gRPC
- About: https://grpc.io/;
- Types: Unary, Server Streaming, Client Streaming, Bi Directional Streaming;
- Some advantages:
  - Multi-language suport;
  - Uses protocol buffer instead of JSON;
      - Saves on network bandwidth. JSON has to parse, protocol buffer is closer to machine language so it requires less CPU.
  - Uses HTTP/2, instead 1.0 like REST;
  - Clients can work sync or async;
  - Encourages the use of ssl and allows authentication with interceptor implementation;

JSON is human-readable because PLAINTEXT while Protocol Buffers is binary and needs a schema to be read properly

## 2. About this project

#### 2.1 Technologies
- Java 11; 
- Gradle;
- gRPC;

#### 2.2 Initial configuration (Intellij)
- Change project Gradle settings to "Build and run using" Intellij and "Run tests with Intellij";
- Execute: "Gradle > Task > other > generateProto". This will generate classes to be used in Java project;
    - Every change in .proto files must be followed by executing this again. Sometimes the deletion of "build" folder is required.

## 3. References
- grpc.io
- https://github.com/grpc/grpc-java
- https://github.com/simplesteph/grpc-java-course
- https://developers.google.com/protocol-buffers/docs/proto3#scalar
