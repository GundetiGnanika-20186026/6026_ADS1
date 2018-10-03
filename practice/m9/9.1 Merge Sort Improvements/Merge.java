import java.util.*;
/**
 * Class for merge.
 */
class Merge {
	final int CUTOFF = 7;
	/**
	 * Constructor for merge class which contains sort method , exchange,insertionsort methods.
	 */
	Merge() {

	}

	/**
	 * Time complexity is O(N) as it has one for loop which iterates through the entire array
	 *  this method does the merge operation.
	 *
	 * @param      array     The array
	 * @param      auxilary  The auxilary
	 * @param      low       The low
	 * @param      mid       The middle
	 * @param      hi        The higher
	 */
	public void merge(Comparable[] array, Comparable[] auxilary, int low, int mid, int hi) {
		/**
		 * checks wether the array is sorted.
		 */
		assert isSorted(array, low, mid);
		/**
		 * checks wether the array is sorted.
		 */
		assert isSorted(array, mid + 1, hi);

		int i = low, j = mid + 1;
		for (int k = low; k <= hi; k++) {
			if (i > mid) {
				auxilary[k] = array[j++];
			}

			else if (j > hi) {
				auxilary[k] = array[i++];
			}

			else if (less(array[j], array[i])) {
				auxilary[k] = array[j++];
			} else {
				auxilary[k] = array[i++];
			}
		}
		assert isSorted(auxilary, low, hi);
	}

	/**
	 *this method does the sort operation from top-bottom approach
	 *if the length of the array is less than 7 then it usses the insertion sort.
	 * Time complexity is O(1)
	 *
	 * @param      array     The array
	 * @param      auxilary  The auxilary
	 * @param      low       The low
	 * @param      hi        The higher
	 */
	private void sort(Comparable[] array, Comparable[] auxilary, int low, int hi) {
		if (hi- low <=  CUTOFF) {
			insertionSort(auxilary, low, hi);
			System.out.println("Insertion sort method invoked...");
			return;
		}
		int mid = low + (hi - low) / 2;
		sort(auxilary, array, low, mid);
		sort(auxilary, array, mid + 1, hi);

		if (!less(array[mid + 1], array[mid])) {
			for (int i = low; i <= hi; i++) {
				auxilary[i] = array[i];
			}
			System.out.println("Array is already sorted. So, skipped the call to merge...");
			return;
		}
		merge(array, auxilary, low, mid, hi);
	}

	/**
	 * { Time complexity is O(1)}.
	 * this method does the sorting operation.
	 *
	 * @param      array     { array to be sorted }
	 */
	public void sort(Comparable[] array) {
		Comparable[] aux = array.clone();
		sort(aux, array, 0, array.length - 1);
		assert isSorted(array);
	}

	/**
	 *Time complexity is O(N^2) as it has nested for loops.
	 *
	 * @param      array     { array to be sorted }
	 * @param      low   The lower
	 * @param      hi    The higher
	 */
	public void insertionSort(Comparable[] array, int low, int hi) {
		for (int i = low; i <= hi; i++)
			for (int j = i; j > low && less(array[j], array[j - 1]); j--)
				exch(array, j, j - 1);
	}

	/**
	 * { Time complexity is O(1) }
	 * this method does the exchange operation
	 *
	 * @param      array  The array
	 * @param      i      { index }
	 * @param      j      { index }
	 */
	public void exch(Comparable[] array, int i, int j) {
		Comparable swap = array[i];
		array[i] = array[j];
		array[j] = swap;
	}

	/**
	 * { checks if the value is less or greater than the other }
	 * Time complexity is O(1)
	 * @param      v     { element }
	 * @param      w     { element }
	 *
	 * @return     { true if less and false if greater }
	 */
	public boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	/**
	 * Determines if sorted.
	 * Time complexity is O(1).
	 *
	 * @param      array  The array
	 *
	 * @return     True if sorted, False otherwise.
	 */
	public boolean isSorted(Comparable[] array) {
		return isSorted(array, 0, array.length - 1);
	}


	/**
	 * Determines if sorted.
	 * Time complexity is O(N)
	 *
	 * @param      array  The array
	 * @param      low    The low
	 * @param      hi     The higher
	 *
	 * @return     True if sorted, False otherwise.
	 */
	public boolean isSorted(Comparable[] array, int low, int hi) {
		for (int i = low + 1; i <= hi; i++)
			if (less(array[i], array[i - 1])) {
				return false;
			}
		return true;
	}

	/**
	 * this method is used for printing.
	 * Time complexity is O(N) as it itterates through the entire array.
	 *
	 * @param      a     { parameter_description }
	 *
	 * @return     { description_of_the_return_value }
	 */
	public Object show(Object[] array) {
		String str = "[";
		int i;
		for (i = 0; i < array.length - 1; i++) {
			str += array[i] + ", ";
		}
		str = str + array[array.length - 1] + "]";
		return str;
	}
}