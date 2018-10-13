// import java.util.Scanner;
// import java.util.Comparator;
import java.util.*;

class Stock {
	String name;
	float change;
	Stock(String name1, float change1) {
		this.name = name1;
		this.change = change1;
	}




	public float getchange() {
		return change;
	}



	public String toString(Stock list1) {
		return list1.name + " " + list1.change;
	}



	public Comparator<Stock> changeComparator = new Comparator<Stock>() {
		@ Override
		public int compare(Stock s1, Stock s2) {
			if (s1.change - s2.change != 0) {
				if (s1.change > s2.change) return 1;
				else return -1;
			} else
				return s1.name.compareTo(s2.name);
		}
	};

}












class Solution {
	public static void main(String[] args) {
		MaxPQ<Stock> pq = new MaxPQ<Stock>();
		Scanner scan = new Scanner(System.in);
		int noOfStacksperHour = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < noOfStacksperHour; i++) {
			String[] stock1 = scan.nextLine().split(",");
			Stock obj = new Stock(stock1[0], Float.parseFloat(stock1[1]));
			pq.insert(obj);
		}

		for (int i = 0; i < 5; i++) {
			Stock list = pq.delMax();
			System.out.println(list);
		}
		System.out.println();

	}
}