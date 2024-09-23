/* This program simulates ordering and eating sushi using different data structures.
 * Author: Kayla Van Bortel */

package unit09.sushi_stuff;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Shop {
    public static void main(String[] args) {
        DisplayCase aCase = new DisplayCase();
        System.out.println("Welcome to Shinji's Sushi Shop!");
        Set<Integer> orderedItems = new TreeSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("The cashier takes your order (enter '-1' to end input): ");
        //** Lets you order 3 to 8 sushi */
        for (int i = 0; i < 8; i++) {
            Integer item = scanner.nextInt();
            if (i < 3) {
                orderedItems.add(item);
                aCase.remove(item);
                continue;
            }
            else if (item == -1) {
                break;
            }
            orderedItems.add(item);
            aCase.remove(item);
        }
        scanner.close();
        // System.out.println(aCase.toString());
        Order order = new Order(orderedItems);
        System.out.println("The cashier prepares your order.");
        System.out.println("That will be $" + order.getCost());
        System.out.println("Here is your order, please come again.");
        System.out.println("Back at your apartment, you take out your sushi and eat it ...");
        for (Sushi item: order.getBag()) {
            System.out.println("Eating " + item.toString() + "... yum!");
        }

    }
}
