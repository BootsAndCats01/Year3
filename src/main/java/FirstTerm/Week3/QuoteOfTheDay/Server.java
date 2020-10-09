package FirstTerm.Week3.QuoteOfTheDay;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Server {

    private DatagramSocket udpSocket;
    private int port;

    public Server(int port) throws SocketException, IOException {
        this.port = port;
        this.udpSocket = new DatagramSocket();
    }

    private void listen() throws Exception {

        try {
            DatagramPacket request = new DatagramPacket(new byte[1], 1, InetAddress.getByName("djxmmx.net"), port);
            udpSocket.send(request);

            byte[] buffer = new byte[256];
            DatagramPacket response = new DatagramPacket(buffer, buffer.length);
            udpSocket.receive(response);

            String quote = new String(buffer, 0, response.getLength());
            System.out.println(quote);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        Server server = new Server(17);
        server.listen();
    }
}
