import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for withoutsort.
 */
class Withoutsort {
	private int[] array;
	private int size;
	/**
	 * Constructs the object.
	 *
	 * @param      size  The size
	 */
	Withoutsort(int size) {
		array = new int[size];
		size = 0;
	}

	public int[] getarray() {
		return array;
	}

	public void add(int value) {
		array[size++] = value;

	}
    /**
     * N^2 complexity
     */
	public void  pairswithoutsort() {
		int count = 0;
		for (int i = 0; i < size - 1; i++) {
			for (int j = i + 1; j < size; j++) {
				if (array[i] == array[j]) {
					count = count + 1;
					System.out.print(array[i] + "," + array[j] + "  ");


				}

			}
		}
		System.out.println();
		System.out.println("total pairs found : " + count);
	}
	/**
	 * N complexity(as we are using sort the complexity decreases)
	 */
    public void  pairswithsort() {
		Arrays.sort(array);
		int count = 0;
		int totalcount = 1;
		for (int i = 0; i < size; i++) {
			if (i < size - 1 && array[i] == array[i + 1]) {
				totalcount = totalcount + 1;
				totalcount = i * (i - 1) / 2;
				//System.out.print(array[i]+" "+array[i]+"  ");

			} else {
				if (totalcount > 1) {
					count += totalcount * (totalcount - 1) / 2;
				}
				totalcount = 1;
			}
		}
		System.out.println();

		System.out.println("total pairs found: " + count);
	}

}
/**
 * Class for solution.
 */
class Solution {
	/**
	 * { main function }
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arraysize = scan.nextInt();
		Withoutsort object1 = new Withoutsort(arraysize);
		for (int i = 0; i < arraysize ; i++) {
			object1.add(scan.nextInt());
		}
		System.out.println(Arrays.toString(object1.getarray()));
		object1.pairswithoutsort();
		object1.pairswithsort();


	}
}