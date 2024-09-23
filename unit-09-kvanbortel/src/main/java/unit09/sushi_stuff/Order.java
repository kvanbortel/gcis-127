package unit09.sushi_stuff;

import java.util.Set;
import java.util.TreeSet;

public class Order {
    private TreeSet<Sushi> bag = new TreeSet<>();
    private Integer cost;

    public Order (Set<Integer> orderedItems) {
        //** Order contains bag and total cost */
        this.bag = bagItems(orderedItems);
        this.cost = getTotalCost(bag);
    }

    public static TreeSet<Sushi> bagItems(Set<Integer> orderedItems) {
        //** TreeSet bags items by order of decreasing weight */
        TreeSet<Sushi> bag = new TreeSet<>();
        for (int item: orderedItems) {
            bag.add(new Sushi(item));
        }
        return bag;
    }

    public static int getTotalCost(TreeSet<Sushi> bag) {
        //** Adds cost of each sushi in bag together */
        int cost = 0;
        for (Sushi item: bag) {
            cost += item.getCost();
        }
        return cost;
    }

    public Integer getCost() {
        return cost;
    }

    public TreeSet<Sushi> getBag() {
        return bag;
    }
}
