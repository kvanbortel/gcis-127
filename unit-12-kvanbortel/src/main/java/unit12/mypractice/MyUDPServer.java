package unit12.mypractice;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class MyUDPServer {
    public static void main(String[] args) throws IOException {
        byte[] buffer = new byte[1024];

        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
        DatagramSocket in = new DatagramSocket(54321);
        in.receive(incoming);
        String message = new String(incoming.getData(), 0, incoming.getLength());
        System.out.println(message);

        DatagramPacket outgoing = new DatagramPacket(message.getBytes(), message.length(), incoming.getAddress(), incoming.getPort());
        in.send(outgoing);
        in.close();
    }
}
