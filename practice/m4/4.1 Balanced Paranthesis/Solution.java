import java.util.Scanner;
import java.util.Stack;
class Solution {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int inputcount = Integer.parseInt(scan.nextLine());
		boolean flag = false;
		for(int j = 0; j<inputcount; j++) {
			Stack<String> mystack = new Stack<String>();
			String[] array = scan.nextLine().split("");
			for (int i = 0; i < array.length; i++) {
				if (array[i].equals("[") || array[i].equals("{") || array[i].equals("(")) {
					mystack.push(array[i]);

				}
				else {
					if (mystack.empty()) {
						System.out.println("NO");
						flag = true;
						break;
					}
					mystack.pop();

				}
			}
			if(!flag) {
				if (mystack.empty()) {
				System.out.println("YES");
			    } else {
				System.out.println("NO");
			}
			}

		}
		}

}