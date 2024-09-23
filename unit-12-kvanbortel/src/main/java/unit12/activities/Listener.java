package unit12.activities;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Listener {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(22); // open PowerShell, type 'ncat localhost 22' (close any existing SSH servers in Services)
        Socket client = server.accept();
        System.out.println("Socket connected");

        InputStream input = client.getInputStream();
        Scanner scanner = new Scanner(input);

        while(scanner.hasNext()) {
            System.out.println(scanner.next());
        }

        server.close();
        client.close();
        scanner.close();
    }
}
