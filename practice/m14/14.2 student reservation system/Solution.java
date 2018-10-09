import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
/**
 * Class for solution.
 */
public final class Solution {

	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * students array List.
	 */
	private static ArrayList<Student> students = new ArrayList<>();
	/**
	 *  meritlist array list.
	 */
	private static ArrayList<Student> vacanciesList = new ArrayList<>();

	/**
	 * main to read input.
	 * Time Complexity : O(N).
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int numoflines = Integer.parseInt(scan.nextLine());
		int vacancies = Integer.parseInt(scan.nextLine());
		int unreserved = Integer.parseInt(scan.nextLine());
		int bc = Integer.parseInt(scan.nextLine());
		int sc = Integer.parseInt(scan.nextLine());
		int st = Integer.parseInt(scan.nextLine());

		while (scan.hasNext()) {
			String[] tokens = scan.nextLine().split(",");
			//System.out.println(Arrays.toString(tokens));
			Student s = new Student(tokens[0], tokens[1],
			                        tokens[2], tokens[3], tokens[4],
			                        tokens[5], tokens[6]);
			students.add(s);
		}
		selectionSort();

		for (int i = 0; i < students.size(); i++) {
			System.out.println(students.get(i).getName() + ","
			                   + students.get(i).getTotal() + ","
			                   + students.get(i).getresCat());
		}
		System.out.println();

		fillVacancies(vacancies, unreserved, bc, sc, st);

	}
	/**
	 * fill vacancies in the given order.
	 *
	 * @param      vacancies     The vacancies
	 * @param      unreserved      The unreserved seats
	 * @param      bc         { bc reservation seats }
	 * @param      sc         The sc reservation seats
	 * @param      st         { st reservation seats }
	 */
	public static void fillVacancies(int vacancies,
	                                 int unreserved, int bc, int sc, int st) {

		int unreserved1 = 0;
		int bc1 = 0;
		int sc1 = 0;
		int st1 = 0;
		int vacancies1 = 0;
		// add unreserved candidates

		for (int i = 0; i < students.size(); i++) {
			if (unreserved1 == unreserved) break;
			vacanciesList.add(students.get(i));
			unreserved1++;
			vacancies1++;

		}
		//add bc
		for (int i = 0; i < students.size(); i++) {
			if (bc1 == bc) break;
			if (students.get(i).getresCat().equals("BC")) {
				if (!vacanciesList.contains(students.get(i))) {
					vacanciesList.add(students.get(i));
					bc1++;
					vacancies1++;
				}

			}

		}
		// add sc
		for (int i = 0; i < students.size(); i++) {
			if (sc1 == sc) break;
			if (students.get(i).getresCat().equals("SC")) {
				if (!vacanciesList.contains(students.get(i))) {

					vacanciesList.add(students.get(i));
					sc1++;
					vacancies1++;
				}
			}

		}
		//add st
		for (int i = 0; i < students.size(); i++) {
			if (st1 == st) break;
			if (students.get(i).getresCat().equals("ST")) {
				if (!vacanciesList.contains(students.get(i))) {
					vacanciesList.add(students.get(i));
					st1++;
					vacancies1++;
				}
			}

		}

		for (int i = 0; i < students.size(); i++) {
			if (vacancies1 == vacancies) break;
			if (!vacanciesList.contains(students.get(i))) {
				vacanciesList.add(students.get(i));
				vacancies1++;
			}

		}

		sortAgain();

		for (int i = 0; i < vacanciesList.size(); i++) {
			if ( i == vacancies) break;
			System.out.println(vacanciesList.get(i).getName()
			                   + "," + vacanciesList.get(i).getTotal()
			                   + "," + vacanciesList.get(i).getresCat());
		}


	}
	/**
	 * sort again.
	 * its complexity is O(n^2)
	 */
	public static void sortAgain() {
		for (int i = vacanciesList.size() - 1; i >= 0; i--) {
			Student max = vacanciesList.get(i);
			int index = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (max.compareTo(vacanciesList.get(j)) == 1) {
					max = vacanciesList.get(j);
					index = j;
				}
			}
			Student temp = vacanciesList.get(i);
			vacanciesList.set(i, max);
			if (index != -1) {
				vacanciesList.set(index, temp);
			}
		}
	}
	/**
	 * selction sort
	 * its complexity is O(n^2)
	 */
	public static void selectionSort() {
		for (int i = students.size() - 1; i >= 0; i--) {
			Student max = students.get(i);
			int index = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (max.compareTo(students.get(j)) == 1) {
					max = students.get(j);
					index = j;
				}
			}
			Student temp = students.get(i);
			students.set(i, max);
			if (index != -1) {
				students.set(index, temp);
			}
		}
	}

}
