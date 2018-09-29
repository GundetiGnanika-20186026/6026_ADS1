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




class AddLargeNumbers {

    // static LinkedList head;
    // static int length1 = 0;
    public static LinkedList numberToDigits(String number) {
        LinkedList obj = new LinkedList();
        String[] stringarray = number.split("");
        for (int i = 0; i < stringarray.length; i++) {
            obj.add(Integer.parseInt(stringarray[i]));
            //length1++;
        }
        return obj;

    }

    public static String digitsToNumber(LinkedList list) {
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
        for(int i = 0; i< list.size();i++){
            str += list.get(i);
        }
        ////////////////////////////////////
        return str;

    }

    public static LinkedList addLargeNumbers(LinkedList list1, LinkedList list2) {
        LinkedList obj3 = new LinkedList();
         for(int i = 0,j=0; i< list1.size();i++,j++){
            //int k =list1.get(i);
            //int m= list2.get(j);
            //obj3.add(k+m);
        }

        return null;

    }
}

public class Solution {
    public static void main(String[] args) {
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
        }
    }

}
