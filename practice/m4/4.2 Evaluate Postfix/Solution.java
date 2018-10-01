/**
 * Author:Gnanika.
 */
import java.util.Scanner;
//import java.util.Arrays;

/**
 * Class for linkedlist.
 */
class Linkedlist {
    /**
     * { head pointer }.
     */
    private Node head = null;
    /**
     * { variable to keep track of size }.
     */
    private int size = 0;
    /**
     * Class for node.
     */
    private class Node {
        /**
         * { data in a node}.
         */
        private int data;
        /**
         * { address that points next node }.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      data1  The data 1
         */
        Node(final int data1) {
            data = data1;
            next = null;
        }
    }

    /**
     * { push the node in to linked list at start}.
     *
     * @param      data1  The data 1
     */
    public void push(final int data1) {
        Node newnode = new Node(data1);
        if (size == 0) {
            head = newnode;
            size++;
            return;

        }
        newnode.next = head;
        head = newnode;
        size++;

    }

    /**
     * { pop from the beginning }.
     *
     * @return     { description_of_the_return_value }
     */
    public int pop() {
        int value = head.data;
        head = head.next;
        size--;
        return value;


    }

    /**
     * print method to print the result;
     */
    public void print() {
        System.out.println(head.data);
    }
}


/**
 * main class that contains main method.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { main method }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Linkedlist obj = new Linkedlist();
        Scanner scan = new Scanner(System.in);
        String[] array = scan.nextLine().split(" ");
        //System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            // if(!array[i].equals("+")||!array[i].equals("*")){


            if (array[i].equals("+")) {
                int value1 = obj.pop();
                int value2 = obj.pop();
                int result = value1 + value2;
                obj.push(result);

            } else if (array[i].equals("*")) {
                int value1 = obj.pop();
                int value2 = obj.pop();
                int result = value1 * value2;
                obj.push(result);
            } else {
                obj.push(Integer.parseInt(array[i]));
            }


        }
        obj.print();
    }
}
