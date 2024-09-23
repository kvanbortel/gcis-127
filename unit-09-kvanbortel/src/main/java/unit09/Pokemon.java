package unit09;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Pokemon implements Comparable<Pokemon> {
    private final int number;
    private final String name;

    public Pokemon(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number + ": " + name;
    }

    @Override
    public int compareTo(Pokemon other) {
        return this.number - other.number;
    }

    public static void main(String[] args) {
        List<Pokemon> pokedex = new LinkedList<>();
        pokedex.add(new Pokemon("Magikarp", 129));
        pokedex.add(new Pokemon("Eevee", 133));
        pokedex.add(new Pokemon("Turtwig", 387));
        pokedex.add(new Pokemon("Diglet", 50));
        // Collections.sort(pokedex);
        Collections.sort(pokedex, new PokemonComparator());
        System.out.println(pokedex);
    }
}
