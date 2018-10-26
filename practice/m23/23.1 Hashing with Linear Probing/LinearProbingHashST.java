/**
 * Class for linear probing hash st.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class LinearProbingHashST<Key, Value> {
    /**
     * capacity of the array.
     */
    private static final int INIT_CAPACITY = 4;
    /**
     * number of key-value pairs in the symbol table.
     */
    private int n;
    /**
     * size of linear probing table.
     */
    private int m;
    /**
     * the keys.
     */
    private Key[] keys;
    /**
     * the values.
     */
    private Value[] vals;


    /**
     * Initializes an empty symbol table.
     */
    LinearProbingHashST() {
        this(INIT_CAPACITY);
    }

    /**
     * Constructs the object.
     *
     * @param      capacity  The capacity
     */
    LinearProbingHashST(final int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[])   new Object[m];
        vals = (Value[]) new Object[m];
    }

    /**
     * returns size.
     * its complexity is O(1).
     *
     * @return     { n value }
     */
    public int size() {
        return n;
    }

    /**
     * checks wether the given key is present in array.
     * its complexity is O(N) in the worst case as we are using put in it.
     *
     * @param      key   The key
     *
     * @return     { true or false }
     */
    public boolean contains(final Key key) {
        return get(key) != null;
    }

    /**
     * will return the index where the key has to be placed.
     * its complexity is O(N) in the worst case when given a string.
     * else its complexity is log(N)*.
     *
     * @param      key   The key
     *
     * @return     { index value }
     */
    private int hash(final Key key) {
        return (key.hashCode() * 11) % m;//& 0x7fffffff
    }

    /**
     * will resize the array.
     * its complexity is O(N) in the worst case as we are using put in it.
     *
     * @param      capacity  The capacity
     */
    private void resize(final int capacity) {
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity);
        for (int i = 0; i < m; i++) {
            if (keys[i] != null) {
                temp.put(keys[i], vals[i]);
            }
        }
        keys = temp.keys;
        vals = temp.vals;
        m    = temp.m;
    }

    /**
     * insert the key and value.
     *
     * its complexity is O(N) in the worst case when given a string.
     * else its complexity is log(N)*
     * or may be a constant.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {

        if (n >= m / 2) {
            resize(2 * m);
        }

        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
        }
        keys[i] = key;
        vals[i] = val;
        n++;
    }

    /**
     * gets the value of given key.
     * its complexity is O(N) in the worst case when given a string.
     * else its complexity is log(N)*
     * or may be a constant.
     *
     * @param      key   The key
     *
     * @return     { value }
     */
    public Value get(final Key key) {

        for (int i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
        }
        return null;
    }

    /**
     * deletes the given key value pair.
     * its complexity is O(N) in the worst case when given a string.
     * else its complexity is log(N)*
     * or may be a constant.
     *
     *
     * @param      key   The key
     */
    public void delete(final Key key) {

        if (!contains(key)) {
            return;
        }


        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % m;
        }


        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % m;
        while (keys[i] != null) {

            Key   keyToRehash = keys[i];
            Value valToRehash = vals[i];
            keys[i] = null;
            vals[i] = null;
            n--;
            put(keyToRehash, valToRehash);
            i = (i + 1) % m;
        }

        n--;
        final int num1 = 8;
        if (n > 0 && n <= m / num1) {
            resize(m / 2);
        }


    }

    /**
     * will display all the keys in the array.
     * its complexity is O(N) as we are iterating through the entire array.
     */
    public void display() {
        String str = "{";
        String res = "";
        int i;
        int count = 0;
        if (size() == 0) {
            System.out.println("{}");
            return;
        }
        for (i = 0; i < m; i++) {
            if (keys[i] != null)
                str += keys[i] + ":" + vals[i] + ", ";
            count += 1;
        }


        res = str.substring(0, str.length() - 2);
        System.out.println(res + "}");
    }



}