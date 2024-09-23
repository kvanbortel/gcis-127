package unit07.gvt;

public class Fighter extends Goat{
    
    public Fighter(String name) {
        super(name, 150);
    }

    @Override
    public String toString() {
        return "A fighter named " + getName() + " with " + getCurrentHP() + "/" + getMaxHP() + " hit points!";
    }

    @Override
    public Attack attack() {
        int[] hits = {25};
        Attack attack = new Attack("Cleave", hits, DamageType.PHYSICAL);
        return attack;
    }

    @Override
    public void takeDamage(Attack attack) {
        double multiplier = 1;
        if (attack.getDamageType() == DamageType.PHYSICAL) {
            multiplier = 0.75;
        }
        else if (attack.getDamageType() == DamageType.MAGICAL) {
            multiplier = 1.25;
        }
        super.takeDamage(createModifiedAttack(attack, multiplier));
    }

    public static void main(String[] args) {
        Fighter fighter1 = new Fighter("DaGoat");
        Fighter fighter2 = new Fighter("Goatee");
        System.out.println(fighter1);
        System.out.println(fighter2);

        fighter1.takeDamage(fighter2.attack());
        fighter2.takeDamage(fighter1.attack());
        System.out.println(fighter1);
        System.out.println(fighter2);
    }
}
