package unit08.practicum;

public class Arena {
    public static void main(String[] args) {
        Lonk lonk = new Lonk();
        Manio manio = new Manio();
        
        while (lonk.isConscious() && manio.isConscious()) {
            int lonkAttack = lonk.attack();
            int manioAttack = manio.attack();
            lonk.takeDamage(manioAttack);
            manio.takeDamage(lonkAttack);
        }

        if (lonk.isConscious()) {
            System.out.println(lonk.toString());
        }
        else if(manio.isConscious()) {
            System.out.println(manio.toString());
        }
        else {
            System.out.println("It's a draw!");
        }
    }

    /*   a. Battle continues as long as both fighters are conscious.
   b. During each round of battle, both fighters damage each other.
   c. At the end of battle, the winner is announced (using its toString()), 
      e.g. "Manio wins!" If both fighters are unconscious, it is a draw. */
}
