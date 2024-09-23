/*  This program runs the client for Tiny Chat
    Author: Kayla Van Bortel */

package unit12.tinychat;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TinyChatClient {
    public static void main(String[] args) throws IOException {
        // Read the user's name
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        // Create a duplexer
        Socket client = new Socket("localhost", 12410);
        Duplexer duplexer = new Duplexer(client);

        duplexer.send(name);
        System.out.println(duplexer.read()); // Display the connection message
        
        // Start message handling
        Thread messageHandler = new Thread(new TinyChatKeyboardHandler(duplexer));
        messageHandler.start();

        // Read and print user messages until the user closes
        while (true) {
            String response = duplexer.read();
            if (response.equals("Closing")) {
                break;
            }
            System.out.println(response);
        }
        scanner.close();
        duplexer.close();
    }
}
