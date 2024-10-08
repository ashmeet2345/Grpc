package Sum.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class SumServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        int port=50051;
        Server server= ServerBuilder.forPort(port)
               /* .addService(new SumServiceImpl())*/
                .addService(new SqrtServiceImpl()).build();
        server.start();

        System.out.println("Server Started");
        System.out.println("Listening on port: "+port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Received Shutdown request");
            server.shutdown();
            System.out.println("Server stopped");
        }));

        server.awaitTermination();
    }
}
