import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Class for minimum pq.
 *
 * @param      <Key>  The key
 */
class MinPQ<Key> {//implements Iterable<Key> {
    /**
     * pq array.
     */
    private Key[] pq;
    /**
     * n.
     */
    private int n;
    /**
     * comparator.
     */
    private Comparator<Key> comparator;

    /**
     * Initializes an empty priority queue with the given initial capacity.
     *
     * @param      initCapacity  The initialize capacity
     */
    MinPQ(final int initCapacity) {
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue.
     */
    MinPQ() {
        this(1);
    }

    /**
     * Initializes an empty priority queue with the given initial capacity,
     * using the given comparator.
     *
     * @param      initCapacity  The initialize capacity
     * @param      comparator1    The comparator
     */
    MinPQ(final int initCapacity, final Comparator<Key> comparator1) {
        this.comparator = comparator1;
        pq = (Key[]) new Object[initCapacity + 1];
        n = 0;
    }

    /**
     * Initializes an empty priority queue using the given comparator.
     *
     * @param      comparator1  The comparator
     */
    MinPQ(final Comparator<Key> comparator1) {
        this(1, comparator1);
    }

    /**
     * Initializes a priority queue from the array of keys.
     *
     * @param      keys  The keys
     */
    MinPQ(final Key[] keys) {
        n = keys.length;
        pq = (Key[]) new Object[keys.length + 1];
        for (int i = 0; i < n; i++) {
            pq[i + 1] = keys[i];
        }
        for (int k = n / 2; k >= 1; k--) {
            sink(k);
        }
        assert isMinHeap();
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
     * Returns a smallest key on this priority queue.
     * Complexity :

     *              Worst Case : O(1)
     * @return     { minimum key }
     */
    public Key min() {
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

     *              Worst Case : O(logn)
     * @param      x     { key }
     */
    public void insert(final Key x) {
        // double size of array if necessary
        if (n == pq.length - 1) {
            resize(2 * pq.length);
        }


        pq[++n] = x;
        swim(n);
        assert isMinHeap();
    }

    /**
     * Removes and returns a smallest key on this priority queue.
     * Complexity :

     *              Worst Case : O(logn)
     * @return     { key }
     */
    public Key delMin() {
        final int four = 4;
        if (isEmpty()) {
            throw new NoSuchElementException(
                "Priority queue underflow");
        }
        Key min = pq[1];
        exch(1, n--);
        sink(1);
        pq[n + 1] = null;
        if ((n > 0) && (n == (pq.length - 1) / four)) {
            resize(pq.length / 2);
        }
        assert isMinHeap();
        return min;
    }



    /**
     * swim function.
     * Complexity :

     *              Worst Case : O(logn)
     * @param      k1     { value }
     */
    private void swim(final int k1) {
        int k = k1;
        while (k > 1 && greater(k / 2, k)) {
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
     * greater function.
     * Complexity :

     *              Worst Case : O(1)
     * @param      i     { index1 }
     * @param      j     { index2 }
     *
     * @return     { true or false }
     */
    private boolean greater(final int i, final int j) {
        if (comparator == null) {
            return ((Comparable<Key>) pq[i]).compareTo(pq[j]) > 0;
        } else {
            return comparator.compare(pq[i], pq[j]) > 0;
        }
    }

    /**
     * exchange function.
     * Complexity :
     *
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
     * Determines if minimum heap.
     * Complexity :

     *              Worst Case : O(1)
     * @return     True if minimum heap, False otherwise.
     */
    private boolean isMinHeap() {
        return isMinHeap(1);
    }

    /**
     * Determines if minimum heap.
     * Complexity :

     *              Worst Case : O(1)
     * @param      k1     { value }
     *
     * @return     True if minimum heap, False otherwise.
     */
    private boolean isMinHeap(final int k1) {
        int k = k1;
        if (k > n) {
            return true;
        }
        int left = 2 * k;
        int right = 2 * k + 1;
        if (left  <= n && greater(k, left)) {
            return false;
        }
        if (right <= n && greater(k, right)) {
            return false;
        }
        return isMinHeap(left) && isMinHeap(right);
    }



        }


