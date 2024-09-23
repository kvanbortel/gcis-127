package unit13.queens.model;

import unit13.backtracker.Configuration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class NQueens implements Configuration<NQueens> {
    private List<Queen> queens;
    private final int n;

    public NQueens(int n) {
        this.n = n;
        queens = new ArrayList<>();
    }

    public NQueens(NQueens copy) { // Copy constructor which makes a deep copy, Arrays.copyOf
        n = copy.n;
        queens = new ArrayList<>(copy.queens);
    }

    @Override
    public Collection<NQueens> getSuccessors() {
        int row = queens.size();
        if (row == n) {
            return null; // Perhaps return an empty collection instead
        }
        Collection<NQueens> successors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            NQueens successor = new NQueens(this);
            successor.queens.add(new Queen(row, i));
            successors.add(successor);
        }
        return successors;
    }

    @Override
    public boolean isValid() {
        if (queens.isEmpty()) {
            return true;
        }
        Queen newQueen = queens.get(queens.size() - 1);
        for (int i = 0; i < queens.size() - 1; i++) {
            if (queens.get(i).canAttack(newQueen)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isGoal() {
        return queens.size() == n;
    }

    public Queen[] getQueens() {
        return queens.toArray(new Queen[queens.size()]);
    }

    @Override
    public String toString() {
        return n + ": " + queens.toString();
    }

    public static void main(String[] args) {
        NQueens config = new NQueens(4);
        System.out.println(config.toString());
        Collection<NQueens> successors = config.getSuccessors();
        for (NQueens successor: successors) {
            System.out.println(successor);
        }
        System.out.println(config.isValid());
        System.out.println(config.isGoal());
    }
    
}
