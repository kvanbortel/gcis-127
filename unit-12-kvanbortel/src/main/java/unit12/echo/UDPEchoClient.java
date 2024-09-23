package unit12.echo;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.IOException;

public class UDPEchoClient {
    public static void main(String[] args) throws IOException {
        String message = "Goodybye!";
        System.out.println("Sending: " + message);
        DatagramPacket outgoing = new DatagramPacket(message.getBytes(), message.length(),
                                                    InetAddress.getByName("localhost"), 54321);

        DatagramSocket out = new DatagramSocket();
        out.send(outgoing);


        byte[] buffer = new byte[1024];
        DatagramPacket incoming = new DatagramPacket(buffer, buffer.length);
        out.receive(incoming);
        String received = new String(incoming.getData(), 0, incoming.getLength());
        System.out.println("Recieved: " + received);

        out.close();
    }
}
