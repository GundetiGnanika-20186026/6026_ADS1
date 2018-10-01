import java.util.Scanner;
class Steque {
	int size = 0 ;
	Node head = null;

	class Node {

		int data;
		Node next;

		Node(int data1) {
			this.data = data1;
			next = null;

		}
	}

	public void push(int value) {
		System.out.println("entered push");
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

	public void print() {
		//System.out.println("entered print");
		if(size == 0){
			System.out.println("Steque is empty.");
			return;
		}
		Node n = head;
		String str = "";
		while (n != null) {
			//System.out.println("entered while");
			str += n.data + ", ";
			n = n.next;
		}

		//System.out.println(str);
		System.out.println(str.substring(0, str.length() - 2));
	}


	public void pop() {
		if (size == 0) {
			//System.out.println("Steque is empty.");
			return;
		}
		int data = head.data;
		head = head.next;
		size--;


	}
}








class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int testcases = Integer.parseInt(scan.nextLine());
		for (int i = 0 ; i < testcases; i++) {
			while (scan.hasNext()) {
				Steque obj = new Steque();
				String[] array = scan.nextLine().split(" ");
				if (array.length == 1){
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


		}
		//System.out.println("hi");

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
		//obj.print();







	}
}