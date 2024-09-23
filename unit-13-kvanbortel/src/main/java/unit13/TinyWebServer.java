/*
 * This class creates a server that prints the first three lines of th received request and sends something back
 * Author: Kayla Van Bortel
 */

package unit13;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class TinyWebServer implements Runnable {
    private ServerSocket serverSocket;
    private Socket connection;

    public TinyWebServer(ServerSocket serverSocket, Socket connection) {
        this.serverSocket = serverSocket;
        this.connection = connection;
    }

    /** try/catch wrapper */
    @Override
    public void run() {
        try {
            doServer();
        } catch (IOException ioe) {}
    }

    /**
     * Read the first three lines and then send a "Hello Workd!" message
     * @throws IOException
     */
    public void doServer() throws IOException {
        // Read the first three lines
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        for (int i = 0; i < 3; i++) {
            System.out.println(in.readLine());
        }

        // Send message
        OutputStream out = connection.getOutputStream();
        String message = "HTTP/1.1 200 OK\r\n" 
                       + "Content-Length: 12\r\n"
                       + "Content-Type: text/plain; charset=utf-8\r\n\r\n"
                       + "Hello World!\r\n";
        out.write(message.getBytes());
        out.flush();
        
        // Close everything
        serverSocket.close();
        in.close();
        out.close();
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket connection = serverSocket.accept();

        Thread thread = new Thread(new TinyWebServer(serverSocket, connection));
        thread.start();
    }
}
