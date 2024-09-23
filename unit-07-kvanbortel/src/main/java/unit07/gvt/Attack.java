package unit07.gvt;

public class Attack {
    private String name;
    private int[] hits;
    private DamageType damageType;

    public Attack(String name, int[] hits, DamageType damageType) {
        this.name = name;
        this.hits = hits;
        this.damageType = damageType;
    }

    public String getName() {
        return this.name;
    }

    public int[] getHits() {
        return hits;
    }

    public DamageType getDamageType() {
        return damageType;
    }
}
