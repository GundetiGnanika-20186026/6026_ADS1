import java.util.Scanner;
/**
 * class for solution which takes the input from the user.
 */
final class Solution {
	/**
	 * constructor for solution class.
	 */
	private Solution() { }
	/**
	 * main method.
	 * @param args value
	 * Time complexity is O(N) where the while loop iterates for n inputs.
	 */
	public static void main(final String[] args) {
		Merge obj = new Merge();
		Scanner s = new Scanner(System.in);
		final int len = 50;
		String[] tokens = new String[len];
		while (s.hasNextLine()) {
			tokens = s.nextLine().split(",");
			obj.sort(tokens);
			System.out.println(obj.show(tokens));
			System.out.println();
		}
	}
}
