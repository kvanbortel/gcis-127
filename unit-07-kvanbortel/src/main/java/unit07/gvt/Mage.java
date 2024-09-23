package unit07.gvt;

public class Mage extends Goat {

    public Mage(String name) {
        super(name, 125);
    }

    @Override
    public String toString() {
        return "A mage named " + getName() + " with " + getCurrentHP() + "/" + getMaxHP() + " hit points!";
    }

    @Override
    public Attack attack() {
        int[] hits = {9, 9, 9, 9};
        Attack attack = new Attack("Magic Missiles", hits, DamageType.MAGICAL);
        return attack;
    }

    // @Override
    // public void takeDamage(Attack attack) {
    //     int[] hits = attack.getHits();
    //     double multiplier = 1;
    //     if (attack.getDamageType() == DamageType.MAGICAL) {
    //         multiplier = 0.75;
    //     }
    //     else if (attack.getDamageType() == DamageType.PHYSICAL) {
    //         multiplier = 1.25;
    //     }
    //     for(int i = 0; i < hits.length; i++) {
    //         hits[i] *= multiplier;
    //     }
    //     super.takeDamage(attack);
    // }

    @Override
    public void takeDamage(Attack attack) {
        double multiplier = 1;
        if (attack.getDamageType() == DamageType.MAGICAL) {
            multiplier = 0.75;
        }
        else if (attack.getDamageType() == DamageType.PHYSICAL) {
            multiplier = 1.25;
        }
        super.takeDamage(createModifiedAttack(attack, multiplier));
    }

    public static void main(String[] args) {
        Mage mage1 = new Mage("Bobathan");
        Mage mage2 = new Mage("Maggie");
        System.out.println(mage1);
        System.out.println(mage2);

        mage1.takeDamage(mage2.attack());
        mage2.takeDamage(mage1.attack());
        System.out.println(mage1);
        System.out.println(mage2);
    }
}
