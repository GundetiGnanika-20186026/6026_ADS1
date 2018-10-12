import java.util.Scanner;
/**
 * Class for cube sum.
 */
class CubeSum implements Comparable<CubeSum> {
    /**
     * sum.
     */
    private final int sum;
    /**
     * value1.
     */
    private final int i;
    /**
     * value2.
     */
    private final int j;
    /**
     * Constructs the object.
     */
    CubeSum() {
        sum = 0;
        i = 0;
        j = 0;

    }

    /**
     * Constructs the object.
     *
     * @param      i1     { value1 }
     * @param      j1     { value2 }
     */
    CubeSum(final int i1, final int j1) {
        this.sum = i1 * i1 * i1 + j1 * j1 * j1;
        this.i = i1;
        this.j = j1;
    }

    /**
     * { this method is used for comparing }.
     *
     * @param      that  The other cube sum.
     *
     * @return     { -1 if less and 1 if greater }
     */
    public int compareTo(final CubeSum that) {
        if (this.sum < that.sum) {
            return -1;
        }
        if (this.sum > that.sum) {
            return +1;
        }
        return 0;
    }

    /**
     * Gets the j.
     *
     * @return     The j.
     */
    public int getJ() {
        return j;
    }


    /**
     * Gets i.
     *
     * @return     i.
     */
    public int getI() {
        return i;
    }

    /**
     * Gets the sum.
     *
     * @return     The sum.
     */
    public int getSum() {
        return sum;
    }

}


/**
 * main class.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {


        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        CubeSum obj = new CubeSum();
        int count = 1;
        int temp = -1;
        int cutval = 600;


        // initialize priority queue
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 0; i <= cutval; i++) {
            pq.insert(new CubeSum(i, i));
        }


        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
            if (s.getSum() == temp) {
                count++;
            } else {
                count = 0;
            }
            if (count == m - 1) {
                n--;
                if (n == 0) {

                    System.out.println(s.getSum());
                    break;
                }
            }

            temp = s.getSum();

            //System.out.println(s);
            if (s.getJ() < cutval) {
                pq.insert(new CubeSum(s.getI(), s.getJ() + 1));
            }
        }

    }
}
