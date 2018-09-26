import java.util.Scanner;
import java.util.Arrays;

class Threesum {
	private int[] array;
	private int size;

	Threesum(int arraysize) {
		array = new int[arraysize];
		size = 0;
	}

	public int[] getarray() {
		return array;
	}

	public void add(int value) {
		array[size++] = value;

	}

	public void sumofthree() {
		int count = 0;
		Arrays.sort(array);
		int sum = 0;

        //System.out.println(size);
		for (int i = 0; i < size ; i++) {

			for (int j = i + 1; j < size; j++) {

				for (int k = j + 1; k < size; k++) {
					sum = array[i] + array[j] + array[k];
					if (sum == 0) {
						count = count + 1;
					}
				}
			}
		}
		System.out.println(count);
	}






}
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arraysize = scan.nextInt();
		Threesum object1 = new Threesum(arraysize);
		for (int i = 0; i < arraysize ; i++) {
			object1.add(scan.nextInt());
		}

		//System.out.println(Arrays.toString(object1.getarray()));
		object1.sumofthree();


	}
}