import java.io.*;
import java.net.*;

public class ServerTCP {

    public static void main(String[] args) throws IOException {
        int portNumber = 9874; // Port number to listen on

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("ServerTCP started on port " + portNumber);

            while (true) {
                Socket clientSocket = serverSocket.accept(); // Wait for a client connection

                System.out.println("ClientTCP connected from " + clientSocket.getRemoteSocketAddress());

                try (DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                     DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream())) {

                    // Receive message from client
                    String message = in.readUTF();
                    System.out.println("Received message from client: " + message);

                    // Send response to client
                    out.writeUTF("ServerTCP received your message: " + message);
                }

                clientSocket.close(); // Close the client connection
            }
        }
    }
}
