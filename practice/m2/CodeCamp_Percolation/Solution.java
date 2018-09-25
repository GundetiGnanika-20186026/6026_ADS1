import java.util.Scanner;

class Percolation {
	private boolean[][] grid;
	private WeightedQuickUnionUF unionobj;
	private int openblocks;
	private int size;
	private int virtualtop;
	private int virtualbottom;
	//int[] onedim;
	public Percolation(int gridsize) { // create n-by-n grid, with all sites blocked
		grid = new boolean[gridsize][gridsize];
		unionobj = new WeightedQuickUnionUF(gridsize * gridsize + 2);
		openblocks = 0;
		size = gridsize;
		virtualtop = gridsize * gridsize;
		virtualbottom = virtualtop + 1;

		// onedim = new int[(n * n) + 2];
		// onedim[onedim.length-1] = 28;
		// onedim[onedim.length-2] = 27;
		// for (int i = 0; i < n * n; i++) {
		// 	onedim[i] = i;

		//}

	}

	public void open(int row, int col) { // open site (row, col) if it is not open already
		if (grid[row][col] == true) {
			return;
		}
		grid[row][col] = true;
		openblocks = openblocks + 1;

		//checking top
		if (row - 1 >= 0 && isOpen(row - 1, col) == true) {
			unionobj.union(size * row + col, size * (row - 1) + col);
		}

		//checking bottom
		if (row + 1 < size && isOpen(row + 1, col) == true) {
			unionobj.union(size * row + col, size * (row + 1) + col);
		}

		//checking left

		if (col - 1 >= 0 && isOpen(row, col - 1) == true) {
			unionobj.union(size * row + col, size * row + (col - 1));
		}

		//checking right

		if (col + 1 < size && isOpen(row, col + 1) == true) {
			unionobj.union(size * row + col, size * row + (col + 1));
		}

		//top virtual node
		if (row == 0) {
			unionobj.union(size * row + col, virtualtop);
		}

		//bottom virtual node
		if (row == size - 1) {
			unionobj.union(size * row + col, virtualbottom);
		}









	}

	public boolean isOpen(int row, int col) { // is site (row, col) open?
		if (grid[row][col] == true) {
			return true;
		}
		return false;
	}


	// public void connecting(int n) {
	// 	for (int i = 0; i < n; i++) {
	// 		for (int j = 0; j < n; j++) {
	// 			if (isOpen(i, j)) {
	// 				if (i < n - 1 && j < n - 1) {
	// 					if (isOpen(i, j + 1)) {
	// 						union(i * n + j, i * n + j + 1);
	// 					}
	// 					if (isOpen(i + 1, j)) {
	// 						union(i * n + j, (i + 1) * n + j);

	// 					}
	// 				}
	// 			}
	// 		}
	// 	}
	// }

	public boolean percolate() {
		return unionobj.connected(virtualtop, virtualbottom);

	}
}

// You can implement the above API to solve the problem
class Solution {
	Solution() {

	}
	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int order = Integer.parseInt(scn.nextLine());
		Percolation obj = new Percolation(order);
		while (scn.hasNext()) {
			String[] openvalues = scn.nextLine().split(" ");
			obj.open((Integer.parseInt(openvalues[0])) - 1, (Integer.parseInt(openvalues[1])) - 1);
		}
		System.out.println(obj.percolate());


	}
}

