package unit08.practicum;

import java.util.Random;

public class Lonk extends Fighter {
    private int currentHealth;


    public Lonk() {
        super("Lonk", 150);
    }

    @Override
    public int attack() {
        return 45;
    }

    @Override
    public void takeDamage(int amount) {
        Random random = new Random();
        int chance = random.nextInt(2);
        if (chance == 1) {
            currentHealth -= (amount / 2);
        }
        else {
            currentHealth -= amount;
        }
    }

    @Override
    public String toString() {
        return "Lonk wins! Lonk has " + getCurrentHealth() + "/150 health.";
    }

    /*Lonk         150     Sword hits for 45          50% chance to block; damage
                                                reduced by half (rounded 
                                                down). */
}
