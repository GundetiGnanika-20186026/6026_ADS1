import java.util.Scanner;
/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private  Solution() {

    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        LinearProbingHashST obj = new LinearProbingHashST();
        for (int i = 0; i < num; i++) {
            String[] command = scan.nextLine().split(" ");
            switch (command[0]) {
            case "put":
                obj.put(command[1], Integer.parseInt(command[2]));
                break;
            case "display" :
                obj.display();

                break;
            case "get" :
                System.out.println(obj.get(command[1]));
                break;
            case "delete" :
                obj.delete(command[1]);
                break;
            default:
                break;



            }
        }


    }
}
