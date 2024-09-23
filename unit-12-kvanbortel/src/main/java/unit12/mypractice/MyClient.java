package unit12.mypractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 54321);
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        String message = "Hello!";
        System.out.println("Sending: " + message);
        out.println(message);
        out.flush();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println("Received: " + in.readLine());

        socket.close();
    }
}
