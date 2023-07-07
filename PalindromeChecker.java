/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: PalindromeChecker.java
 * Author: Frank M. Carrano
 * Author: Timothy M. Henry
 * Author: Duc Ta
 * Author: Bryan Khor
 * **********************************************
 */

package assignment03PartB;

import java.util.Scanner;

//
// - Do not change the "main" method.
// - Please ADD CODE to complete implementing the program
//
public class PalindromeChecker {

    private static boolean isPalindrome(String string) {
        boolean result = false;
        string = string.toLowerCase().replaceAll("\\s", "").replaceAll("\\p{Punct}", "");

        OurStack<String> ourStack = new OurStack<>();

        // Add the values of the string into ourStack
        for (int i = 0; i < string.length(); i++) {
            ourStack.push(String.valueOf(string.charAt(i)));
        }

        StringBuilder reverse = new StringBuilder();

        // Pop the values into another string
        while (!ourStack.isEmpty()) {
            reverse.append(ourStack.pop());
        }

        // Compare if the original string and the reversed string is equal
        if (string.equals(reverse.toString())) {
            result = true;
        }
        return result;
    }

    //
    // - Do not change the "main" method.
    // - Please ADD CODE to complete implementing the program
    //
    public static void main(String[] args) {
        //
        // - Do not change the "main" method.
        // - Please ADD CODE to complete implementing the program
        //
        Scanner input = new Scanner(System.in);
        System.out.print("[>>] Enter a string (or a ! to exit): ");
        String string = input.nextLine();

        while (!string.equals("!")) {
            if (isPalindrome(string)) {
                System.out.println(" [+] Yes. \"" + string + "\" IS a palindrome!");
            } else {
                System.out.println(" [-] No. \"" + string + "\" is NOT a palindrome!");
            }
            System.out.print("[>>] Enter a string: ");
            string = input.nextLine();
        }

        System.out.println("[<<] Thank you!");
        //
        // - Do not change the "main" method.
        // - Please ADD CODE to complete implementing the program
        //
    }
}
