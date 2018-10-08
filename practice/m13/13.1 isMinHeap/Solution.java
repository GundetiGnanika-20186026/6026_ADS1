import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;


class MinPQ<Key extends Comparable<Key>> {
    // private  Key[] pq;
    // private  int n;
    // Comparator<Key> comparator;
    MinPQ() {

   }



    // boolean isMinHeap() {
    //     return isMinHeap(1);
    // }

    // // is subtree of pq[1..n] rooted at k a min heap?
    // private boolean isMinHeap(int k) {
    //     if (k > n) return true;
    //     int left = 2*k;
    //     int right = 2*k + 1;
    //     if (left  <= n && greater(k, left))  return false;
    //     if (right <= n && greater(k, right)) return false;
    //     return isMinHeap(left) && isMinHeap(right);
    // }

    //  private boolean greater(int i, int j) {
    //     if (comparator == null) {
    //         return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
    //     }
    //     else {
    //         return comparator.compare(pq[i], pq[j]) > 0;
    //     }
    // }
    public boolean minHeapchecking(Key[] array) {
        int n = array.length-1;
        while(n>1) {
            if(array[n].compareTo(array[n/2]) >= 0) {
                n = -1;
            }
            else {
                return false;
            }
        }
        return true;
    }

}

/**
 * Class for solution.
 */
class Solution {
    /**
     * Constructs the object.
     */
    Solution() {

    }
    /**
     * { main method }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        switch(type){
            case "String":

                int testcase = Integer.parseInt(scan.nextLine());
                for(int i = 0; i< testcase; i++){
                    String[] input = scan.nextLine().split(",");
                    MinPQ<String> obj = new MinPQ<String>();
                   System.out.println(obj.minHeapchecking(input));
                }

            break;
            case "Integer" :

                int testcase1 = Integer.parseInt(scan.nextLine());
                for(int i = 0; i< testcase1; i++){
                    String[] input = scan.nextLine().split(",");
                    Integer[] input1 = new Integer[input.length];
                    for(int j = 0;j<input.length;j++){
                        input1[j] = Integer.parseInt(input[j]);

                    }
                    MinPQ<Integer> obj = new MinPQ<Integer>();
                   System.out.println(obj.minHeapchecking(input1));

                }

            break;
        }
    }





}
