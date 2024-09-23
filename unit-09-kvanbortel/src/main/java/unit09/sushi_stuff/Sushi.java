package unit09.sushi_stuff;

import java.util.Random;

public class Sushi implements Comparable<Sushi> {
    private Integer number;
    private int weight;
    private int cost;

    public Sushi(int number) {
        //** Gives each sushi a random weight and cost */
        Random random = new Random();
        this.number = number;
        weight = random.nextInt(80) + 20;
        cost = random.nextInt(30) + 10;
    }

    public int getCost() {
        return cost;
    }

    public Integer getNumber() {
        return number;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Sushi{number= " + number + ", weight= " + weight + " grams, $" + cost + "}";
    }

    @Override
    public int compareTo(Sushi o) {
        return weight - o.weight;
    }
}
