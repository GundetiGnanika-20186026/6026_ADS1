import java.util.Scanner;
/**
 * Class for solution.
 */
class Solution {
	/**
	 * main method.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		System.out.println(star(str));
		//System.out.println(str.substring(0,1));
	}
    /**
     * { adding * if same elements}.
     *
     * @param      str   The string
     *
     * @return     { string with inserted stars }.
     */
	public static String star(String str) {
		String string = "";
		int len = str.length();
		if (str.length() <= 1) {
			return str;
		}
		if (str.substring(0, 1).equals(str.substring(1, 2))) {
			return str.substring(0, 1) + "*" + star(str.substring(1));
		}
		string = str.charAt(0) + star(str.substring(1));
		return string;
    }

}