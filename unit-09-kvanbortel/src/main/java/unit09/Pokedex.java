/* This program lets you add Pokemon to a Pokedex and see if it contains them
 * Author: Kayla Van Bortel */

package unit09;

public class Pokedex {
    private BinarySearchTree<Integer> bst;

    public Pokedex() {
        bst = new NodeBST<>();
    }

    public void addPokemon(int number) {
        if (!containsPokemon(number)) {
            bst.insert(number);
        }
    }

    @Override
    public String toString() {
        return bst.toString();
    }

    public boolean containsPokemon(int number) {
        return bst.search(number);
    }

    public static void main(String[] args) {
        Pokedex pokedex = new Pokedex();
        pokedex.addPokemon(39);
        pokedex.addPokemon(4);
        pokedex.addPokemon(147);
        pokedex.addPokemon(75);
        pokedex.addPokemon(129);
        pokedex.addPokemon(8);
        pokedex.addPokemon(146);
        pokedex.addPokemon(20);
        pokedex.addPokemon(26);
        pokedex.addPokemon(36);
        pokedex.addPokemon(132);
        pokedex.addPokemon(93);
        pokedex.addPokemon(1);
        pokedex.addPokemon(145);
        pokedex.addPokemon(174);

        System.out.println(pokedex.toString());

        System.out.println(pokedex.containsPokemon(129));
        System.out.println(pokedex.containsPokemon(39));
        System.out.println(pokedex.containsPokemon(429));


        pokedex.addPokemon(672);
        System.out.println(pokedex);
    }
}
