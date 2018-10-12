import java.util.Scanner;
class CubeSum implements Comparable<CubeSum> {
    private final int sum;
    private final int i;
    private final int j;
    CubeSum() {
        sum = 0;
        i = 0;
        j = 0;

    }

    public CubeSum(int i, int j) {
        this.sum = i * i * i + j * j * j;
        this.i = i;
        this.j = j;
    }

    public int compareTo(CubeSum that) {
        if (this.sum < that.sum) return -1;
        if (this.sum > that.sum) return +1;
        return 0;
    }

    // public  toString() {
    //     return sum;
    // }

    public int getJ() {
        return j;
    }

    public int getI() {
        return i;
    }

    public int getSum(){
        return sum;
    }

}



class Solution {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        String[] input = scan.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        CubeSum obj = new CubeSum();
        int count = 1;
        int temp = -1;
        int c = 600;


        // initialize priority queue
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 0; i <= c; i++) {
            pq.insert(new CubeSum(i, i));
        }


        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
            if(s.getSum() == temp){
               count++;
            } else {
                count = 0;
            }
            if (count == m-1){
                n--;
                if(n==0){

                System.out.println(s.getSum());
                break;
            }
        }

             temp = s.getSum();

            //System.out.println(s);
            if (s.getJ() < c)
                pq.insert(new CubeSum(s.getI(), s.getJ() + 1));
        }

    }
}
