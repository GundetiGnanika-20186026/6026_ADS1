import java.util.Scanner;
//import java.util.Arrays;
class Linkedlist{
	 Node head = null;
	 int size = 0;
	 class Node{
		 int data;
		 Node next;
		Node(int data1){
			data = data1;
			next = null;
		}
	}

		public void push(int data1){
			Node newnode = new Node(data1);
			if(size == 0){
				head = newnode;
				size++;
				return;

			}
            newnode.next = head;
            head = newnode;
            size++;

        }

        public int pop(){
            int value = head.data;
            head = head.next;
            size--;
            return value;


        }

        public void print(){
        	System.out.println(head.data);
        }
	}

class Solution{
	public static void main(String[] args) {
		Linkedlist obj = new Linkedlist();
		Scanner scan = new Scanner(System.in);
		String[] array = scan.nextLine().split(" ");
		//System.out.println(Arrays.toString(array));
		for (int i = 0; i < array.length; i++) {
            if(!array[i].equals("+")||array[i].equals("*")){
            	obj.push(Integer.parseInt(array[i]));

            }
            else if (array[i].equals("+")) {
            	int value1 = obj.pop();
            	int value2 = obj.pop();
            	int result = value1+value2;
            	obj.push(result);

            }
            else if (array[i].equals("*")) {
            	int value1 = obj.pop();
            	int value2 = obj.pop();
            	int result = value1 * value2;
            	obj.push(result);

            }


		}
		obj.print();
	}
}