/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: LinkedBag.java
 * Author: Frank M. Carrano
 * Author: Timothy M. Henry
 * Author: Duc Ta
 * Author: Bryan Khor
 * **********************************************
 */

package assignment03PartA;

import java.util.ArrayList;

public final class LinkedBag<T> implements PrimaryDataStructureBagInterface<T> {

    private Node firstNode; // Reference to first node
    private int numberOfEntries; // Number of items in the bag

    public LinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }

    // Gets the current number of entries in this bag.
    // @return the integer number of entries currently in the bag.
    @Override
    public int getCurrentSize() {
        return numberOfEntries;
    }

    // Sees whether this bag is empty.
    // @return true if the bag is empty, or false if not.
    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    // Adds a new entry to this bag.
    // @param newEntry The object to be added as a new entry.
    // @return true if the addition is successful, or false if not.
    @Override
    public boolean add(T newEntry) {
        // Add to beginning of chain:
        Node newNode = new Node(newEntry);
        newNode.next = firstNode; // Make new node reference rest of chain
        // (firstNode is null if chain is empty)
        firstNode = newNode; // New node is at beginning of chain
        numberOfEntries++;
        return true;
    }

    @Override
    public boolean findTheThird(T entry) {
        int count = 1;
        boolean result = false;
        Node currentNode = firstNode;

        for (int i = 0; i < numberOfEntries; i++) {
            if (count != 2 && currentNode.data.equals(entry)) {
                if (count == 3) {
                    currentNode.data = (T) "Found3rd";
                } else {
                    remove(currentNode.data);
                }
                count++;
            }
            currentNode = currentNode.next;
        }

        if (count >= 3) {
            result = true;
        }

        return result;
    }

    // Removes all occurrences of the entries in the bag
    @Override
    public boolean removeAllOccurrences(T[][] entries) {
        boolean result = false;
        Node currentNode = firstNode;

        String[] array1D = new String[20];
        int index = 0;

        // Copy the entries into a 1D array
        for (int row = 0; row < entries.length; row++) {
            for (int col = 0; col < entries[row].length; col++) {
                array1D[index] = (String) entries[row][col];
                index++;
            }
        }

        ArrayList<String> temp = new ArrayList<>();

        // Remove duplicates from the 1D array
        for (int i = 0; i < array1D.length; i++) {
            if (!temp.contains(array1D[i])) {
                temp.add(array1D[i]);
            }
        }

        // Iterates through the array and remove the node that equals to one of the elements in the array
        while (currentNode != null) {
            for (int i = 0; i < temp.size(); i++) {
                if (currentNode.data.equals(temp.get(i))) {
                    remove(currentNode.data);
                }
            }
            currentNode = currentNode.next;
            result = true;
        }

        return result;
    }

    // Removes one occurrence of a given entry from this bag, if possible.
    // @param anEntry The entry to be removed.
    // @return True if the removal was successful, or false if not.
    public boolean remove(T anEntry) {
        boolean result = false;
        Node nodeN = getReferenceTo(anEntry);
        if (nodeN != null) {
            nodeN.data = firstNode.data; // Replace located entry with entry in first node
            firstNode = firstNode.next; // Remove first node
            numberOfEntries--;
            result = true;
        } // end if
        return result;
    }

    // Retrieves all entries that are in this bag.
    // @return A newly allocated array of all the entries in the bag. Note: If the
    // bag is empty, the returned array is empty.
    @Override
    public T[] toArray() {
        // The cast is safe because the new array contains null entries
        @SuppressWarnings("unchecked")
        T[] result = (T[]) new Object[numberOfEntries]; // Unchecked cast
        int index = 0;
        Node currentNode = firstNode;
        while ((index < numberOfEntries) && (currentNode != null)) {
            result[index] = currentNode.data;
            index++;
            currentNode = currentNode.next;
        } // end while
        return result;
    }

    private class Node {
        private T data;
        private Node next;

        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }
    }

    // Locates a given entry within this bag.
    // Returns a reference to the node containing the entry, if located,
    // or null otherwise.
    private Node getReferenceTo(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;
        while (!found && (currentNode != null)) {
            if (anEntry.equals(currentNode.data))
                found = true;
            else
                currentNode = currentNode.next;
        } // end while
        return currentNode;
    } // end getReferenceTo
}
