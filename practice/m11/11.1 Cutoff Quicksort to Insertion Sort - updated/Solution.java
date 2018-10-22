/**
 * Author: Gnanika.
 */
import java.util.Scanner;
/**
 * Class for insertion sort.
 */
class InsertionSort {
    /**
     * Constructs the object.
     */
    InsertionSort() {

    }
    /**
     * { checks if first element is less than the second }.
     * its complexity is O(1).
     *
     * @param      u     { value1 }
     * @param      v     { value2 }
     *
     * @return     { true if less and false ig more }
     */
    public boolean less(final Comparable u, final Comparable v) {
        return u.compareTo(v) < 0;
    }

    /**
     * { exchanges the values in both the indexes }.
     * its complexity is O(1).
     *
     * @param      a     { array }
     * @param      i     { index }
     * @param      j     { index }
     */
    public void exch(final Comparable[] a, final int i, final int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /**
     * { method for sorting the array}.
     * its Complexity is O(n^2) as it has nested for loop.
     *
     * @param      array  The array
     * @param      low    The lowindex
     * @param      high   The highindex
     */
    public void sort(final Comparable[] array, final int low, final int high) {
        System.out.println("insertionSort called");
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(array[j],
             array[j - 1]); j--) {
                exch(array, j, j - 1);
            }
        }
    }
}


/**
 * Class for quick sort.
 */
class QuickSort {
    /**
     * Constructs the object.
     */
    QuickSort() {

    }

    /**
     * { This method is for sorting }.
     * its complexity is N*log(N)
     *
     * @param      array   The array
     * @param      start   The start
     * @param      end     The end
     * @param      cutoff  The cutoff
     */
    public void sort(final Comparable[] array, final int start,
     final int end, final int cutoff) {
        int length = end - start;
        if (length < cutoff) {
            InsertionSort insertionObj = new InsertionSort();
            insertionObj.sort(array, start, end);
            return;
        }
        int pivot = partition(array, start, end);
        sort(array, start, pivot - 1, cutoff);
        sort(array, pivot + 1, end, cutoff);
    }



    /**
     * this method is to find the partition element.
     * its complexity is O(N)
     *
     * @param      array  The array
     * @param      start  The start
     * @param      end    The end
     *
     * @return     { integer which is the
     *              index of partition element }
     */
    public int partition(final Comparable[] array,
     final int start, final int end) {

        // int i = start;
        // int j = end ;
        //Comparable v = a[start];

        Comparable pivot = array[start];
        int i = start;
        int j = end;
        while (true) {
    while (j >= start && array[j].compareTo(pivot) > 0) {
                j--;
            }
    while (i <= end && array[i].compareTo(pivot) <= 0) {
                i++;
            }
            if (j < i) {
                i--;
                break;
            }
            exchange(array, i, j);
            i++;
            j--;
        }
        array[start] = array[i];
        array[i] = pivot;
        System.out.println(toString(array));
        return i;


    }




    /**
     * exchanges the values present at the given indexes.
     * its complexity is O(1).
     *
     * @param      array  The array
     * @param      v1     index1
     * @param      v2     index2
     */
    public void exchange(final Comparable[] array,
     final int v1, final int v2) {
        Comparable temp = array[v1];
        array[v1] = array[v2];
        array[v2] = temp;
    }

    /**
     * checks wether the first element
     *  is less than the other.
     * its complexity is O(1).
     *
     * @param      v     { value1 }
     * @param      w     { value2 }
     *
     * @return     { true if less and false if greater }
     */
    private  boolean less(final Comparable v, final Comparable w) {
        if (v == w) {
            return false;
        }
        return v.compareTo(w) < 0;
    }

    /**
     * Returns a string representation of the object.
     * its complexity is O(n).
     *
     * @param      array  The array
     *
     * @return     String representation of the object.
     */
    public String toString(final Comparable[] array) {
        String s = "[";
        int i;
        for (i = 0; i < array.length - 1; i++) {
            s += array[i] + ", ";
        }
        s = s + array[array.length - 1] + "]";
        return s;
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
     * { main method to read input from console }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int testcases = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < testcases; i++) {
            QuickSort qs = new QuickSort();
            int cut = Integer.parseInt(scan.nextLine());
            String token = scan.nextLine();

            if (token.equals("")) {
                System.out.println("[]");
            } else {
                Comparable[] array = token.split(" ");
                qs.sort(array, 0, array.length - 1, cut);
                System.out.println(qs.toString(array));
            }
        }
    }
}
