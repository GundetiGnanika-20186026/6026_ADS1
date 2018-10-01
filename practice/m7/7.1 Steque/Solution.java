/**
 * Author:Gnanika Reddy.
 */
import java.util.Scanner;
/**
 * Class for steque which contains push,pop,enqueue
 *  methods and another node class.
 */
class Steque {
	/**
	 * { size variable to keep track of the elements inserted
	 *  and deleted from the linked list }.
	 */
	private int size = 0 ;
	/**
	 * { head pointer to keep track of last inserted element }
	 */
	private Node head = null;

	/**
	 * Class for creating a node.
	 */
	private class Node {
		/**
		 * { data in the node }
		 */
		private int data;
		/**
		 * { address to be pointed when a node is added }
		 */
		private Node next;
		/**
		 * Constructs the object for nodeclass.
		 *
		 * @param      data1  The data 1
		 */
		Node(final int data1) {
			this.data = data1;
			next = null;

		}
	}

	/**
	 * { pushes the elements at the right of the linked list and
	 *  moves the head ponter to the last pushed element if the size }.
	 *
	 * @param      value  The value
	 */
	public void push(int value) {

		Node newnode = new Node(value);
		if (size == 0) {
			//newnode.next = head;
			head = newnode;
			size++;
			return;
		}
		newnode.next = head;
		head = newnode;
		size++;


	}

	/**
	 * { This method will add the elements to the linked list at the tail side }
	 *
	 * @param      value  The value
	 */
	public void enqueue(int value) {
		Node newnode = new Node(value);
		if (size == 0) {
			head = newnode;
			size++;
			return;
		}
		Node n = head;
		while (n.next != null) {
			n = n.next ;
		}
		n.next = newnode;
		size++;
	}

	/**
	 * { this method prints the elements in the linked list }
	 */
	public void print() {

		if (size == 0) {
			System.out.println("Steque is empty.");
			return;
		}
		Node n = head;
		String str = "";
		while (n != null) {

			str += n.data + ", ";
			n = n.next;
		}


		System.out.println(str.substring(0, str.length() - 2));
	}

	/**
	 * { deletes the node that the head points and then reduces the size }
	 */
	public void pop() {
		if (size == 0) {

			return;
		}
		int data = head.data;
		head = head.next;
		size--;


	}
}







/**
 * Class for solution this class contains the main method which can handle the test casses.
 */
final class Solution {
	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * { function_description }
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcases = Integer.parseInt(scan.nextLine());
		for (int i = 0 ; i < testcases; i++) {
			Steque obj = new Steque();

			while (scan.hasNext()) {
				String[] array = scan.nextLine().split(" ");
				if (array[0].equals("")) {
					break;
				}

				switch (array[0]) {
				case "push":
					obj.push(Integer.parseInt(array[1]));
					obj.print();
					break;
				case "pop" :


					obj.pop();
					obj.print();

					break;
				case "enqueue" :
					obj.enqueue(Integer.parseInt(array[1]));
					obj.print();
					break;
				}
			}



			System.out.println();

			// Steque obj = new Steque();
			// //System.out.println("object");
			// obj.push(1);
			// obj.push(2);
			// obj.push(3);
			// obj.push(4);
			// obj.enqueue(5);
			// obj.enqueue(6);
			// obj.print();
			// obj.pop();
			// obj.print();
			// obj.pop();
			// obj.pop();
			// obj.pop();
			// obj.pop();
			// obj.pop();
			// obj.pop();
			// obj.print();







		}
	}
}
