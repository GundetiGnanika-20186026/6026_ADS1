/**
 * Author:Gnanika.
 */
import java.util.Scanner;
/**
 * Class for deque.
 *
 * @param      <E>   { to take the required parameter }
 */
class Deque<E> {
    /**
     * { head pointer }.
     */
    private Node head;
    /**
     * { size variable }.
     */
    private int size = 0;
    /**
     * Class for Node.
     */
    class Node {
        /**
         * { data which we need to store }.
         */
        private E data;
        /**
         * { next pointer of type node }.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      data1  The data 1
         */
        Node(final E data1) {
            this.data = data1;
            next = null;
        }
    }

    /**
     * returns the size.
     *
     * @return     { returns the size }
     */
    public int getsize() {
        return size;
    }

    /**
     * checks wether queue is empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Adds element at front.
     *
     * @param      data  The data
     */
    public void addFront(final E data) {
        Node first = new Node(data);
        if (size == 0) {
            head = first;
            size++;
            return;
        }
        first.next = head;
        head = first;
        size++;
    }
    /**
     * Adds element at last.
     *
     * @param      data  The data
     */
    public void addLast(final E data) {
        if (size == 0) {
            addFront(data);
            return;
        }
        Node last = new Node(data);
        Node n = head;
        int count = 0;
        while (count < size - 1) {
            n = n.next;
            count++;
        }
        n.next = last;
        last.next = null;
        size++;
    }
    /**inserts at index ith position**/
    // public void addAfter(int i, E data) {
    //  Node middle = new Node(data);
    //  Node n = head;
    //  int count = 0;
    //  while(count < i-1) {
    //      count++;
    //      n = n.next;
    //  }
    //  // System.out.println(n.data);
    //  middle.next = n.next;
    //  n.next = middle;
    //  size++;
    // }

    /**
     * Removes element at first.
     *
     * @return     { if no elements return 0
     *               else return 1 }
     */
    public int removeFirst() {
        if (size == 0) {
            //System.out.println("Deck is empty");
            return 0;
        }
        head = head.next;
        size--;
        return 1;
    }

    /**
     * Removes element at last.
     *
     * @return     { if no elements return 0
     *               else return 1 }
     */
    public int removeLast() {
        if (size == 0) {
            //System.out.println("Deck is empty");
            return 0;
        }
        Node n = head;
        int count = 0;
        while (count < size - 2) {
            n = n.next;
            count++;
        }
        // System.out.println(n.data);
        n.next = null;
        size--;
        return 1;
    }

    // public void removeAfter(int i) {
    //  Node n = head;
    //  int count = 0;
    //  while(count < i-1) {
    //      count++;
    //      n = n.next;
    //  }
    //  n.next = n.next.next;
    //  size--;
    // }
    //

    /**
     * returns the required output in a specific way.
     *
     * @return     { string }
     */
    public String print() {
        if (size == 0) {
            return "[]";
        }
        Node n = head;
        String str = "";
        str += "[";
        // while(n != null) {
        //  str += n.data+",";
        //  //System.out.print(n.data+", ");
        //  n = n.next;
        // }
        // for(E i : o){
        // }
        for (int i = 0; i < size - 1; i++) {
            str += n.data + ", ";
            n = n.next;
        }
        return str + n.data + "]";
    }
}

/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * { main method }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Deque<String> obj = new Deque<String>();
        Scanner scan = new Scanner(System.in);
        int numberoflines = Integer.parseInt(scan.nextLine());
        while (scan.hasNext()) {
            String[] firsttoken = scan.nextLine().split(" ");
            switch (firsttoken[0]) {
            case "pushLeft":
                obj.addFront(firsttoken[1]);
                System.out.println(obj.print());

                break;
            case "pushRight":
                obj.addLast(firsttoken[1]);
                System.out.println(obj.print());
                break;
            case "popLeft" :
                int i = obj.removeFirst();
                if (i == 1) {
                    System.out.println(obj.print());
                } else {
                    System.out.println("Deck is empty");
                }
                break;
            case "popRight" :
                int j = obj.removeLast();
                if (j == 1) {
                    System.out.println(obj.print());
                } else {
                    System.out.println("Deck is empty");
                }
                break;
            case "size" :
                System.out.println(obj.getsize());

                break;
            case "isEmpty" :
                System.out.println(obj.isEmpty());

                break;
            default:
                break;
            }
        }
    }
}
