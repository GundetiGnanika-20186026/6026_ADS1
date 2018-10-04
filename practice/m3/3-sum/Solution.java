import java.util.Scanner;
import java.util.Arrays;
/**
 *Author:Gnanika
 */
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructor for solution class.
     */
    private Solution() {

    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int arraysize = scan.nextInt();



        int[] array = new int[arraysize];
        for (int i = 0; i < arraysize; i++) {
            //object1.add(scan.nextInt());
            array[i] = scan.nextInt();
        }

        Threesum object1 = new Threesum();
        object1.threesum(arraysize, array);



    }
}

/**
 * Class for threesum.
 */
class Threesum {
    /**
     * Constructs the object.
     */
    Threesum() {

    }
    /**
     * method to calculate 3 sum.
     *
     * @param      arraysize  The arraysize
     * @param      array      The array
     */
    public void threesum(final int arraysize, final int[] array) {

        //int[] array = new int[arraysize];
        // for (int i = 0; i < arraysize; i++) {
        //     //object1.add(scan.nextInt());
        //     array[i] = scan.nextInt();
        // }
        int count = 0;
        Arrays.sort(array);
        for (int i = 0; i < arraysize; i++) {
            for (int j = i + 1; j < arraysize; j++) {
                //sending the values to the binary search and
                // searching wether it is present.
                int k = Arrays.binarySearch(array, -(array[i] + array[j]));
                if (k > j) {
                    count = count + 1;
                }
            }
        }
        System.out.println(count);

    }
}
