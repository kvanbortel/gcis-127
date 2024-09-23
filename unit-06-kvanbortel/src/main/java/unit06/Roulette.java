/* This program simulates roulette. 
 * Author: Kayla Van Bortel */
package unit06;

import java.util.Random;
import java.util.Scanner;

public class Roulette {

    private static int winLocation = -1;
    private static Color winColor = null;

    private Roulette() {}

    public static void spin() {
        /** Creates win location and color and spins the wheel */
        generateWinColor();
        System.out.println("The wheel spins...");
        System.out.println("It lands on " + winLocation + " " + winColor + "!");
    }

    public static void generateWinLocation() {
        /** Selects the win location */
        Random random = new Random();
        winLocation = random.nextInt(37);
    }

    public static void generateWinColor() {
        /** Selects the win color based on location */
        generateWinLocation();
        if (winLocation == 0) {
            winColor = Color.GREEN;
        }
        else if (winLocation % 2 == 0) {
            winColor = Color.BLACK;
        }
        else {
            winColor = Color.RED;
        }
    }

    public static int winCheck(Bet bet) {
        /** Checks if bet is on winning spot and gives payout */
        if (bet.getNumber() == winLocation) {
            return bet.getAmount() * 36;
        }
        if (bet.getColor() == winColor) {
            return bet.getAmount() * 2;
        }
        return 0;
    }

    public static void main(String[] args) {
        /** Gets bets and spins the wheel */
        // Reads bet input
        String[] values;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your bets ($ #/R/B, $ #/R/B, ...): ");
        String bets = scanner.nextLine();
        scanner.close();

        // Creates Bets
        values = bets.split(",");
        Bet[] betObjects = new Bet[values.length];
        for (int i = 0; i < values.length; i++) {
            String[] nextBet = values[i].trim().split(" ");
            char c = nextBet[1].charAt(0);
            Bet bet;
            int amount = Integer.parseInt(nextBet[0]);
            if (c >= '0' && c <= '9') {
                bet = new Bet(amount, Integer.parseInt(nextBet[1]));
            }
            else if (c == 'R') {
                bet = new Bet(amount, Color.RED);
            }
            else {
                bet = new Bet(amount, Color.BLACK);
            }
            betObjects[i] = bet;
        }

        // Calculates payout
        spin();
        int payout = 0;
        for (int i = 0; i < betObjects.length; i++) {
            payout = payout + winCheck(betObjects[i]);
        }
        System.out.println("You won $" + payout + "!");
    }
}
