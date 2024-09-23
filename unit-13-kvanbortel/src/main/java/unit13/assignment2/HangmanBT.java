/*
 * This program solves any hangman puzzle
 * Author: Kayla Van Bortel
 */

package unit13.assignment2;

import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HangmanBT implements Configuration<HangmanBT> {
    private Hangman hangman;

    public HangmanBT(String secret) {
        hangman = new Hangman(secret);
    }

    public HangmanBT(HangmanBT copy) { // Deep copy
        hangman = new Hangman(copy.hangman);
    }

    /**
     * Returns what hasn't been guessed and is valid
     */
    @Override
    public Collection<HangmanBT> getSuccessors() {
        List<HangmanBT> successors = new ArrayList<>();
        for (char chr = 'A'; chr <= 'Z'; chr++) {
            HangmanBT copy = new HangmanBT(this);
            if (copy.step(chr)) {
                successors.add(copy);
            }
        }
        return successors;
    }

    public boolean step(char chr) {
        return hangman.guess(chr);
    }

    /* Valid if the max wrong guesses hasn't been reached */
    @Override
    public boolean isValid() {
        return hangman.getWrongGuesses() <= Hangman.MAX_WRONG;
    }

    /* Goal if the game status is WON */
    @Override
    public boolean isGoal() {
        return hangman.getStatus() == Hangman.Status.WON;
    }

    @Override
    public String toString() {
        return hangman.getGuesses() + ", " + hangman.revealed();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a secret phrase: ");
        String secret = scanner.nextLine();
        scanner.close();
        HangmanBT config = new HangmanBT(secret);
        
        Backtracker<HangmanBT> backtracker = new Backtracker<>(false);
        HangmanBT solution = backtracker.solve(config);
        System.out.println(solution.toString());
    }
    
}
