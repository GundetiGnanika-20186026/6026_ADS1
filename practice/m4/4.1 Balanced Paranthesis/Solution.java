/**
 * Author:Gnanika.
 */
import java.util.Scanner;
import java.util.Stack;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructor for solution class.
     */
    private Solution() {

    }
    /**
     * { main method }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner scan = new Scanner(System.in);
        int inputcount = Integer.parseInt(scan.nextLine());

        for (int j = 0; j < inputcount; j++) {
            //boolean flag = false;
            //Stack<String> mystack = new Stack<String>();
            String[] array = scan.nextLine().split("");
            Balancedparanthesis obj = new Balancedparanthesis();
            obj.balanced(array);
        //     for (int i = 0; i < array.length; i++) {
        //         if (array[i].equals("[") || array[i].equals("{")
        //          || array[i].equals("(")) {

        //             mystack.push(array[i]);

        //         } else {
        //             if (mystack.isEmpty()) {
        //                 System.out.println("NO");
        //                 flag = true;
        //                 break;
        //             }
        //             mystack.pop();

        //         }
        //     }

        //     if (!flag) {
        //         if (mystack.isEmpty()) {
        //             System.out.println("YES");
        //         } else {
        //             System.out.println("NO");
        //         }
        //     }


         }
    }

}


class Balancedparanthesis{
    Balancedparanthesis(){

    }
    public void balanced(String[] array) {
     // for (int j = 0; j < inputcount; j++) {
     //        boolean flag = false;
     //        Stack<String> mystack = new Stack<String>();
     //        String[] array = scan.nextLine().split("");
      Stack<String> mystack = new Stack<String>();
             boolean flag = false;
            for (int i = 0; i < array.length; i++) {
                if (array[i].equals("[") || array[i].equals("{")
                 || array[i].equals("(")) {

                    mystack.push(array[i]);

                } else {
                    if (mystack.isEmpty()) {
                        System.out.println("NO");
                        flag = true;
                        break;
                    }
                    mystack.pop();

                }
            }

            if (!flag) {
                if (mystack.isEmpty()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }


        }

    }

