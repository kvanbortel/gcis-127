package unit12.guessing;

import java.io.IOException;
import java.net.Socket;

import unit12.duplexer.Duplexer;

public class GuessingGameProxy extends Duplexer implements GuessingGame {

    public GuessingGameProxy(Socket socket) throws IOException {
        super(socket);
    }

    @Override
    public void restart() {
        send("RESTART");
        try {
            String response = read();
            if (!response.equals("RESTARTED")) {
                System.out.println("Invalid response: " + response);
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    @Override
    public GuessResult guess(int number) {
        send("GUESS " + number);
        try {
            String response = read();
            if (response.equals("ERROR")) {
                System.out.println("Invalid response: " + response);
            }
            return GuessResult.valueOf(response);
        } catch (IOException ioe) {
            System.out.println(ioe);
            return null;
        }
    }

    @Override
    public void quit() {
        send("QUIT");
        try {
            String response = read();
            if (!response.equals("GAME_OVER")) {
                System.out.println("Invalid response: " + response);
            }
        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }
    
}
