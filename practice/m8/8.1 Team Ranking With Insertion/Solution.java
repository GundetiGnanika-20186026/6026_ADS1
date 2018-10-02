//import java.util.Comparator;
import java.util.Scanner;
class Team {
	String teamname;
	int wins;
	int losses;
	int draws;
	Team() { }

	Team(String name, int wins1, int losses1, int draws1) {
		this.teamname = name;
		this.wins = wins1;
		this.losses = losses1;
		this.draws = draws1;
	}
}



// class insertion implements Comparable<Team> {
// 	public void sort(Comparable[] a, int size1) {
// 		int n = size1;
// 		for (int i = 0; i < n; i++) {
// 			int min = i;
// 			for (int j = i + 1; j < n; j++) {
// 				if (less(a[j], a[min])) {
// 					min = j;
// 				}
// 				exchange(a, i, min);
// 			}

// 		}
// 	}

// 	public boolean less(Comparable v, Comparable w) {

// 		return v.compareTo(w) < 0;
// 	}

// 	public void exchange(Comparable[] a, int i, int j) {
// 		Comparable swap = a[i];
// 		a[i] = a[j];
// 		a[j] = swap;

// 	}


// 	public void print(Team[] array1) {
// 		String str = "";
// 		int i;
// 		for ( i = 0; i < array1.length - 1; i++) {
// 			str += array1[i].teamname + ",";
// 		}
// 		str += array1[i];
// 		System.out.println(str);

// 	}
// }

class insertion {
	Team[] teamarray;
	int size;
	insertion() {
		Team[] teamarray = new Team[10];
		size = 0;

	}
	public void add(Team obj1) {
		teamarray[size++] = obj1;

	}

	public void exchange(int index1, int index2) {
		Team extra = new Team();
		extra = teamarray[index1];
		teamarray[index1] = teamarray[index2];
		teamarray[index2] = extra;
	}

	public void sort(Team[] a) {
		for (int i = 0; i < size; i++) {
			//int max = i;
			for (int j = i; j > 0; j++) {
				if (a[j].wins > a[j - 1].wins) {
					exchange(j, j - 1);
				}
				if (a[j].wins == a[j - 1].wins) {
					if (a[j].losses < a[j - 1].losses) {
						exchange(j, j - 1);
					}
					if (a[j].losses == a[j - 1].losses) {
						if (a[j].draws > a[j - 1].draws) {
							exchange(j, j - 1);
						}

					}
				}

			}
		}
	}

	public void print() {
		String str = "";
		int i;
		for ( i = 0; i < size - 1; i++) {
			str+=teamarray[i].teamname+", ";
        }
        str += teamarray[i].teamname;
        System.out.println(str);
	}
}





class Solution {

	public static void main(String[] args) {

		insertion object = new insertion();
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
		object.print();





	}
}