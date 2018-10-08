import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;


class MinPQ<Key> {
    private  Key[] pq;
    private  int n;
    Comparator<Key> comparator;
    MinPQ(Key[] array, int size) {
        pq = array;
        n = size;
   }



    boolean isMinHeap() {
        return isMinHeap(1);
    }

    // is subtree of pq[1..n] rooted at k a min heap?
    private boolean isMinHeap(int k) {
        if (k > n) return true;
        int left = 2*k;
        int right = 2*k + 1;
        if (left  <= n && greater(k, left))  return false;
        if (right <= n && greater(k, right)) return false;
        return isMinHeap(left) && isMinHeap(right);
    }

     private boolean greater(int i, int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        }
        else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }






}


class Solution {
    Solution() {

    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String type = scan.nextLine();
        switch(type){
            case "String":

                int testcase = Integer.parseInt(scan.nextLine());
                for(int i = 0; i< testcase; i++){
                    String[] input = scan.nextLine().split(",");
                    MinPQ<String> obj = new MinPQ<String>(input,input.length);
                   System.out.println(obj.isMinHeap());
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
                    MinPQ<Integer> obj = new MinPQ<Integer>(input1,input.length);
                   System.out.println(obj.isMinHeap());

                }

            break;
        }
    }





}
