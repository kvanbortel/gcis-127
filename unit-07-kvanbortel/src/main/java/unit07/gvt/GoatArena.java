package unit07.gvt;

public class GoatArena {
    public static void battle(Goat goat1, Goat goat2) {
        while (goat1.isConscious() && goat2.isConscious()) {
            Attack g2Attack = goat2.attack();
            Attack g1Attack = goat1.attack();
            goat1.takeDamage(g2Attack);
            goat2.takeDamage(g1Attack);
            System.out.println(goat1);
            System.out.println(goat2);
        }
        if (goat1.isConscious()) {
            System.out.println("Goat 1 wins!");
        }
        else if (goat2.isConscious()) {
            System.out.println("Goat 2 wins!");
        }
        else {
            System.out.println("Draw!");
        }
    } 

    public static void main(String[] args) {
        Goat mage = new Mage("Master Goat");
        Goat fighter = new Fighter("Wizzahrd"); // should start with 114/150 in output...
        battle(mage, fighter);
    }
}
