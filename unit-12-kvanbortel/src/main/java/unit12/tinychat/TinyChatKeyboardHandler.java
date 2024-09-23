/*  This program handles keyboard input and whether to end it
    Author: Kayla Van Bortel */

package unit12.tinychat;

import java.io.IOException;
import java.util.Scanner;

public class TinyChatKeyboardHandler implements Runnable {
    private Duplexer duplexer;

    public TinyChatKeyboardHandler(Duplexer duplexer) throws IOException {
        this.duplexer = duplexer;
    }

    @Override
    public void run() {
        /** Read the messages and send them */
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.nextLine();
            duplexer.send(message);
            if (message.equals("Quit")) {
                break;
            }
        }
    }
    
}
