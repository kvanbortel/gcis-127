package unit07.gvt;

public abstract class Troll {
    private String name;
    private int maxHP;
    private int currentHP;

    public Troll(String name, int maxHP) {
        this.name = name;
        this.maxHP = maxHP;
        this.currentHP = maxHP;
    }

    public abstract Attack attack();
    public abstract void takeDamage(Attack Attack);
    public abstract void regenerate();

    public String getName() {
        return name;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public boolean isVanquished() {
        return currentHP == 0;
    }

    protected void adjustHP(int amount) {
        currentHP += amount;
        if (currentHP > maxHP) {
            currentHP = maxHP;
        }
        else if (currentHP < 0) {
            currentHP = 0;
        }
    }
}
