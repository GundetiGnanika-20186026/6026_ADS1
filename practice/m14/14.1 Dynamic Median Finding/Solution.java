import java.util.Scanner;
import java.util.Arrays;
class Maxpq {
	int[] array;
	int size;
	Maxpq(int length) {
		array = new int[length+1];
		size = 0;
	}
//////////////////////////////////////////////
    public void insert(int value) {
		array[++size] = value;
        sort(array);
		// System.out.println(Arrays.toString(array));
		// System.out.println(size);


	    System.out.println(median());
	}

/////////////////////////////////


	public float median() {
        // int[] array1 = new int[size];
        // int m = 0;
        // for(int i =1 ; i<size; i++) {
        //     array1[m] = array[i];
        //     m++;
        // }

        // System.out.println(Arrays.toString(array1));
		if (size == 1) {
			return array[1];
		}
		if (size % 2 == 0){
			float b = array[size/2]+array[(size/2)+1];
			b = b/2;
			// System.out.println((array[size/2]+"   "+array[(size/2)+1]));
			return b;

		}
		else {
			return array[(size+1)/2];
		}
		// return 1;

	}
////////////////////////////////////
	public void sort(int[] array) {
		int n = size;
		for (int k = n / 2; k >= 1; k--) {
			sink(array, k, n);
		}
		while (n > 1) {
			exch(array, 1, n);
			sink(array, 1, --n);
		}
	}
/////////////////////////////

	public void sink(int[] array1, int k, int n) {
		while (2 * k <= n) {
			int j = 2 * k;
			if (j < n && less(j, j + 1)) j++;
			if (!less(k, j)) break;
			exch(array, k, j);
			k = j;
		}
	}
///////////////////////////////////////
	public boolean less(int i, int j) {
		return array[i]-array[j] < 0;
	}
////////////////////////////////////

	public void exch(int[] array, int i, int j) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;
	}
/////////////////////////////////////



}
class Solution {
	Solution() {

	}
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int num = Integer.parseInt(scan.nextLine());
		Maxpq obj = new Maxpq(num);
		for (int i = 0; i < num; i++) {
             int element = Integer.parseInt(scan.nextLine());
             obj.insert(element);


		}
	}
}