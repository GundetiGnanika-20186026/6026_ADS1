import java.util.*;
class Insertion {
    public Insertion() {}
    public static void sort(Object[] a, Comparator comparator,int size1) {
        int n = a.length;
        for (int i = 0; i < size1; i++) {
            for (int j = i; j > 0 && (!less(a[j], a[j - 1], comparator)); j--) {
                exch(a, j, j - 1);
            }

        }

    }
    private static  boolean less(Object v, Object w, Comparator comparator) {
        return comparator.compare(v, w) < 0;
    }
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }






}