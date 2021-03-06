import java.util.Scanner;
/**
 * minimum priority queue class.
 *
 * @param      <Key>  The key(
 *                    which acts as generic)
 */

class MinPQ<Key extends Comparable<Key>> {
    // private  Key[] pq;
    // private  int n;
    // Comparator<Key> comparator;

    /**
     * Constructs the object.
     */
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

    /**
     * { this method will check whether the elements
     *  in the given input array are in minimum  }
     *  its complexity is O(n).
     *
     * @param      array  The array from the input.
     *
     * @return     { true if elements are following
     *  minimum priority and false if not  }
     */
    public boolean minHeapchecking(final Key[] array) {
        int n = array.length - 1;
        // if (array.length == 0) {
        //     return false;
        // }
        while (n > 1) {

            if (array[n].compareTo(array[n / 2]) >= 0) {
                n = -1;
            } else {
                return false;
            }
        }
        return true;
    }

}

/**
 * Class for solution.
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
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        switch (type) {
        case "String":

            int testcase = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < testcase; i++) {
                String[] input = scan.nextLine().split(",");
                MinPQ<String> obj = new MinPQ<String>();
                System.out.println(obj.minHeapchecking(input));
            }

            break;
        case "Integer" :

            int testcase1 = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < testcase1; i++) {
                String[] input = scan.nextLine().split(",");
                Integer[] input1 = new Integer[input.length];
                for (int j = 0; j < input.length; j++) {
                    input1[j] = Integer.parseInt(input[j]);

                }
                MinPQ<Integer> obj = new MinPQ<Integer>();
                System.out.println(obj.minHeapchecking(input1));

            }

            break;

        case "Double" :
            int testcase2 = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < testcase2; i++) {
                String[] input = scan.nextLine().split(",");
                Double[] input1 = new Double[input.length];
                for (int j = 0; j < input.length; j++) {
                    input1[j] = Double.parseDouble(input[j]);

                }
                MinPQ<Double> obj = new MinPQ<Double>();
                System.out.println(obj.minHeapchecking(input1));

            }

            break;
        case "Float" :

            int testcase3 = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < testcase3; i++) {
                String[] input = scan.nextLine().split(",");
                Float[] input1 = new Float[input.length];
                if (input[0].equals("")) {
                    System.out.println("false");
                    break;
                }
                for (int j = 0; j < input.length; j++) {
                    input1[j] = Float.parseFloat(input[j]);

                }
                MinPQ<Float> obj = new MinPQ<Float>();
                System.out.println(obj.minHeapchecking(input1));

            }
        break;
        default:

        }
    }





}
