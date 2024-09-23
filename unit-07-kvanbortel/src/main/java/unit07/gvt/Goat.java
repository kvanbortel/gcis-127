package unit07.gvt;

public abstract class Goat {
    private String name;
    private int maxHP;
    private int currentHP;

    public String getName() {
        return name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public Goat(String name, int maxHP) {
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
    }

    @Override
    public String toString() {
        return "A goat named " + name + " with " + currentHP + "/" + maxHP + " hit points!";
    }

    abstract public Attack attack();

    public void heal(int amount) {
        currentHP += amount;
        if (currentHP > maxHP) {
            currentHP = maxHP;
        }
    }

    public boolean isConscious() {
        return currentHP > 0;
    }

    protected Attack createModifiedAttack(Attack attack, double modifier) {
        int[] hits = attack.getHits();
        double multiplier = 1;
        for(int i = 0; i < hits.length; i++) {
            hits[i] *= multiplier;
        }
        return attack;
    }

    public void takeDamage(Attack attack) {
        int[] hits = attack.getHits();
        for (int i = 0; i < attack.getHits().length; i++) {
            currentHP -= hits[i];
        }
        if (currentHP < 0) {
            currentHP = 0;
        }
    }
}
