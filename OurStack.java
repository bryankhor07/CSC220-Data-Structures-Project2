/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: OurStack.java
 * Author: Frank M. Carrano
 * Author: Timothy M. Henry
 * Author: Duc Ta
 * Author: Bryan Khor
 * **********************************************
 */

package assignment03PartB;

import java.util.EmptyStackException;

public class OurStack<T> implements StackInterface<T> {

    // Instance data field
    private Node topNode; // References the first node in the chain

    // Default constructor
    public OurStack() {
        topNode = null;
    }

    // Inserts an item at the top of the stack
    @Override
    public void push(T newEntry) {
        topNode = new Node(newEntry, topNode);

    }

    // Returns the object at the top of the stack without removing it from the stack or modifying the stack in any way.
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        } else {
            return topNode.getData();
        }
    }

    // Removes the object at the top of the stack and returns that object from the function.
    // The stack size will be decremented by one.
    @Override
    public T pop() {
        T top = peek(); // Might throw EmptyStackException
        assert (topNode != null);
        topNode = topNode.getNextNode();

        return top;
    }

    // Tests if the stack is empty or not.
    @Override
    public boolean isEmpty() {
        return topNode == null;
    }

    // Clears the entire stack
    @Override
    public void clear() {
        topNode = null; // Causes deallocation of nodes in the chain
    }

    private class Node {
        private T data; // Entry in bag
        private Node next; // Link to next node

        private Node(T dataPortion) {
            this(dataPortion, null);
        } // end constructor

        private Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        } // end constructor

        private T getData() {
            return data;
        }

        private void setData(T data) {
            this.data = data;
        }

        private Node getNextNode() {
            return next;
        }

        private void setNextNode(Node next) {
            this.next = next;
        }
    }
}
