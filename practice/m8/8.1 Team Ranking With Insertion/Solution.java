//import java.util.Comparator;

/**
 * Author:Gnanika.
 */
import java.util.Scanner;
/**
 * Class for team which contains all the data such as
 *  teamname,wins,losses and draws.
 */
class Team {
	/**
	 * { variable for teamname }.
	 */
	private String teamname;
	/**
	 * { variable to store wins }.
	 */
	private int wins;
	/**
	 * { variable to store losses }.
	 */
	private int losses;
	/**
	 * { variable to store draws }.
	 */
	private int draws;
	/**
	 * empty Constructor.
	 */
	Team() { }
	/**
	 * parameterised constructor.
	 *
	 * @param      name     The name
	 * @param      wins1    The wins 1
	 * @param      losses1  The losses 1
	 * @param      draws1   The draws 1
	 */
	Team(final String name, final int wins1, final int losses1, final int draws1) {
		this.teamname = name;
		this.wins = wins1;
		this.losses = losses1;
		this.draws = draws1;
	}

	/**
	 * { method for accessing teamname }.
	 *
	 * @return     { the team name }
	 */
	public String getteamname() {
		return teamname;
	}

	/**
	 * { this method is to get wins }.
	 *
	 * @return     { returns the no.of wins }
	 */

	public int getwins() {
		return wins;

	}

	/**
	 * { this method is to access the losses in specific team }.
	 *
	 * @return     { returns the losses values }
	 */

	public int getlosses() {
		return losses;

	}

	/**
	 * { this method is to access the draws }.
	 *
	 * @return     { returns the draws }
	 */

	public int getdraws() {
		return draws;

	}




	// //@Override

	// public int compareTo(Team team1) {
	// 	return this.wins - team1.wins;


	// }
}






////////////////////////////////////////////////////////////////////////

/**
 * Class for teamarray this array contains all team objects.
 */
class Teamarray {
	private Team[] teamarray;
	private int size;
	/**
	 * Constructor for team array.
	 */
	Teamarray() {
		final int fifty = 50;
		teamarray = new Team[fifty];
		size = 0;

	}


	/**
 	* { this method is to return the team array }.
 	*
 	* @return     { the team array }
 	*/
    public Team[] getteamarray(){
    	return teamarray;
    }


    /**
     * { this method will return the size }.
     *
     * @return     { this method will return the size }
     */
    public int getsize(){
    	return size;
    }






	/**
	 * { this method adds the team objects into team array }.
	 * its complexity is O(1).
	 *
	 * @param      obj1  The object 1
	 */
	public void add(final Team obj1) {
		teamarray[size++] = obj1;

	}

	/**
	 * { this method is used to send the array
	 *  to the insertion sort class }.
	 * its complexity is O(1)
	 */

	public void sendarray() {
		Insertionsort sortobj = new Insertionsort();
		sortobj.sort(teamarray, size);
	}


	/**
	 * { This method is used to print the teamarray which is sorted }
	 * its complexity is O(n) as it itterates through the entire array.
	 */
	public void print() {

		String str = "";
		int i;
		for (i = 0; i < size - 1; i++) {
			str += teamarray[i].getteamname() + ",";
		}
		str += teamarray[i].getteamname();
		System.out.println(str);
	}
}

/////////////////////////////////////////////////////////////////////////////

/**
 * Class for insertionsort which contains sort method for sorting.
 */
class Insertionsort {
	/**
	 * Constructor for insertion sort.
	 */
	Insertionsort() {

	}
	/**
	 * { will exchange the objects in the team array}.
	 * its complexity is O(1).
	 *
	 * @param      teamarray  The teamarray
	 * @param      index1     The index 1
	 * @param      index2     The index 2
	 */
	public void exchange(final Team[] teamarray,
	                     final int index1, final int index2) {
		Team extra = new Team();
		extra = teamarray[index1];
		teamarray[index1] = teamarray[index2];
		teamarray[index2] = extra;
	}

	/**
	 * { this method will perform the insertion sort  }.
	 * its complexity is O(n^2)
	 *
	 * @param      a      { this is the teamarray }
	 * @param      size1  The size 1
	 */

	public void sort(final Team[] a, final int size1) {

		for (int i = 0; i < size1; i++) {
			//int max = i;
			for (int j = i; j > 0; j--) {
				if (a[j].getwins() > a[j - 1].getwins()) {
					exchange(a, j, j - 1);
				}
				if (a[j].getwins() == a[j - 1].getwins()) {
					if (a[j].getlosses() < a[j - 1].getlosses()) {
						exchange(a, j, j - 1);
					}
					if (a[j].getlosses() == a[j - 1].getlosses()) {
						if (a[j].getdraws() > a[j - 1].getdraws()) {
							exchange(a, j, j - 1);
						}

					}
				}

			}
		}
	}

}

//////////////////////////////////////////////////////////////////////

/**
 * Class for solution which contains main method.
 */
final class Solution {
	/**
	 * Constructor for solution.
	 */
	private Solution() {

	}
	/**
	 * { this is the main method to read the user input}.
	 *
	 * @param      args  The arguments
	 */

	public static void main(final String[] args) {

		Teamarray object = new Teamarray();
		Scanner scan = new Scanner(System.in);
		// int size = 0;
		// int i = 0;
		while (scan.hasNext()) {
			String[] token = scan.nextLine().split(",");
			Team obj = new Team(token[0], Integer.parseInt(token[1]),
			                    Integer.parseInt(token[1 + 1]),
			                     Integer.parseInt(token[2 + 1]));
			object.add(obj);
			//teamarray[size] = obj;
			//size++;
		}
		object.sendarray();


		object.print();





	}
}