/*  This program is the handler for the client with name, messages, and quit
    Author: Kayla Van Bortel */

package unit12.tinychat;

import java.net.Socket;
import java.io.IOException;
import java.util.Map;

public class TinyChatClientHandler implements Runnable {
    private Map<String, Duplexer> clientInfo;
    private Duplexer duplexer;

    // Crete a new duplexer with client info
    public TinyChatClientHandler(Socket client, TinyChatServer server) throws IOException {
        duplexer = new Duplexer(client);
        clientInfo = server.getClientInfo();
    }

    @Override
    public void run() {
        /** Wrap the run method in a try/catch */
        try {
            doClient();
        } catch(IOException ioe) {
            System.out.println(ioe);
        }
    }

    public void doClient() throws IOException {
        // The user connects with their name and it is broadcasted to the peers
        String name = duplexer.read();
        duplexer.send("Connected");
        clientInfo.put(name, duplexer);
        sendToPeers(name, "Connected");

        // If the user enters "Quit", print as message and close their connection
        while (true) {
            String request = duplexer.read();
            System.out.println(name + ": " + request);
            sendToPeers(name, request);
            if (request.equals("Quit")) {
                break;
            }
        }
        duplexer.send("Closing");
        duplexer.close(); // Close the client connection
    }

    public void sendToPeers(String name, String message) {
        // Broadcast to each client that isn't the duplexer
        for (Duplexer peer: clientInfo.values()) {
            if (peer != duplexer) {
                peer.send(name + ": " + message);
            }
        }
    }
    
}
