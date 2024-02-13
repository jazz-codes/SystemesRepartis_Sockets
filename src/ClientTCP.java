import java.io.*;
import java.net.*;

public class ClientTCP {

    public static void main(String[] args) throws IOException {
        String serverAddress = "localhost"; // ServerTCP hostname or IP address
        int portNumber = 9874; // Port number to connect to

        try (Socket clientSocket = new Socket(serverAddress, portNumber)) {
            System.out.println("Connected to server " + serverAddress + ":" + portNumber);

            try (DataInputStream in = new DataInputStream(clientSocket.getInputStream());
                 DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream())) {

                // Send message to server
                String message = "Hello from client!";
                out.writeUTF(message);

                // Receive response from server
                String serverResponse = in.readUTF();
                System.out.println("ServerTCP response: " + serverResponse);
            }
        }
    }
}
