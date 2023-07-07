/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: LinkedBagCSC220JavaDriver
 * Author: Frank M. Carrano
 * Author: Timothy M. Henry
 * Author: Duc Ta
 * Author: Bryan Khor
 * **********************************************
 */

// Do not change this file
package assignment03PartA;

import java.util.ArrayList;
import java.util.Arrays;

public class LinkedBagCSC220JavaDriver {

    public static void main(String[] args) {
        System.out.println("=== LINKED BAG 220 JAVA ==========================================================");
        System.out.println("[+] Creating a CSC220 LinkedBag...");
        PrimaryDataStructureBagInterface<String> csc220Bag = new LinkedBag<>();
        PrimaryDataStructureBagInterface<String> csc220Bag2 = new LinkedBag<>();
        testAdd(csc220Bag);
        testRemoveAllOccurrences(csc220Bag);
        System.out.println("=== LINKED BAG 220 JAVA ==========================================================");
    }

    private static void displayBag(PrimaryDataStructureBagInterface<String> aBag) {
        System.out.print("[>] The bag now contains " + aBag.getCurrentSize() + " string(s): \t");
        Object[] bagArray = aBag.toArray();
        for (Object bagArray1 : bagArray) {
            System.out.print(bagArray1 + " ");
        }
        System.out.println();
    }

    private static void testRemoveAllOccurrences(PrimaryDataStructureBagInterface<String> aBag) {
        // Removing all occurrences of the given entries from a bag
        System.out.println("[+] Creating... a 2D test array with the below contents: \t");
        String[][] testArray = {
                {"A", "A", "A", "A", "A", "A"},
                {"B", "A", "Bb", "B", "Bb", "B"},
                {"C", "B", "_", "A"},
                {"n", "u", "l", "l"}
        };
        for (String[] row : testArray) {
            System.out.print("\t\t\t\t\t");
            for (String col : row) {
                System.out.print(col + " ");
            }
            System.out.println("");
        }

        System.out.println("[+] Removing 2D test array items from the bag...");
        System.out.println(" [-] Converting 2D array to 1D...");
        String[] array1D = new String[20];
        int index = 0;

        // Converting 2D array to a 1D array
        for (int row = 0; row < testArray.length; row++) {
            for (int col = 0; col < testArray[row].length; col++) {
                array1D[index] = testArray[row][col];
                index++;
            }
        }

        System.out.println(" [-] Removing duplicates in 1D array...");
        System.out.print(" [>] The final 1D array now contains:   ");

        ArrayList<String> temp = new ArrayList<>();

        // Removing duplicates in 1D array
        for (int i = 0; i < array1D.length; i++) {
            if (!temp.contains(array1D[i])) {
                temp.add(array1D[i]);
            }
        }

        // Display the final 1D array
        for (int i = 0; i < temp.size(); i++) {
            System.out.print(temp.get(i) + " ");
        }
        System.out.println("\n [-] Removing the final 1D array items from the bag...");

        aBag.removeAllOccurrences(testArray);
        displayBag(aBag);
    }

    private static void testAdd(PrimaryDataStructureBagInterface<String> aBag) {
        // Adding strings
        String[] contentsOfBag = {
                "A", "_", "_", "G", "Bb", "A", "_", "u", "n",
                "o", "A", "o", "d", "Bb", "A", "A", "l", "l"
        };
        System.out.print("[+] Adding.... these items to the bag: \t");
        for (String entry : contentsOfBag) {
            aBag.add(entry);
            System.out.print(entry + " ");
        }
        System.out.println();

        displayBag(aBag);
    }
}
