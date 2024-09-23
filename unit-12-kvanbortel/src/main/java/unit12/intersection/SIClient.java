/* This program is the client and communicates with the server to get an intersection of two sets
   Author: Kayla Van Bortel */

package unit12.intersection;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Set;
import java.util.HashSet;
import java.io.IOException;

public class SIClient {
    private DatagramSocket socket;
    private final String SERVER_NAME;
    private final int PORT;
    private Set<String> set;
    private Set<String> intersection;

    public SIClient(String SERVER_NAME, int PORT, Set<String> set) throws IOException {
        this.SERVER_NAME = SERVER_NAME;
        this.PORT = PORT;
        socket = new DatagramSocket();
        this.set = set;
        intersection = new HashSet<>();
    }

    public void send(String message) throws IOException {
        /** Sends packets to the server */
        System.out.println("Sending: " + message);
        DatagramPacket outgoing = new DatagramPacket(message.getBytes(), message.length(),
                                                    InetAddress.getByName(SERVER_NAME), PORT);
        socket.send(outgoing);
    }

    public String receive() throws IOException {
        /** Recieves packets from the server */
        byte[] buffer = new byte[1024];
        DatagramPacket packetIn = new DatagramPacket(buffer, buffer.length);
        socket.receive(packetIn);
        String received = new String(packetIn.getData(), 0, packetIn.getLength());
        System.out.println("Recieved: " + received);
        return received;
    }

    public void close() {
        socket.close();
    }

    public void mainLoop() throws IOException {
        // Send one of the elements from the Client set to the Server
        String element = set.iterator().next();
        this.send(element);
 
        while(!set.isEmpty()) {
            // Remove the sent element from the set
            set.remove(element);
            // Recieve an element from the server
            String received = this.receive();
            // If the server doesn't have the element in its set, request the next one
            if (received.equals("NO")) {
                received = this.receive();
            }
            // If the server has the sent element, add it to intersection
            else {
                getIntersection().add(element);
            }
            // If the server is at the end of its set, stop
            if (received.equals("END")) {
                break;
            }
            // If the client has the received element in its set, remove it and add it to intersection
            if (set.contains(received)) {
                getIntersection().add(received);
                set.remove(received);
            }
            // If the client doesn't have the element, tell the server
            else {
                this.send("NO");
            }
            // While there are still elements, send the next element to the server
            if (!set.isEmpty()) {
                element = set.iterator().next();
                this.send(element);
            }
        }
        // When the set it empty, notify the server
        this.send("END");
    }

    public Set<String> getIntersection() {
        return intersection;
    }

    public static void main(String[] args) throws IOException {        
        SIClient client = new SIClient("localhost", 54321, Sets.A1());
        client.mainLoop();
        System.out.println(client.getIntersection());
        client.close();

        // SIClient client = new SIClient("localhost", 54321, Sets.A2());
        // client.mainLoop();
        // System.out.println(client.getIntersection());
        // client.close();

        // SIClient client = new SIClient("localhost", 54321, Sets.A3());
        // client.mainLoop();
        // System.out.println(client.getIntersection());
        // client.close();

        // SIClient client = new SIClient("localhost", 54321, Sets.A4());
        // client.mainLoop();
        // System.out.println(client.getIntersection());
        // client.close();

        // SIClient client = new SIClient("localhost", 54321, Sets.A5());
        // client.mainLoop();
        // System.out.println(client.getIntersection());
        // System.out.println(client.getIntersection().equals(Sets.AB5()));
        // client.close();


        // client.send("Goodbye!");
        // client.receive();
        // client.close();
    }
}
