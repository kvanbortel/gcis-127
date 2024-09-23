package unit07.gvt;

public class Trollzord extends Troll {

    public Trollzord() {
        super("Trollzord", 64);
    }

    @Override
    public Attack attack() {
        int[] hits = {25};
        return new Attack("Flame War", hits, DamageType.MAGICAL);
    }

    @Override
    public void takeDamage(Attack attack) {
        int[] hits = attack.getHits();
        double multiplier = 1;
        if(attack.getDamageType() == DamageType.HOLY) {
            multiplier = 1.25;
        }
        for(int i = 0; i < hits.length; i++) {
            adjustHP ((int)(-hits[i] * multiplier));
        }
    }

    @Override
    public void regenerate() {
        adjustHP((int)(getMaxHP() * 0.05));
    }
}
