package unit12.guessing;

import java.io.IOException;
import java.net.Socket;

public class NetworkGuessingGame {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 54321);

        // make a guessing game
        GuessingGame game = new GuessingGameProxy(socket);
        // use a game player to play it
        GamePlayer player = new GamePlayer(game);
        player.playTheGame();
    }
}
