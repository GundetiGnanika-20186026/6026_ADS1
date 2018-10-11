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
	Book(final String name1, final String author1, final double price1) {
		this.name = name1;
		this.author = author1;
		this.price = price1;
	}

	/**
	 * Gets the name.
	 *
	 * @return     The name.
	 */
	public String getName() {
		return name;
	}
}
////////////////////////////////////////////////////////////////////////////

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

		Node(final Book key1, final Value val1, final int size1) {
			this.key = key1;
			this.val = val1;
			//this.size = size1;
		}

	}


	/**
	 *
	 *
	 * @param      key   The key
	 * @param      val   The value
	 */
	public void put(final Book key, final Value val) {
		root = put(root, key, val);
	}

	/**
	 *
	 *
	 * @param      x
	 * @param      key   The key
	 * @param      val   The value
	 *
	 * @return     Node to be inserted.
	 */
	public Node put(final Node x, final Book key, final Value val) {
		if (x == null) return new Node(key, val, 1);
		int cmp = key.getName().compareTo(x.key.getName());
		if      (cmp < 0) x.left  = put(x.left,  key, val);
		else if (cmp > 0) x.right = put(x.right, key, val);
		else              x.val   = val;
		//x.size = 1 + size(x.left) + size(x.right);
		return x;
	}

	/**
	 * { function_description }
	 *
	 * @param      key   The key
	 *
	 * @return     { description_of_the_return_value }
	 */

	public Value get(final Book key) {
		return get(root, key);
	}

	/**
	 * { function_description }
	 *
	 * @param      x     { parameter_description }
	 * @param      key   The key
	 *
	 * @return     { description_of_the_return_value }
	 */
	private Value get(final Node x, final Book key) {
		if (key == null) throw new IllegalArgumentException("calls get() with a null key");
		if (x == null) return null;
		int cmp = key.getName().compareTo(x.key.getName());
		if      (cmp < 0) return get(x.left, key);
		else if (cmp > 0) return get(x.right, key);
		else              return x.val;
	}
}

////////////////////////////////////////////////////////////////////////////////////


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
			Book obj = new Book(line[1], line[2], Double.parseDouble(line[3]));
			switch (line[0]) {
			case "put" :

				object.put(obj, line[4]);
				break;
			case "get" :
				System.out.println(object.get(obj));
				break;


			}
		}
	}
}



