package unit12.echo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 54321);
        PrintWriter writer = new PrintWriter(client.getOutputStream());
        String message = "Hello!";
        System.out.println("Sending: " + message);
        writer.println(message);
        writer.flush();

        InputStream input = client.getInputStream();
        InputStreamReader ir = new InputStreamReader(input);
        BufferedReader reader = new BufferedReader(ir);
        message = reader.readLine();
        System.out.println("Revieved: " + message);

        client.close();
    }
}
