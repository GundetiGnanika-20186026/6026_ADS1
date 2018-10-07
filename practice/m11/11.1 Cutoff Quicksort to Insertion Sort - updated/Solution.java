import java.util.Scanner;

class InsertionSort {
    boolean less(Comparable u, Comparable v) {
        return u.compareTo(v) < 0;
    }
    void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    void sort(Comparable[] array, int low, int high) {
        System.out.println("insertionSort called");
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(array[j], array[j - 1]); j--) {
                exch(array, j, j - 1);
            }
        }
    }
}



class QuickSort {



    public void sort(Comparable[] array, int start, int end, int cutoff) {
        int length = end - start;
        if ( length < cutoff) {
            InsertionSort insertionObj = new InsertionSort();
            insertionObj.sort(array, start, end);
            return;
        }
        int pivot = partition(array, start, end);
        sort(array, start, pivot - 1, cutoff);
        sort(array, pivot + 1, end, cutoff);
    }




    public int partition(Comparable[] a, int start, int end) {

        int i = start;
        int j = end + 1;
        Comparable v = a[start];

        // Comparable pivot = array[start];
        // int i = start;
        // int j = end;
        // while (true) {
        //     while (j >= start && array[j].compareTo(pivot) > 0) {
        //         j--;
        //     }
        //     while (i <= end && array[i].compareTo(pivot) <= 0) {
        //         i++;
        //     }
        //     if (j < i) {
        //         i--;
        //         break;
        //     }
        //     exchange(array, i, j);
        //     i++;
        //     j--;
        // }
        // array[start] = array[i];
        // array[i] = pivot;
        // System.out.println(toString(array));
        // return i;
        //
         while (true) {

            // find item on lo to swap
            while (less(a[++i], v)) {
                if (i == end) break;
            }

            // find item on hi to swap
            while (less(v, a[--j])) {
                if (j == start) break;      // redundant since a[lo] acts as sentinel
            }

            // check if pointers cross
            if (i >= j) break;

            exchange(a, i, j);
        }

        // put partitioning item v at a[j]
        exchange(a, start, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }





    void exchange(Comparable[] array, int v1 , int v2) {
        Comparable temp = array[v1];
        array[v1] = array[v2];
        array[v2] = temp;
    }


     private static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;   // optimization when reference equals
        return v.compareTo(w) < 0;
    }

    public String toString(Comparable[] array) {
        String s = "[";
        int i;
        for (i = 0; i < array.length - 1; i++) {
            s += array[i] + ", ";
        }
        s = s + array[array.length - 1] + "]";
        return s;
    }
}
class Solution {
    public static void main(String[] args) {
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
