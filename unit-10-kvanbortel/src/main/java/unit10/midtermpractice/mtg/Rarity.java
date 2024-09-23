package unit10.midtermpractice.mtg;

public enum Rarity {
    COMMON(11),
    UNCOMMON(3),
    RARE(1);

    private int value;

    private Rarity(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name() + " (" + value + ")";
    }
}
