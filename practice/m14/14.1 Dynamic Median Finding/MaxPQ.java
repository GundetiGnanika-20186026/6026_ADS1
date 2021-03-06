import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class for maximum pq.
 *
 * @param      <Key>  The key
 */
class MaxPQ<Key> {
    /**
     * pq array.
     */
    private Key[] pq;                    // store items at indices 1 to n
    /**
     * n.
     */
    private int n;                       // number of items on priority queue
    /**
     * Comparator.
     */
    private Comparator<Key> comparator;  // optional comparator

    /**
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param      initCapacity  The initialize capacity
     */
    MaxPQ(final int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue.
     */
    MaxPQ() {
        this(1);
    }

    /**
     * Initializes an empty priority queue with the given initial capacity,
     * using the given comparator.
     *
     * @param      initCapacity  The initialize capacity
     * @param      comparator1    The comparator
     */
    MaxPQ(final int initCapacity, final Comparator<Key> comparator1) {
        this.comparator = comparator1;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue using the given comparator.
     *
     * @param      comparator1  The comparator
     */
    MaxPQ(final Comparator<Key> comparator1) {
        this(1, comparator1);
    }

    /**
     * Initializes a priority queue from the array of keys.
     * Takes time proportional to the number of keys,
     * using sink-based heap construction.
     *
     * @param      keys  The keys
     */
    MaxPQ(final Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++) {
            pq[i + 1] = keys[i];
        }
        for (int k = n / 2; k >= 1; k--) {
            sink(k);
        }
        assert isMaxHeap();
    }

    /**
     * Returns true if this priority queue is empty.
     * Complexity :

     *              Worst Case : O(1)
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * Returns the number of keys on this priority queue.
     * Complexity :
     *              Worst Case : O(1)
     * @return     { size }
     */
    public int size() {
        return n;
    }

    /**
     * Returns a largest key on this priority queue.
     * Complexity :

     *              Worst Case : O(1)
     * @return     { key }
     */
    public Key max() {
        if (isEmpty()) {
            throw new NoSuchElementException(
                "Priority queue underflow");
        }
        return pq[1];
    }

    /**
     * helper function to double the size of the heap array.
     * Complexity :

     *              Worst Case : O(n)
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
     * Adds a new key to this priority queue.
     * Complexity :

     *              Worst Case : O(n)
     * @param      x     { key }
     */
    public void insert(final Key x) {


        if (n == pq.length - 1) {
            resize(2 * pq.length);
        }
        // add x, and percolate it up to maintain heap invariant
        pq[++n] = x;
        swim(n);
        assert isMaxHeap();
    }

    /**
     * Removes and returns a largest key on this priority queue.
     * Complexity :

     *              Worst Case : O(logn)
     * @return     { key }
     */
    public Key delMax() {
        final int four = 4;
        if (isEmpty()) {
            throw new NoSuchElementException(
                "Priority queue underflow");
        }
        Key max = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        if ((n > 0) && (n == (pq.length - 1) / four)) {
            resize(pq.length / 2);
        }
        assert isMaxHeap();
        return max;
    }



    /**
     * Swim Function.
     * Complexity :

     *              Worst Case : O(logn)
     * @param      k1     { value }
     */
    private void swim(final int k1) {
        int k = k1;
        while (k > 1 && less(k / 2, k)) {
            exch(k, k / 2);
            k = k / 2;
        }
    }

    /**
     * Sink Function.
     * Complexity :

     *              Worst Case : O(logn)
     * @param      k1     { value }
     */
    private void sink(final int k1) {
        int k = k1;
        while (2 * k <= n) {
            int j = 2 * k;
            if (j < n && less(j, j + 1)) {
                j++;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }
    }


    /**
     * Less Function.
     * Complexity :

     *              Worst Case : O(1)
     * @param      i     { index1 }
     * @param      j     { index2 }
     *
     * @return     true or false.
     */
    private boolean less(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) < 0;
        } else {
            return comparator.compare(pq[i], pq[j]) < 0;
        }
    }

    /**
     * Exchange Function.
     * Complexity :

     *              Worst Case : O(1)
     * @param      i     { index1 }
     * @param      j     { index2 }
     */
    private void exch(final int i, final int j) {
        Key swap = pq[i];
        pq[i] = pq[j];
        pq[j] = swap;
    }

    /**
     * Determines if maximum heap.
     * Complexity :

     *              Worst Case : O(1)
     * @return     True if maximum heap, False otherwise.
     */
    private boolean isMaxHeap() {
        return isMaxHeap(1);
    }

    /**
     * Determines if maximum heap.
     * Complexity :
     *
     *              Worst Case : O(1)
     * @param      k1     { value }
     *
     * @return     True if maximum heap, False otherwise.
     */
    private boolean isMaxHeap(final int k1) {
        int k = k1;
        if (k > n) {
            return true;
        }
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left  <= n && less(k, left)) {
            return false;
        }
        if (right <= n && less(k, right)) {
            return false;
        }
        return isMaxHeap(left) && isMaxHeap(right);
    }



}
