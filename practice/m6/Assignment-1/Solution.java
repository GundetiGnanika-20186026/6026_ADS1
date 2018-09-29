import java.util.Scanner;
import java.util.LinkedList;

// class LinkedList {
//     Node head;
//     int size = 0;
//     class Node {
//         int data;
//         Node next;
//         Node(int data) {
//             this.data = data;
//             this.next = null;
//         }
//     }

//     public  void addtoLinkedList(int data1) {
//         Node last = new Node(data1);
//         if (size == 0) {
//             head = last;
//             size++;
//             return;
//         }
//         Node n = head;
//         int count = 0;
//         while (count < size-1) {
//             n.next = n;
//             count++;

//         }
//         n.next = last;
//         size++;
//        last.next = null;
//     }



// }



/**
 * Class for add large numbers.
 */
class AddLargeNumbers {



    // static LinkedList head;
    // static int length1 = 0;

    /**
     * { function_description }.
     *
     * @param      number  The number
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList numberToDigits(final String number) {
        LinkedList obj = new LinkedList();
        String[] stringarray = number.split("");
        for (int i = 0; i < stringarray.length; i++) {
            obj.add(Integer.parseInt(stringarray[i]));
            //length1++;
        }
        return obj;

    }
    /**
     * { function_description }.
     *
     * @param      list  The list
     *
     * @return     { description_of_the_return_value }
     */

    public static String digitsToNumber(final LinkedList list) {
        String str = "";
        // // LinkedList n = head;
        // Node n = head;
        // int count = 0;
        // while(count < size-1){
        //     // str += n.data;
        //     n.next = n;
        //     count++;
        // }
        // for (int i = 0 ; i < (list.size) - 1; i++) {
        //     str += list.head.data;
        //     list.head.next = list.head;

        // }
        // ////////////////////////////////
        for (int i = 0; i < list.size(); i++) {
            str += list.get(i);
        }
        ////////////////////////////////////
        return str;

    }

    /**
     * Adds large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     { description_of_the_return_value }
     */

    public static LinkedList addLargeNumbers(final LinkedList list1,
     final LinkedList list2) {
        LinkedList obj3 = new LinkedList();
        // for (int i = 0, j = 0; i < list1.size(); i++, j++) {
        //     //int k =list1.get(i);
        //     //int m= list2.get(j);
        //     //obj3.add(k+m);
        // }

        return null;

    }
}

/**
 * { solution class }.
 */

final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits, qDigits);
            System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        default:
        }
    }

}
