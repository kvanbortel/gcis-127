package unit12.mypractice;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MyUDPClient {
    public static void main(String[] args) throws IOException {
        String message = "Hey!";
        System.out.println("Sending: " + message);
        DatagramPacket outgoing = new DatagramPacket(message.getBytes(), message.length(), InetAddress.getByName("localhost"), 54321);
        DatagramSocket out = new DatagramSocket();
        out.send(outgoing);

        byte[] buffer = new byte[1024];
        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
        out.receive(incoming);
        String received = new String(incoming.getData(), 0, incoming.getLength());
        System.out.println("Received: " + received);

        out.close();
    }
}
