import java.util.Scanner;
class Linkedlist {
	Node head = null;
	Node test;
	Node prev;
	Node temp;
	int size = 0;
	class Node {
		int data;
		Node next;
		Node(int data1) {
			this.data = data1;
			this.next = null;
		}
	}

	public void insertAt(int index, int data) throws Exception {
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
			throw new Exception("Can't insert at this position.");
			// return;
		}

		if (index == 0) {
			Node newnode = new Node(data);
			newnode.next = test;
			head = newnode;
			test =  head;
			size++;
			return;
		}
		if (index == 1) {
			Node newnode = new Node(data);
			newnode.next = test.next;
			test.next = newnode;
			test = head;
			size++;
			return;
		}

		test = test.next;
		index--;
		insertAt(index, data);
}

	public void reverse() throws Exception {
		if (size == 0) {
			throw new Exception("No elements to reverse.");
		}
		if (test.next == null) {
			head = test;
			head.next = prev;
			test = head;
			prev = null;
			return;
		}
		temp = test;
		test = test.next;
		temp.next = prev;
		prev = temp;
		reverse();

	}

	public void print(){

		String str = "";
		Node newtest = head;
		while (newtest.next != null) {
			str = str + newtest.data + ", ";
			newtest = newtest.next;
		}
		str = str + newtest.data;
		System.out.println(str);

	}

}

class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Linkedlist object = new Linkedlist();
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String[] token = scan.nextLine().split(" ");
			switch (token[0]) {
			case "insertAt" :
			    try {
				object.insertAt(Integer.parseInt(token[1]), Integer.parseInt(token[2]));
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