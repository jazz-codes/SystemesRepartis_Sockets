import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class SERVEURUDP {

    public static void main(String[] args) throws IOException {
        int port = 5000; // Choose a port number

        // Create a DatagramSocket
        DatagramSocket serverSocket = new DatagramSocket(port);

        System.out.println("ServerTCP started on port " + port);

        while (true) {
            // Receive a datagram packet
            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);

            // Process the received data
            String message = new String(receivePacket.getData()).trim();
            System.out.println("Received from client: " + message);

            // Prepare and send a response
            String response = "ServerTCP response: " + message.toUpperCase();
            byte[] sendData = response.getBytes();
            InetAddress clientAddress = receivePacket.getAddress();
            int clientPort = receivePacket.getPort();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientAddress, clientPort);
            serverSocket.send(sendPacket);
        }
    }
}
