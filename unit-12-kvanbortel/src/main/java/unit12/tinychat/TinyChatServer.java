/*  This program runs the server for Tiny Chat
    Author: Kayla Van Bortel */

package unit12.tinychat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.HashMap;

public class TinyChatServer {
    private ServerSocket serverSocket;
    private Map<String, Duplexer> clientInfo = new HashMap<>();

    public TinyChatServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
    }

    public Map<String, Duplexer> getClientInfo() {
        return clientInfo;
    }

    public void serve() throws IOException {
        /** Create the client and run the handler */
        while (true) {
            Socket client = serverSocket.accept();
            TinyChatClientHandler handler = new TinyChatClientHandler(client, this);
            Thread handlerThread = new Thread(handler);
            handlerThread.start();
        }
    }

    public void close() throws IOException {
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException {
        TinyChatServer tinyServer = new TinyChatServer(12410);
        tinyServer.serve();
        tinyServer.close();
    }
}
