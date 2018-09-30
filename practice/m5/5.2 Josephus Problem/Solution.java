/**
 * Author:Gnanika.
 */
import java.util.Scanner;
/**
 * queue class.
 */
class Queue {
    /**
     * head pointer.
     */
    private Node head;
    /**
     * tail pointer.
     */
    private Node tail;
    //public int size;

    /**
     * Class for creating node.
     */
    private class Node {
        /**
         * for storing the data.
         */
        private int value;
        /**
         * for storing the address of next node.
         */
        private Node next;
    }

    /**
     * Constructor for queue.
     */
    Queue() {
        head = null;
        tail = null;
    }

    /**
     * method for pushing into queue from right.
     *
     * @param      value  The value
     */

    public void enqueue(final int value) {
        if (tail == null) {
            tail = new Node();
            tail.value = value;
            tail.next = null;

            head = tail;

        } else {
            Node oldTail = tail;
            tail = new Node();
            tail.value = value;
            tail.next = null;
            oldTail.next = tail;

        }

    }

    /**
     * method for popping from the queue from left most place.
     *
     * @return     { description_of_the_return_value }
     */
    public int dequeue() {
        if (head != null) {
            int value = head.value;
            head = head.next;
            //size--;
            return value;
        }
        return tail.value;
    }

    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }
    // public int size() {
    //     return size;
    // }
}


/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructor for solution.
     */
    private Solution() {

    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < number; i++) {
            String[] token = scan.nextLine().split(" ");
            int totalpeople = Integer.parseInt(token[0]);
            int shift = Integer.parseInt(token[1]);
            Queue q = new Queue();
            String str = "";
            for (int j = 0; j < totalpeople; j++) {
                q.enqueue(j);
            }

            while (!q.isEmpty()) {
                for (int k = 0; k < shift - 1; k++) {
                    q.enqueue(q.dequeue());
                }
                str += q.dequeue() + " ";
            }
            System.out.println(str.substring(0, str.length() - 1));
            //System.out.println();
        }


    }

}
