//import java.util.Comparator;
import java.util.Scanner;
class Team {
	String teamname;
	int wins;
	int losses;
	int draws;
	Team() { }

	Team(final String name, final int wins1, final int losses1, final int draws1) {
		this.teamname = name;
		this.wins = wins1;
		this.losses = losses1;
		this.draws = draws1;
	}

	// @Override

	// public int compareTo(){

	// }
}






////////////////////////////////////////////////////////////////////////

class Teamarray {
	Team[] teamarray;
	int size;
	Teamarray() {
		teamarray = new Team[50];
		size = 0;

	}
	public void add(Team obj1) {
		teamarray[size++] = obj1;

	}

	public void sendarray(){
		Insertionsort sortobj = new Insertionsort();
		sortobj.sort(teamarray, size);
	}



	public void print() {

		String str = "";
		int i;
		for ( i = 0; i < size - 1; i++) {
			str += teamarray[i].teamname + ",";
		}
		str += teamarray[i].teamname;
		System.out.println(str);
	}
}

/////////////////////////////////////////////////////////////////////////////
class Insertionsort {
	Insertionsort() {

	}

	public void exchange(final Team[] teamarray, final int index1, final int index2) {
		Team extra = new Team();
		extra = teamarray[index1];
		teamarray[index1] = teamarray[index2];
		teamarray[index2] = extra;
	}

	public void sort(Team[] a,int size1) {
		for (int i = 0; i < size1; i++) {
			//int max = i;
			for (int j = i; j > 0; j--) {
				if (a[j].wins > a[j - 1].wins) {
					exchange(a, j, j - 1);
				}
				if (a[j].wins == a[j - 1].wins) {
					if (a[j].losses < a[j - 1].losses) {
						exchange(a, j, j - 1);
					}
					if (a[j].losses == a[j - 1].losses) {
						if (a[j].draws > a[j - 1].draws) {
							exchange(a, j, j - 1);
						}

					}
				}

			}
		}
	}

}

//////////////////////////////////////////////////////////////////////

class Solution {

	public static void main(final String[] args) {

		Teamarray object = new Teamarray();
		Scanner scan = new Scanner(System.in);
		// int size = 0;
		// int i = 0;
		while (scan.hasNext()) {
			String[] token = scan.nextLine().split(",");
			Team obj = new Team(token[0], Integer.parseInt(token[1]), Integer.parseInt(token[2]), Integer.parseInt(token[3]));
			object.add(obj);
			//teamarray[size] = obj;
			//size++;
        }
        object.sendarray();


		object.print();





	}
}