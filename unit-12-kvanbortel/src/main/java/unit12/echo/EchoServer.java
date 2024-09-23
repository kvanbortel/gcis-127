package unit12.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(54321);
        Socket client = serverSocket.accept();

        InputStream input = client.getInputStream();
        InputStreamReader ir = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(ir);
        String received = reader.readLine();

        OutputStream out = client.getOutputStream();
        PrintWriter writer = new PrintWriter(out);
        writer.println(received);
        writer.flush();

        serverSocket.close();
        client.close();
    }
}
