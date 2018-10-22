import java.util.Scanner;
//import java.util.Comparator;
//import java.util.*;
/**
 * Class for stock.
 */
class Stock implements Comparable<Stock> {
	private String name;
	private float change;
	Stock() {

	}
    Stock(String name1, float change1) {
		this.name = name1;
		this.change = change1;
	}

	public float getchange() {
		return change;
	}



	public String toString(Stock list1) {
		// System.out.println("entered into toString");
		return list1.name + " " + list1.change;
	}



	// public Comparator<Stock> changeComparator = new Comparator<Stock>() {
	// 	@ Override
	// 	public int compare(Stock s1, Stock s2) {
	// 		//System.out.println("entered into comparator");
	// 		if (s1.change - s2.change != 0) {
	// 			if (s1.change > s2.change) return 1;
	// 			else return -1;
	// 		} else
	// 			return s1.name.compareTo(s2.name);
	// 	}
	// };

	public int compareTo(Stock that){


	// 	if (this.change - that.change != 0) {
	// 			if (this.change > that.change) return 1;
	// 			else return -1;
	// 		} else
	// 			return this.name.compareTo(that.name);

	// }

		if(this.change > that.change){
			return 1;
		}
		if(this.change < that.change) {
			return -1;
		}
		if(this.change == that.change) {
			if (this.name.compareTo(that.name) > 0)
			     return 1;
			if (this.name.compareTo(that.name) < 0)
			     return -1;
		}
		return 0;

}
}


class Solution {
	public static void main(String[] args) {
		// MaxPQ<Stock> pqmax = new MaxPQ<Stock>();
		// MinPQ<Stock> pqmin = new MinPQ<Stock>();
		Stock mainobj = new Stock();
		Scanner scan = new Scanner(System.in);
		int noOfStacksperHour = Integer.parseInt(scan.nextLine());
		for(int j=0;j<6;j++) {
			MaxPQ<Stock> pqmax = new MaxPQ<Stock>();
		    MinPQ<Stock> pqmin = new MinPQ<Stock>();
		for (int i = 0; i < noOfStacksperHour; i++) {
			String[] stock1 = scan.nextLine().split(",");
			Stock obj = new Stock(stock1[0], Float.parseFloat(stock1[1]));
			pqmax.insert(obj);
			pqmin.insert(obj);

		}


		for (int i = 0; i < 5; i++) {
			Stock list = pqmax.delMax();
			// System.out.println("entered println");
			System.out.println(mainobj.toString(list));
		}
		System.out.println();

		for (int i = 0; i < 5; i++) {
			Stock list = pqmin.delMin();
			System.out.println(mainobj.toString(list));
		}
        System.out.println();

	}
  }
}
