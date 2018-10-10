import java.util.Scanner;
//import java.util.Arrays;
/**
 * Class for binarysearch symbol table.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinarySearchST<Key extends Comparable<Key>, Value> {
    /**
     * keys Array.
     */
    private Key[] keys;
    /**
     * values Array.
     */
    private Value[] vals;
    /**
     * size.
     */
    private int size = 0;
    /**
     * Constructs the object.
     *
     * @param  capacity  The capacity of array.
     */
    BinarySearchST(final int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }
/////////////////////////////////////////////////////////////

    /**
     * will enter keys and values into their arrays.
     * its complexity is O(n) as we are inserting in an order.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        int i = rank(key);
        // key is already in table
        if (i < size && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        // insert new key-value pair
        for (int j = size; j > i; j--)  {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        size++;

    }
///////////////////////////////////////////////////////

    /**
     * { will return the index where to
     *  insert the value and key }.
     *  its time complexity is O(log(N)).
     *
     * @param      key   The key
     *
     * @return     { index }
     */
    public int rank(final Key key) {
        int lo = 0, hi = size - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }
///////////////////////////////////////////////////////////


    /**
     * { returns maximum key in the symbol table }.
     * its Complexity is O(1).
     *
     * @return     { key }
     */
    public Key max() {

        return keys[size - 1];
    }
//////////////////////////////////////////////////////////

    /**
     * { returns key if present else
     *  it will return the next smallest key}.
     *  its Complexity is O(1).
     *
     * @param      key   The key
     *
     * @return     { key }
     */
    public Key floor(final Key key) {

        int i = rank(key);
        if (i < size && key.compareTo(keys[i]) == 0) {
            return keys[i];
        }
        if (i == 0) {
            return null;
        } else {
            return keys[i - 1];
        }
    }
///////////////////////////////////////////////////////////

    /**
     * will return the size.
     * its Complexity is O(1).
     *
     * @return     { size }
     */
    public int size() {
        return size;
    }
///////////////////////////////////////////////////////

    /**
     * Determines if empty.
     * its Complexity is O(1).
     *
     * @return     True if empty, False otherwise.
     */
    public boolean isEmpty() {
        return size() == 0;
    }
/////////////////////////////////////////////////////

    /**
     * returns the minimum key.
     * its Complexity is O(1).
     *
     * @return     { key }
     */
    public Key min() {

        return keys[0];
    }

////////////////////////////////////////////////////////

    /**
     * will delete the given key.
     * its Complexity is O(N) as it has to iterate through
     *  the entire symbol table in the worst case to delete.
     *
     * @param      key   The key
     */
    public void delete(final Key key) {

        if (isEmpty()) {
            return;
        }

        // compute rank
        int i = rank(key);

        // key not in table
        if (i == size || keys[i].compareTo(key) != 0) {
            return;
        }

        for (int j = i; j < size - 1; j++)  {
            keys[j] = keys[j + 1];
            vals[j] = vals[j + 1];
        }

        size--;
        keys[size] = null;  // to avoid loitering
        vals[size] = null;


    }
/////////////////////////////////////////////////////////////

    /**
     * will delete the minimum key.
     * its Complexity is O(1).
     */
    public void deleteMin() {
        delete(min());
    }

///////////////////////////////////////////////////////////

    /**
     * will get the value present at that key.
     * its Complexity is O(1).
     *
     * @param      key   The key
     *
     * @return     { value }
     */
    public Value get(final Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0) {
            return vals[i];
        }
        return null;
    }

///////////////////////////////////////////////////

    /**
     * checks wether the key is present or not.
     * its Complexity is O(1).
     *
     * @param      key   The key
     *
     * @return     { true if present
     *                false if not present }
     */
    public boolean contains(final Key key) {
        return get(key) != null;
    }

////////////////////////////////////////////////

    /**
     * will print the Symbol table.
     * its Complexity is O(N)as it needs to
     *  iterate through the entire symbol table.
     */
    public void print() {
        //System.out.println(Arrays.toString(keys));
        for (int i = 0; i < size; i++) {
            System.out.println(keys[i] + " " + vals[i]);
        }
    }
///////////////////////////////////////////////////


}

///////////////////////////////////////////////////////////////////////

/**
 * main class.
 */
final class Solution {

    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        BinarySearchST<String, Integer> st = new
        BinarySearchST<String, Integer>(input.length);
        for (int i = 0; i < input.length; i++) {
            st.put(input[i], i);
        }
        //st.print();

        while (scan.hasNext()) {
            String[] token = scan.nextLine().split(" ");
            switch (token[0]) {
            case "max":
                System.out.println(st.max());
                break;
            case "floor":
                System.out.println(st.floor(token[1]));
                break;
            case "rank":
                System.out.println(st.rank(token[1]));
                break;
            case "deleteMin":
                st.deleteMin();
                break;
            case "contains":
                System.out.println(st.contains(token[1]));
                break;
            case "keys" :
                st.print();
                break;
            case "get" :
                System.out.println(st.get(token[1]));
                break;
            default:
                break;


            }
        }

    }
}
