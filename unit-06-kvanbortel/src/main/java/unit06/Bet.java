package unit06;

public class Bet {
    private int amount;
    private Color color;
    private int number;

    public int getAmount() {
        return amount;
    }

    public Color getColor() {
        return color;
    }

    public int getNumber() {
        return number;
    }

    public Bet(int amount, Color color) {
        this.number = -1;
        this.amount = amount;
        this.color = color;
    }

    public Bet(int amount, int number) {
        this.amount = amount;
        this.number = number;
    }
}
