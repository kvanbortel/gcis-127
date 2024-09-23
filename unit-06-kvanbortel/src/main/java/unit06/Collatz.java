/** Author: Kayla Van Bortel */

package unit06;

import java.util.Scanner;

public class Collatz {
    public static String sequence(int n) {
        /** Returns the Collatz Sequence beginning with n and ending with 1 */
        if (n < 1) {
            return "";
        }
        String sequence = "" + n;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
                sequence += " " + n;
            }
            else {
                n = 3 * n + 1;
                sequence += " " + n;
            }
        }
        return sequence;
    }

    public static void main(String[] args) {
        // System.out.println(sequence(5));
        // System.out.println(sequence(10));
        // System.out.println(sequence(17));
        // System.out.println(sequence(-1));

        Scanner scanner = new Scanner(System.in);
        int num = 1;
        while (num > 0) {
            System.out.print("Enter a number: ");
            num = scanner.nextInt();
            if (num > 0) {
                System.out.println(sequence(num));
            }
            else {
                scanner.close();
            }
        }
    }
}
