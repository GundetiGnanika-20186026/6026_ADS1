// as given that avg  logarithmic complexity we can use BST.
import java.util.Scanner;
/**
 * Class for binary search tree.
 *
 * @param      <Key>    The key
 * @param      <Value>  The value
 */
class BinaryST<Key extends Comparable<Key>, Value> {
    /**
     * Constructs the object.
     */
    BinaryST() {

    }
    /**
     * root node.
     */
    private Node root;

    /**
     * Class for node.
     */
    class Node {
        /**
         * Key type key.
         */
        private Key key;
        /**
         * val of the node.
         */
        private Value val;
        /**
* pointers to point left and right nodes.
         */
        private Node left, right;
        /**
         * variable to keep track of size.
         */
        private int size;

        /**
         * Constructs the object.
         *
         * @param      key1   The key
         * @param      val1   The value
         * @param      size1  The size
         */

        Node(final Key key1, final Value val1,
         final int size1) {
            this.key = key1;
            this.val = val1;
            //this.size = size1;
        }

    }


    /**
     * {this method will insert the key
     *  into the linked list.
     *  its complexity is O(N) in worst case as we are not
     *   iterating through the entire list.}.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Key key, final Value val) {
        root = put(root, key, val);
    }

    /**
     * {this method will return the key
     *  to be inserted into linked list.
     *  its complexity is O(N)}.
     *
     * @param      node  rootnode
     * @param      key   The key
     * @param      val   The value
     *
     * @return     Node to be inserted.
     */
    public Node put(final Node node, final Key key,
     final Value val) {
        if (node == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.getName().compareTo(node.key.getName());
        if      (cmp < 0) {
            node.left  = put(node.left,  key, val);
        } else if (cmp > 0) {
            node.right = put(node.right, key, val);
        } else {
            node.val   = val;
        }
        //node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    /**
     * { This method will return the value of given key
     * its complexity is O(N) as we are
     *  not iterating through the entire list}.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */

    public Value get(final Key key) {
        return get(root, key);
    }

    /**
     * { This method will return the value of given key
     * its complexity is O(N) as we are
     *  not iterating through the entire list }.
     *
     * @param      node     { root node }.
     * @param      key   The key whose value to be found.
     *
     * @return     { value of given key }.
     */
    private Value get(final Node node, final Key key) {

        if (node == null) {
            return null;
        }
        int cmp = key.getName().compareTo(node.key.getName());
        if (cmp < 0) {
            return get(node.left, key);
        } else if (cmp > 0) {
            return get(node.right, key);
        } else {
            return node.val;
        }
    }
}

class Solution{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
    }
}