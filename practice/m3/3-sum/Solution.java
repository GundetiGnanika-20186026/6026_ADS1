import java.util.Scanner;
import java.util.Arrays;
/**
 *Author:Gnanika
 */

// class Threesum {
//  private int[] array;
//  private int size;

//  Threesum(int arraysize) {
//      array = new int[arraysize];
//      size = 0;
//  }

//  public int[] getarray() {
//      return array;
//  }

//  public void add(int value) {
//      array[size++] = value;

//  }

//  public void sumofthree() {
//      int count = 0;
//      Arrays.sort(array);
//      int sum = 0;

//         //System.out.println(size);
//      for (int i = 0; i < size ; i++) {

//          for (int j = i + 1; j < size; j++) {

//              for (int k = j + 1; k < size; k++) {
//              sum = array[i] + array[j] + array[k];
//                  if (sum == 0) {
//                      count = count + 1;
//                  }
//              }
//          }
//      }
//      System.out.println(count);
//  }






// }

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
        int count = 0;
//Threesum object1 = new Threesum(arraysize);
        int[] array = new int[arraysize];
        for (int i = 0; i < arraysize; i++) {
            //object1.add(scan.nextInt());
            array[i] = scan.nextInt();
        }
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


        //System.out.println(Arrays.toString(object1.getarray()));
        //object1.sumofthree();


    }
}
