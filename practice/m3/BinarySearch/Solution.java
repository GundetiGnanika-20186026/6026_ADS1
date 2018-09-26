/**
 * Author:Gnanika.
 */
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = scan.nextInt();
        int[] array = new int[size];
         for (int i = 0; i < size; i++) {
            array[i] = scan.nextInt();
        }
        Arrays.sort(array);


        System.out.println("Enter the to be searched : ");
        int searchelement = scan.nextInt();
        int first = 0;
        int last = size;
        int present = 0;
        int middle = 0;

        if (size == 1 && array[size-1] == searchelement) {
            System.out.println("Array contains the searchelement "
                               + searchelement + " at " + first);
            return;
        }

        while (last != first) {
            middle = ((first + last) / 2);
            if (array[middle] == searchelement) {
                present = 1;
                last = middle;
            } else if (array[middle] < searchelement) {
                first = middle + 1;
            } else {
                last = middle - 1;
            }

        }
            if (present == 1) {
            System.out.println("Array contains the searchelement"
                               + searchelement + " at " + last);
            return;
        }
        System.out.println("Array does not contain the searchelement " + searchelement);
        }
    }