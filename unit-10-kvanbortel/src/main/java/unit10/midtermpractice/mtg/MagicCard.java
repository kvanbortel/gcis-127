package unit10.midtermpractice.mtg;

public class MagicCard {
    private String name;
    private int power;
    private int toughness;
    private Rarity rarity;
    private String manaValue;
    private boolean isDiscarded;
    private int currentDamaged;

    public MagicCard(String name, int power, int toughness, String manaValue, Rarity rarity) {
        this.name = name;
        this.power = power;
        this.toughness = toughness;
        this.manaValue = manaValue;
        this.rarity = rarity;
        this.isDiscarded = false;
        this.currentDamaged = toughness;
    }

    public int getConvertedManaCost() {
        int generic = (int)(this.manaValue.charAt(0));
        return generic + 2;
    }

    public boolean isDiscarded() {
        if (currentDamaged <= 0) {
            return true;
        }
        return false;
    }

    public int getPower() {
        return power;
    }

    public int getToughness() {
        return toughness;
    }

    public Rarity getRarity() {
        return rarity;
    }

    public String getManaValue() {
        return manaValue;
    }

    public void discard() {
        this.isDiscarded = true;
    }

    public void attack(MagicCard blocker) {
        if (this.power >= blocker.getToughness()) {
            blocker.discard();
        }
        blocker.currentDamaged -= this.power;
        // System.out.println(name + " attacked " + blocker + " subtracting " + this.power);
        if (blocker.currentDamaged < 0) {
            blocker.currentDamaged = 0;
        }
    }

    @Override
    public String toString() {
        return name + " has " + currentDamaged + "/" + toughness;
    }

    public static void main(String[] args) {
        MagicCard a = new MagicCard("a", 10, 10, "6RR", Rarity.COMMON);
        MagicCard b = new MagicCard("b", 15, 20, "9UU", Rarity.RARE);
        System.out.println(a.toString());
        System.out.println(b.toString());
        a.attack(b);
        b.attack(a);
        System.out.println(a.toString());
        System.out.println(b.toString());
    }
}
