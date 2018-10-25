/**
 * Class for hash st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */

class HashST<Key, Value> {
    /**
     * capacity of hash table.
     */

    private static final int INIT_CAPACITY = 4;
    /**
     * size.
     */
    private int n;
    /**
     * hashtable size.
     */
    private int m;
    /**
     * hashtable array.
     */
    private SequentialSearchST<Key, Value>[] st;

    /**
     * Constructs the object.
     */
    HashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Constructs the object.
     *
     * @param      m1     { capacity of hash table }
     */

     HashST(final int m1) {
        this.m = m1;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    /**
     * generates hash which acts as index.
     * its complexity is O(N)
     *
     * @param      key   The key
     *
     * @return     { value where the node to be placed }
     */
    private int hash(final Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }
    /**
     * returns size.
     * its complexity is O(1).
     *
     * @return     { size }
     */
    public int size() {
        return n;
    }

    /**
     * checks wether the key is present.
     * its complexity is O(N). as we are using hash.
     *
     * @param      key   The key
     *
     * @return     { true or false }
     */
    public boolean contains(final Key key) {
        return get(key) != null;
    }

    /**
     * returns the value of keep.
     * its complexity is O(N). as we are using hash.
     *
     * @param      key   The key
     *
     * @return     { value }
     */
    public Value get(final Key key) {
        int i = hash(key);
        return st[i].get(key);
    }

    /**
     * inserts the node.
     * its complexity is O(N). as we are using hash.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        int i = hash(key);
        if (!st[i].contains(key)) {
            n++;
        }
        st[i].put(key, val);
    }
}

/**
 * Class for sequential search st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */

class SequentialSearchST<Key, Value> {
    /**
     * size.
     */
    private int n;
    /**
     * first node.
     */
    private Node first;

    /**
     * Class for node.
     */
    private class Node {
        /**
         * key.
         */
        private Key key;
        /**
         * value.
         */
        private Value val;
        /**
         * nextnode pointer.
         */
        private Node next;
        /**
         * Constructs the object.
         *
         * @param      key1   The key
         * @param      val1   The value
         * @param      next1  The next
         */

         Node(final Key key1, final Value val1, final Node next1)  {
            this.key  = key1;
            this.val  = val1;
            this.next = next1;
        }
    }

    /**
     * Constructs the object.
     */

    SequentialSearchST() {
    }

    /**
     * returns the size.
     * its complexity is O(1).
     *
     * @return     { size }
     */

    public int size() {
        return n;
    }

    // /**
    //  * Determines if empty.
    //  *
    //  * @return     True if empty, False otherwise.
    //  */
    // public boolean isEmpty() {
    //     return size() == 0;
    // }

    /**
     * checks the presence of the key.
     * its complexity is O(N) as we use get method.
     *
     * @param      key   The key
     *
     * @return     { true if present and false if not }
     */
    public boolean contains(final Key key) {

        return get(key) != null;
    }

    /**
     * will insert the node.
     * its complexity is O(1).as we are inserting the node at the beginning.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }

    /**
     * gets the value of given key.
     * its complexity is O(N).
     *
     * @param      key   The key
     *
     * @return     { value }
     */
    public Value get(final Key key) {

        for (Node x = first; x != null; x = x.next) {
            if (key.equals(x.key)) {
                return x.val;
            }
        }
        return null;
    }



}


/**
 * Class for solution.
 */