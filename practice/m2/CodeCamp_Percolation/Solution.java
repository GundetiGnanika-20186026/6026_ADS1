/**
 * Author:Gnanika.
 */
import java.util.Scanner;
/**
 * Class for percolation.
 */
class Percolation {
    /**
     * two dimensional matrix declaration for forming a grid.
     */
    private boolean[][] grid;
    /**
     * object for weighted quick union class.
     */
    private WeightedQuickUnionUF unionobj;
    /**
     * variable to keep track of total no. of blocks that are opened.
     */
    private int openblocks;
    /**
     * keeping track of row size.
     */
    private int size;
    /**
     * virtual top node.
     */
    private int virtualtop;
    /**
     * virtual bottom node.
     */
    private int virtualbottom;
    //int[] onedim;

    /**
     * Constructer of percolation class.
     *
     * @param      gridsize  The gridsize
     */
     Percolation(final int gridsize) {
     // create n-by-n grid, with all sites blocked
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
        //  onedim[i] = i;

        //}

    }

    /**
     * converts the blocked boxes one to opened blocks.
     *
     * @param      row   The row number
     * @param      col   The col number
     */
    public void open(final int row, final int col) {
     // open site (row, col) if it is not open already
        if (grid[row][col]) {
            return;
        }
        grid[row][col] = true;
        openblocks = openblocks + 1;

        //checking wether the top block is opened and
        // then connects the present and the open block present.
    if (row - 1 >= 0 && isOpen(row - 1, col)) {
        unionobj.union(size * row + col, size * (row - 1) + col);
    }

        //checking wether the bottom block is opened and
        // then connects the present and the open block present.
    if (row + 1 < size && isOpen(row + 1, col)) {
        unionobj.union(size * row + col, size * (row + 1) + col);
    }

        //checking wether the left block is opened and
        // then connects the present and the open block present.

    if (col - 1 >= 0 && isOpen(row, col - 1)) {
        unionobj.union(size * row + col, size * row + (col - 1));
    }

        //checking wether the right block is opened and
        // then connects the present and the open block present.

    if (col + 1 < size && isOpen(row, col + 1)) {
        unionobj.union(size * row + col, size * row + (col + 1));
    }

        //connecting the zero row to top virtual node.
    if (row == 0) {
        unionobj.union(size * row + col, virtualtop);
    }

        //connecting the last row to bottom virtual node.
    if (row == size - 1) {
        unionobj.union(size * row + col, virtualbottom);
      }
    }

    /**
     * Determines wether the block is open or blocked.
     *
     * @param      row   The row number
     * @param      col   The col  number.
     *
     * @return     True if open, False otherwise.
     */
    public boolean isOpen(final int row, final int col) {
    // is site (row, col) open?
        if (grid[row][col]) {
            return true;
        }
        return false;
    }


    // public void connecting(int n) {
    //  for (int i = 0; i < n; i++) {
    //      for (int j = 0; j < n; j++) {
    //          if (isOpen(i, j)) {
    //              if (i < n - 1 && j < n - 1) {
    //                  if (isOpen(i, j + 1)) {
    //              union(i * n + j, i * n + j + 1);
    //                  }
    //                  if (isOpen(i + 1, j)) {
    //              union(i * n + j, (i + 1) * n + j);

    //                  }
    //              }
    //          }
    //      }
    //  }
    // }

    /**
     * method to check wether the path is present or not.
     *
     * @return     { true if path present and false if not present}
     */
    public boolean percolate() {
        return unionobj.connected(virtualtop, virtualbottom);

    }
}

// You can implement the above API to solve the problem

/**
 * Class for solution(contains main method).
 */
final class Solution {
    /**
     * Constructor for solution.
     */
    private Solution() {

    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {

        Scanner scn = new Scanner(System.in);
        int order = Integer.parseInt(scn.nextLine());
        Percolation obj = new Percolation(order);
        while (scn.hasNext()) {
            String[] openvalues = scn.nextLine().split(" ");
           obj.open((Integer.parseInt(openvalues[0])) - 1,
             (Integer.parseInt(openvalues[1])) - 1);
        }
        System.out.println(obj.percolate());


    }
}

