import java.util.Scanner;
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
    public HashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Constructs the object.
     *
     * @param      m     { capacity of hash table }
     */

    public HashST(final int m) {
        this.m = m;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[m];
        for (int i = 0; i < m; i++)
            st[i] = new SequentialSearchST<Key, Value>();
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
        if (!st[i].contains(key)) n++;
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
         * @param      key   The key
         * @param      val   The value
         * @param      next  The next
         */

        public Node(final Key key, final Value val, final Node next)  {
            this.key  = key;
            this.val  = val;
            this.next = next;
        }
    }

    /**
     * Constructs the object.
     */

    public SequentialSearchST() {
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
    public void put(final Key key,final Value val) {

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
            if (key.equals(x.key))
                return x.val;
        }
        return null;
    }



}


/**
 * Class for solution.
 */

class Solution {
    /**
     * Constructs the object.
     */
    Solution(){

    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inp = sc.nextLine().split(" ");
        int m = Integer.parseInt(inp[0]);
        int n = Integer.parseInt(inp[1]);
        String[] magazine = sc.nextLine().split(" ");
        String[] note = sc.nextLine().split(" ");
        HashST<String, Integer> mag = new HashST<String, Integer>();
        HashST<String, Integer> notes = new HashST<String, Integer>();
        for (int i = 0; i < m; i++) {
            mag.put(magazine[i], 0);
        }
        for (int j = 0; j < n; j++) {
            notes.put(note[j], 0);
        }
        for (int i = 0; i < m; i++) {
            int count = mag.get(magazine[i]);
            if (mag.contains(magazine[i])) {
                mag.put(magazine[i], count + 1);
            } else {
                mag.put(magazine[i], 1);
            }
        }
        for (int j = 0; j < n; j++) {
            if (!mag.contains(note[j])) {
                System.out.println("No");
                return;
            } else if (mag.contains(note[j])) {
                int num = notes.get(note[j]);
                if (notes.contains(note[j])) {
                    notes.put(note[j], num + 1);
                } else {
                    notes.put(note[j], 1);
                }
                if (notes.get(note[j]) > mag.get(note[j])) {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
    }
}



