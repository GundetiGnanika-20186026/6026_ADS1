import java.util.Comparator;
/**
 * Class for minimum pq.
 *
 * @param      <Key>  The key
 */
public class MinPQ<Key> {
    /**
     * store items at indices 1 to n.
     */
    private Key[] pq;
    /**
     * number of items on priority queue.
     */
    private int n;
    /**
     * optional comparator.
     */

    private Comparator<Key> comparator;

    /**
     * Constructs the object.
     *
     * @param      initCapacity  The initialize capacity
     */
    public MinPQ(final int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Constructs the object.
     */
    public MinPQ() {
        this(1);
    }

    /**
     * Constructs the object.
     *
     * @param      initCapacity  The initialize capacity
     * @param      comparator    The comparator
     */
    public MinPQ(final int initCapacity, final Comparator<Key> comparator) {
        this.comparator = comparator;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Determines if empty.
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return n == 0;
    }



    /**
     * will resize with the given capacity.
     *
     * @param      capacity  The capacity
     */

    private void resize(final int capacity) {
        assert capacity > n;
        Key[] temp = (Key[]) new Object[capacity];
        for (int i = 1; i <= n; i++) {
            temp[i] = pq[i];
        }
        pq = temp;
    }

    /**
     * this method will insert the object.
     *
     * @param      x     { object to be inserted }
     */

    public void insert(final Key x) {

        if (n == pq.length - 1) {
            resize(2 * pq.length);
        }


        pq[++n] = x;
        swim(n);

    }

    /**
     * this will delete the minimum key.
     *
     * @return     { the key that is deleted }
     */

    public Key delMin() {

        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        if ((n > 0) && (n == (pq.length - 1) / 4)) {
            resize(pq.length / 2);
        }
        //assert isMinHeap();
        return min;
    }


    /**
     * it will compare the parent and child.
     *
     * @param      k     { index }
     */

    private void swim(int k) {
        while (k > 1 && greater(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    /**
     * { this will compare the parent and child and exchange if required }.
     *
     * @param      k     { index }
     */
    public void sink(int k) {
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && greater(j, j + 1)) {
                j++;
            }
            if (!greater(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }

    /**
     * checks wether the element
     *  at index i is greater than the other.
     *
     * @param      i     { index1 }
     * @param      j     { index2 }
     *
     * @return     { true if greater,false if less }
     */

    private boolean greater(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }

    /**
     * exchanges the value at index i and index j.
     *
     * @param      i     { index1 }
     * @param      j     { index2 }
     */

    private void exch(final int i, final int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }


}






