##About gRPC
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

##About this project
- TO DO

##Important configurations...
- Change project Gradle settings to "Build and run using" Intellij and "Run tests with Intellij";
- The "idea" included in build.gradle is needed for imports to be valid in the classes;
- Every change in .proto files must be followed by executing "Gradle > Task > other > genreateProto". Sometimes deletion of "build" folder is needed.

##References
- grpc.io
- https://github.com/grpc/grpc-java
- https://github.com/simplesteph/grpc-java-course
- https://developers.google.com/protocol-buffers/docs/proto3#scalar