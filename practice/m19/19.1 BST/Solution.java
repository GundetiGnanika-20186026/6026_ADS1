import java.util.Scanner;
/**
 * Class for book.
 */
class Book {
    /**
     * book name.
     */
    private String name;
    /**
     * author name.
     */
    private String author;
    /**
     * price of book.
     */
    private double price;
    /**
     * Constructs the object.
     *
     * @param      name1    The name
     * @param      author1  The author
     * @param      price1   The price
     */
    Book(final String name1, final String author1,
         final double price1) {
        this.name = name1;
        this.author = author1;
        this.price = price1;
    }

    Book() {

    }

    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public Double getPrice() {
        return price;
    }


    public int compareTo(Book that){
        return this.name.compareTo(that.name);
    }


}
/////////////////////////////////////////////////////

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
         * book type key.
         */
        private Book key;
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

        Node(final Book key1, final Value val1,
         final int size1) {
            this.key = key1;
            this.val = val1;
            //this.size = size1;
        }

    }


    /**
     * {this method will insert the key
     *  into the linked list.
     *  its complexity is O(logN) as we are not
     *   iterating through the entire list.}.
     *
     * @param      key   The key
     * @param      val   The value
     */
    public void put(final Book key, final Value val) {
        root = put(root, key, val);
    }

    /**
     * {this method will return the key
     *  to be inserted into linked list.
     *  its complexity is O(logN)}.
     *
     * @param      node  rootnode
     * @param      key   The key
     * @param      val   The value
     *
     * @return     Node to be inserted.
     */
    public Node put(final Node node, final Book key,
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
        node.size = 1 + size(node.left) + size(node.right);
        return node;
    }

    /**
     * { This method will return the value of given key
     * its complexity is O(logN) as we are
     *  not iterating through the entire list}.
     *
     * @param      key   The key
     *
     * @return     { description_of_the_return_value }
     */

    public Value get(final Book key) {
        return get(root, key);
    }

    /**
     * { This method will return the value of given key
     * its complexity is O(logN) as we are
     *  not iterating through the entire list }.
     *
     * @param      node     { root node }.
     * @param      key   The key whose value to be found.
     *
     * @return     { value of given key }.
     */
    private Value get(final Node node, final Book key) {

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




    public Book max() {
        //if (isEmpty()) throw new NoSuchElementException("calls max() with empty symbol table");
        return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        else  return max(x.right);
    }


     public Book min() {
        //if (isEmpty()) throw new NoSuchElementException("calls min() with empty symbol table");
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        else                return min(x.left);
    }



    public Book floor(Book key) {
        //if (key == null) throw new IllegalArgumentException("argument to floor() is null");
        //if (isEmpty()) throw new NoSuchElementException("calls floor() with empty symbol table");
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node floor(Node x, Book key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp <  0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

   public Book ceiling(Book key) {
        //if (key == null) throw new IllegalArgumentException("argument to ceiling() is null");
        //if (isEmpty()) throw new NoSuchElementException("calls ceiling() with empty symbol table");
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node ceiling(Node x, Book key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) {
            Node t = ceiling(x.left, key);
            if (t != null) return t;
            else return x;
        }
        return ceiling(x.right, key);
    }


    public Book select(int k) {

        Node x = select(root, k);
        return x.key;
    }


    //  public boolean contains(Book key) {
    //     //if (key == null) throw new IllegalArgumentException("argument to contains() is null");
    //     return get(key) != null;
    // }




    //  public int size(Book lo, Book hi) {
    //     //if (lo == null) throw new IllegalArgumentException("first argument to size() is null");
    //     //if (hi == null) throw new IllegalArgumentException("second argument to size() is null");

    //     if (lo.compareTo(hi) > 0) return 0;
    //     if (contains(hi)) return rank(hi) - rank(lo) + 1;
    //     else              return rank(hi) - rank(lo);
    // }




    // public int rank(Book key) {
    //     //if (key == null) throw new IllegalArgumentException("argument to rank() is null");
    //     return rank(key, root);
    // }

    // // Number of keys in the subtree less than key.
    // private int rank(Book key, Node x) {
    //     if (x == null) return 0;
    //     int cmp = key.compareTo(x.key);
    //     if      (cmp < 0) return rank(key, x.left);
    //     else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
    //     else              return size(x.left);
    // }


    public int size() {
        return size(root);
    }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.size;
    }


    // Return key of rank k.
    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if      (t > k) return select(x.left,  k);
        else if (t < k) return select(x.right, k-t-1);
        else            return x;
    }


    public String toString(Book obj){
        //System.out.println("came....");

        return obj.getName()+","+obj.getAuthor()+","+obj.getPrice();
    }




}

///////////////////////////////////////////////////////////////


/**
 * class for Solution.
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
        BinaryST object = new BinaryST();

        while (scan.hasNext()) {
            String[] line = scan.nextLine().split(",");
//BinaryST<String,Integer> object = new BinaryST<String,Integer>();

            switch (line[0]) {
            case "put" :
                 Book obj = new Book(line[1], line[2],
                 Double.parseDouble(line[2 + 1]));

                object.put(obj, Integer.parseInt(line[2 + 2]));
                break;
            case "get" :
                 Book obj1 = new Book(line[1], line[2],
                 Double.parseDouble(line[2 + 1]));
                System.out.println(object.get(obj1));
                break;
            case "max" :
                Book max1 = object.max();
                System.out.println(object.toString(max1));
                break;
            case "min" :
                  Book min1 = object.min();
                System.out.println(object.toString(min1));
                 break;
            case "select" :
                  Book selected = object.select(Integer.parseInt(line[1]));
                  System.out.println(object.toString(selected));
                break;
            case "floor" :
                  Book obj2 = new Book(line[1], line[2],
                  Double.parseDouble(line[2 + 1]));
                  Book floor1 = object.floor(obj2);
                  System.out.println(object.toString(floor1));
                break;
            case "ceiling" :
                   Book obj3 = new Book(line[1], line[2],
                  Double.parseDouble(line[2 + 1]));
                  Book ceil1 = object.floor(obj3);
                  System.out.println(object.toString(ceil1));
                break;
            default:
                break;


            }
        }
    }
}



