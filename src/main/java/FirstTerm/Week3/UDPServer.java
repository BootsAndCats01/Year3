package FirstTerm.Week3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {

    private DatagramSocket udpSocket;
    private int port;

    public UDPServer(int port) throws SocketException, IOException {
        this.port = port;
        this.udpSocket = new DatagramSocket(this.port);
    }

    private void listen() throws Exception {
        System.out.println("-- Running server at " + InetAddress.getLocalHost() + " --");
        String message;

        while (true) {
            // holds info
            byte[] buffer = new byte[256];
            //wrapped it in packet
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            //socket receives the packet
            udpSocket.receive(packet);

            message = new String(packet.getData()).trim();
            System.out.println("Message from " + packet.getAddress().getHostAddress() + ": " + message);

        }
    }

    public static void main(String[] args) throws Exception {
        UDPServer server = new UDPServer(17);
        server.listen();
    }
}
