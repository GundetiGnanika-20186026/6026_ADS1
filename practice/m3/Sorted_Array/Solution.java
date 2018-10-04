import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() { }
    /**
     * { main method }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int arr1size = Integer.parseInt(scan.nextLine());
        int arr2size = Integer.parseInt(scan.nextLine());
        String[] str1 = scan.nextLine().split(",");
        String[] str2 = scan.nextLine().split(",");
        int[] arr1 = new int[arr1size];
        int[] arr2 = new int[arr2size];
        Sortedarray obj = new Sortedarray();
        obj.sort(str1, str2, arr1, arr2, arr1size, arr2size);

//         for (int i = 0; i < arr1size; i++) {
//             arr1[i] = Integer.parseInt(str1[i]);
//         }

//         for (int i = 0; i < arr2size; i++) {
//             arr2[i] = Integer.parseInt(str2[i]);
//         }

//         int[] arr3 = new int[arr1size + arr2size];
//         int i = 0; int j = 0; int k = 0;
//         while (i < arr1size && j < arr2size) {
//             if (arr1[i] < arr2[j]) {
//                 arr3[k++] = arr1[i++];
//             }
//             arr3[k++] = arr2[j++];

//         }
//         while (i < arr1size) {
//             arr3[k++] = arr1[j++];
//         }
//         while (j < arr2size) {
//             arr3[k++] = arr2[j++];
//         }
//         int a;
// for (a = 0; a < (arr1size + arr2size) - 1; a++) {
//             System.out.print(arr3[a] + ",");
//         }
//         System.out.print(arr3[a]);

    }
}

/**
 * Class for sortedarray.
 */

class Sortedarray {
    /**
     * Constructs the object.
     */

    Sortedarray() {

    }
    /**
     * { this method will merge the sorted arrays }.
     *
     * @param      str1      The string 1
     * @param      str2      The string 2
     * @param      arr1      The arr 1
     * @param      arr2      The arr 2
     * @param      arr1size  The arr 1 size
     * @param      arr2size  The arr 2 size
     */
    public void sort(final String[] str1, final String[] str2,
                     final int[] arr1, final int[] arr2,
                     final int arr1size, final int arr2size) {
        for (int i = 0; i < arr1size; i++) {
            arr1[i] = Integer.parseInt(str1[i]);
        }

        for (int i = 0; i < arr2size; i++) {
            arr2[i] = Integer.parseInt(str2[i]);
        }

        int[] arr3 = new int[arr1size + arr2size];
        int i = 0; int j = 0; int k = 0;
        while (i < arr1size && j < arr2size) {
            if (arr1[i] < arr2[j]) {
                arr3[k++] = arr1[i++];
            }
            arr3[k++] = arr2[j++];

        }
        while (i < arr1size) {
            arr3[k++] = arr1[j++];
        }
        while (j < arr2size) {
            arr3[k++] = arr2[j++];
        }
        int a;
        for (a = 0; a < (arr1size + arr2size) - 1; a++) {
            System.out.print(arr3[a] + ",");
        }
        System.out.print(arr3[a]);
    }

}
