package unit08.practicum;

import java.util.Random;

public class Manio extends Fighter {
    private int currentHealth;


    public Manio() {
        super("Manio", 100);
    }

    @Override
    public int attack() {
        Random random = new Random();
        return random.nextInt(51) + 25;
    }

    @Override
    public void takeDamage(int amount) {
        Random random = new Random();
        int chance = random.nextInt(5);
        if (chance == 1) {
            currentHealth -= amount;
        }
    }

    @Override
    public String toString() {
        return "Manio wins! Manio has " + getCurrentHealth() + "/100 health.";
    }


    /* Name         Health   Attack                     Taking Damage

Manio (or    100     Jump Attack hits for       25% chance to dodge all 
Louie G.)            25-50 damage.              damage. */
}
