/* This program is the server and communicates with the client to get an intersection of two sets
   Author: Kayla Van Bortel */

package unit12.intersection;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.io.IOException;
import java.util.Set;
import java.util.HashSet;

public class SIServer {
    private DatagramSocket socket;
    private DatagramPacket packetIn;
    private Set<String> intersection;
    private Set<String> set;

    public SIServer(int port, Set<String> set) throws IOException {
        byte[] buffer = new byte[1024];
        packetIn = new DatagramPacket(buffer, buffer.length);
        socket = new DatagramSocket(port);
        this.set = set;
        intersection = new HashSet<>();
    }

    public void send(String message) throws IOException {
        /** Send packets to the client */
        DatagramPacket outgoing = new DatagramPacket(message.getBytes(), message.length(),
                                                    packetIn.getAddress(), packetIn.getPort());
        socket.send(outgoing);
    }

    public String receive() throws IOException {
        /** Revieve packets from the client */
        socket.receive(packetIn);
        return new String(packetIn.getData(), 0, packetIn.getLength());
    }

    public void close() {
        socket.close();
    }

    public void mainLoop() throws IOException {
        // Recieve set element from the client
        String received = this.receive();
        // If server has the element, remove from its set and add to intersection
        if (set.contains(received)) {
            getIntersection().add(received);
            set.remove(received);
        }
        // If the server doesn't have the element, notify the client
        else {
            this.send("NO");
        }
        // Send an element from the server set to the client
        String element = set.iterator().next();
        this.send(element);

        while(!set.isEmpty()) {
            // Remove the sent element from the server set
            set.remove(element);
            // Recieve an element from the client
            received = this.receive();
            // If the client doesn't have the element, request the next one
            if (received.equals("NO")) {
                received = this.receive();
            }
            // If the client has the element, add it to the intersection
            else {
                getIntersection().add(element);
            }
            // If the client has finished, break
            if (received.equals("END")) {
                break;
            }
            // If the element is in the server set, remove it and add it to intersection
            if (set.contains(received)) {
                getIntersection().add(received);
                set.remove(received);
            }
            // If the server doesn't have the element, notify the client
            else {
                this.send("NO");
            }
            // Send elements to the client until the server's set is empty
            if (!set.isEmpty()) {
                element = set.iterator().next();
                this.send(element);
            }
        }
        // Notify the client that the server has exhausted its set
        this.send("END");
    }

    public Set<String> getIntersection() {
        return intersection;
    }

    public static void main(String[] args) throws IOException {
        SIServer server = new SIServer(54321, Sets.B1());
        server.mainLoop();
        System.out.println(server.getIntersection());
        server.close();

        // SIServer server = new SIServer(54321, Sets.B2());
        // server.mainLoop();
        // System.out.println(server.getIntersection());
        // server.close();

        // SIServer server = new SIServer(54321, Sets.B3());
        // server.mainLoop();
        // System.out.println(server.getIntersection());
        // server.close();

        // SIServer server = new SIServer(54321, Sets.B4());
        // server.mainLoop();
        // System.out.println(server.getIntersection());
        // server.close();

        // SIServer server = new SIServer(54321, Sets.B5());
        // server.mainLoop();
        // System.out.println(server.getIntersection());
        // server.close();



        // server.send(server.receive());
        // server.close();
    }
}
