import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class CLIENTUDP {

    public static void main(String[] args) throws IOException {
        String serverAddress = "localhost"; // Replace with server IP or hostname
        int serverPort = 5000; // Same port as server
        String message = "Hello from client!";

        // Create a DatagramSocket
        DatagramSocket clientSocket = new DatagramSocket();

        // Convert message to bytes
        byte[] sendData = message.getBytes();

        // Create a datagram packet to send
        InetAddress serverIP = InetAddress.getByName(serverAddress);
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIP, serverPort);

        // Send the packet
        clientSocket.send(sendPacket);

        // Receive the response
        byte[] receiveData = new byte[1024];
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        clientSocket.receive(receivePacket);

        // Process the received data
        String response = new String(receivePacket.getData()).trim();
        System.out.println("Received from server: " + response);

        // Close the socket
        clientSocket.close();
    }
}
