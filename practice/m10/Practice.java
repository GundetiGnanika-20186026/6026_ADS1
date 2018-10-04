import java.util.Scanner;
/**
 * Class for practice.
 */
class Practice {
	/**
	 * Constructs the object.
	 */
	Practice(){

	}
	/**
	 * { main method }
	 *
	 * @param      args  The arguments
	 */
		public static void main(final String[] args) {
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();

			System.out.println(factorial(num));

		}

        /**
         * { calculates the factorial }
         *
         * @param      num     { number whose factorial has to be determined }
         *
         * @return     { factorial of given n }
         */
		public static int factorial(int num) {

			if(num == 0){
				return 1;
			}
			if(num == 1){
				return 1;
			}
			int fact = num*factorial(num-1);
			return fact;
		}

	}