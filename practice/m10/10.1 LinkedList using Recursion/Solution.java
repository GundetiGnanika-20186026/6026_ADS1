import java.util.Scanner;
/**
 * Class for linkedlist.
 */
class Linkedlist {
	/**
	 * head node.
	 */
	private Node head = null;
	/**
	 * extra node for iteration.
	 */
	private Node extra;
	/**
	 * prev node pointer
	 */
	private Node prev;
	/**
	 * temporary node.
	 */
	private Node temp;
	/**
	 * variable to maintain size.
	 */
	private int size = 0;
	/**
	 * Class for node.
	 */
	class Node {
		/**
		 * data of the node.
		 */
		private int data;
		/**
		 * address of next node is Stored.
		 */
		private Node next;
		/**
		 * Constructs the object.
		 *
		 * @param      data1  The data 1
		 */
		Node(final int data1) {
			this.data = data1;
			this.next = null;
		}
	}
    /**
     * { this method will insert the element at specific index }.
     * its complexity is O(n) as we iterate through the list
     *
     * @param      index      The index
     * @param      data       The data
     *
     * @throws     Exception  { exception_description }
     */
	public void insertAt(int index,
	 final int data) throws Exception {
		// Node newnode = new Node(data);
		// if (size == 0) {
		// 	head = newnode;
		// 	size++;
		// 	return;
		// }
		// if (index == 0) {
		// 	newnode.next = head;
		// 	head = newnode;
		// 	size++;
		// 	return;
		// }

  //       Node n = head;

		if (index > size || index < 0) {
			throw new Exception(
				"Can't insert at this position.");
			// return;
		}

		if (index == 0) {
			Node newnode = new Node(data);
			newnode.next = extra;
			head = newnode;
			extra =  head;
			size++;
			return;
		}
		if (index == 1) {
			Node newnode = new Node(data);
			newnode.next = extra.next;
			extra.next = newnode;
			extra = head;
			size++;
			return;
		}

		extra = extra.next;
		index--;
		insertAt(index, data);
}
    /**
     * { this method  will reverse the linked list }.
     * the complexity of this method is O(n).
     *
     * @throws     Exception  { throws exception if present }
     */
	public void reverse() throws Exception {
		if (size == 0) {
			throw new Exception(
				"No elements to reverse.");
		}
		if (extra.next == null) {
			head = extra;
			head.next = prev;
			extra = head;
			prev = null;
			return;
		}
		temp = extra;
		extra = extra.next;
		temp.next = prev;
		prev = temp;
		reverse();

	}
    /**
     * Method to print in required way.
     * the complexity of this method is O(n).
     */
	public void print(){

		String str = "";
		Node newextra = head;
		while (newextra.next != null) {
			str = str + newextra.data + ", ";
			newextra = newextra.next;
		}
		str = str + newextra.data;
		System.out.println(str);

	}

}

/**
 * Class for solution.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * { main method }.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Linkedlist object = new Linkedlist();
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String[] token = scan.nextLine().split(" ");
			switch (token[0]) {
			case "insertAt" :
			    try {
				object.insertAt(Integer.parseInt(token[1]),
				 Integer.parseInt(token[2]));
				object.print();
			    }
			    catch (Exception e) {
			    	System.out.println(e.getMessage());
			    }
				break;
			case "reverse" :
			    try {
				object.reverse();
				object.print();
			    } catch (Exception e) {
			    	System.out.println(e.getMessage());
			    }
				break;
			default:
			}

		}

	}
}