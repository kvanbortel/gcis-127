package unit08.practicum;

public abstract class Fighter {
    private String name;
    private int health;
    private int currentHealth;

    public Fighter(String name, int health) {
        this.name = name;
        this.health = health;
        this.currentHealth = health;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public abstract String toString();

    public abstract int attack();

    public abstract void takeDamage(int amount);

    public boolean isConscious() {
        if (currentHealth <= 0) {
            return false;
        }
        return true;
    }

    /*    a. You can get the amount of damage of their next attack (a positive 
      integer). All fighters attack differently.
   b. You can deal an amount of damage to them (a positive integer). All 
      fighters take damage differently.
   c. A fighter is unconscious if health drops to 0.
 */
}
