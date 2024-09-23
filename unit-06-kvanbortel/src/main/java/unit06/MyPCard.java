package unit06;

public class MyPCard {
    private MyPValue value;
    private MyPColor color;
    private MyPSuit suit;

    public MyPValue getValue() {
        return value;
    }

    public MyPColor getColor() {
        return color;
    }

    public MyPSuit getSuit() {
        return suit;
    }

    public MyPCard(MyPValue value, MyPColor color, MyPSuit suit) {
        this.value = value;
        this.color = color;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "a " + color + " " + value + " (" + value.getNumber() + ")" + " of " + suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MyPCard) {
            MyPCard other = (MyPCard)obj;
            return color.equals(other.color) && value.getNumber() == other.value.getNumber() &&
            suit.equals(other.suit);
        }
        else {
            return false;
        }
    }
}
