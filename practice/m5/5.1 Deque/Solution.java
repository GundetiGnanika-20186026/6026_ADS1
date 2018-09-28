import java.util.*;
class Deque<E> {
	 Node head;
	 int size = 0;

    class Node {
    	E data;
    	Node next;

    	Node(E data1) {
        	this.data = data1;
        	next = null;
       }
    }

    public int getsize(){
    	return size;
    }

    public boolean isEmpty() {
    	if(size == 0){
    		return true;
    	}
    	return false;
    }



    public void addFront(E data) {
    	Node first = new Node(data);
        if (size == 0) {
        	head = first;
        	size++;
        	return;
        }
        first.next = head;
        head = first;
        size++;
    }

    public void addLast(E data) {
    	if(size == 0) {
    		addFront(data);
    		return;
    	}
    	Node last = new Node(data);
    	Node n = head;
    	int count = 0;
    	while(count < size-1) {  /**because of head**/
    		n = n.next;
    		count++;
    	}
    	n.next = last;
    	last.next = null;
    	size++;
    }
    /**inserts at index ith position**/
    // public void addAfter(int i, E data) {
    // 	Node middle = new Node(data);
    // 	Node n = head;
    // 	int count = 0;
    // 	while(count < i-1) {
    // 		count++;
    // 		n = n.next;
    // 	}
    // 	// System.out.println(n.data);
    // 	middle.next = n.next;
    // 	n.next = middle;
    // 	size++;
    // }

    public void removeFirst() {
    	if (size == 0) {
    		System.out.println("[]");
    		return;
    	}
        head = head.next;
        size--;
    }

    public void removeLast() {
    	if (size == 0) {
    		System.out.println("No elements in array");
    		return;
    	}
        Node n = head;
        int count = 0;
        while(count < size-2) {
        	n = n.next;
        	count++;
        }
        // System.out.println(n.data);
        n.next = null;
        size--;
    }

    // public void removeAfter(int i) {
    // 	Node n = head;
    // 	int count = 0;
    // 	while(count < i-1) {
    // 		count++;
    // 		n = n.next;
    // 	}
    // 	n.next = n.next.next;
    // 	size--;
    // }
    //

    public String print() {
    	Node n = head;
    	String str = "";
    	str += "[";
    	// while(n != null) {
    	// 	str += n.data+",";
    	// 	//System.out.print(n.data+", ");
    	// 	n = n.next;
    	// }
    	for(int i = 0; i < size-1; i++){
    		str += n.data+", ";
    		n=n.next;
    	}
    	return str+n.data+"]";

    }


}


class Solution{
	public static void main(String[] args) {
		Deque<String> obj = new Deque<String>();
		Scanner scan = new Scanner(System.in);
		int numberoflines = Integer.parseInt(scan.nextLine());
		while(scan.hasNext()){
			String[] firsttoken = scan.nextLine().split(" ");
			switch(firsttoken[0]){
				case "pushLeft":
				      obj.addFront(firsttoken[1]);
				      System.out.println(obj.print());

				break;
				case "pushRight":
				      obj.addLast(firsttoken[1]);
				      System.out.println(obj.print());
				break;
				case "popLeft" :
				      obj.removeFirst();
				      System.out.println(obj.print());
				break;
				case "popRight" :
				      obj.removeLast();
				      System.out.println(obj.print());
				break;
				case "size" :
				      System.out.println(obj.getsize());

				break;
				case "isEmpty" :
				      System.out.println(obj.isEmpty());

				break;
				default:
				break;
			}
		}
	}
}