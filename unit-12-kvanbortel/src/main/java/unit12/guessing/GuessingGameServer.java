package unit12.guessing;

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

import unit12.duplexer.Duplexer;

public class GuessingGameServer extends Duplexer implements Runnable {
    private GuessingGame game;

    public GuessingGameServer(Socket socket) throws IOException {
        super(socket);
        game = new GuessingGameImpl();
    }
    
    public void run() {
        String response = "";
        while (!response.equals("GAME_OVER")) {
            try {
                String request = read();
                System.out.println("Received " + request);
                if (request.equals("QUIT")) {
                    game.quit();
                    response = "GAME_OVER";
                    return;
                }
                else if (request.equals("RESTART")) {
                    game.restart();
                    response = "RESTARTED";
                }
                else if (request.split(" ")[0].equals("GUESS")) {
                    int guess = Integer.parseInt(request.split(" ")[1]); // split on what?
                    response = game.guess(guess).toString();
                }
                else {
                    response = "ERROR";
                }
                // System.out.println(response);
                send(response);
            } catch (IOException ioe) {
                // System.out.println(ioe);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(54321);
        
        while (true) {
            Socket client = serverSocket.accept();
            new Thread(new GuessingGameServer(client)).start();
        }
    }
}
