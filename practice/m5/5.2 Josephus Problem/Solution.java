import java.util.Scanner;
class Queue {
	private Node head;
	private Node tail;
    //public int size;

    private class Node {
        private int value;
        private Node next;
    }

    Queue() {
        head = null;
        tail = null;
    }

    public void enqueue (final int value){
    	if (tail == null) {
           tail = new Node();
           tail.value = value;
           tail.next = null;

           head = tail;

        } else {
           Node oldTail = tail;
    	   tail = new Node();
    	   tail.value = value;
    	   tail.next = null;
           oldTail.next = tail;

        }

    }

    public int dequeue(){
        if (head != null) {
            int value = head.value;
            head = head.next;
            //size--;
            return value;
        }
        return tail.value;
    }

    public boolean isEmpty() {
        return head == null;
    }
    // public int size() {
    //     return size;
    // }
}








class Solution{
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int number = Integer.parseInt(scan.nextLine());
		for(int i = 0;i<number;i++){
			String[] token= scan.nextLine().split(" ");
			int totalpeople = Integer.parseInt(token[0]);
            int shift = Integer.parseInt(token[1]);
            Queue q = new Queue();
            String str = "";
            for (int j = 0; j < totalpeople; j++) {
                q.enqueue(j);
            }

            while (!q.isEmpty()) {
                for (int k = 0; k < shift - 1; k++) {
                    q.enqueue(q.dequeue());
                }
                str += q.dequeue() + " ";
            }
            System.out.println(str.substring(0, str.length() - 1));
            //System.out.println();
        }


		}

	}
