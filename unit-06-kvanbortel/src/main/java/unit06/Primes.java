/** Author: Kayla Van Bortel */

package unit06;

import java.util.Scanner;

public class Primes {
    public static boolean isPrime(int n) {
        /** Uses a more efficient brute force approach to check if a number is prime */
        if (n <= 1) {
            return false;
        }
        for(int i = 2; i <= ((n + 1) / 2); i ++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // for(int i = 1; i <= 100; i++) {
        //     System.out.println(i + " is prime is " + isPrime(i));
        // }
        
        Scanner scanner = new Scanner(System.in);
        int num = 1;
        while (num > 0) {
            System.out.print("Enter a number: ");
            num = scanner.nextInt();
            if (num > 0) {
                System.out.println(num + " is prime is " + isPrime(num));
            }
            else {
                scanner.close();;
            }
        }
    }
    }
