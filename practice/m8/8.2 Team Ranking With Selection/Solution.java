/**
 * Author:Gnanika.
 */
import java.util.Scanner;
/**
 * Class for team which contains all the data such as
 *  teamname,wins,losses and draws.
 */
class Team implements Comparable<Team> {
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
    Team(final String name, final int wins1,
         final int losses1, final int draws1) {
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




    @Override
    /**
     * { this method is used to compare }.
     * this method has a complexity O(1).
     *
     * @param      team1  The team object
     *
     * @return     { return 1 if greater,
     * 0 if equal,-1 if less }
     */
    public int compareTo(final Team team1) {
        if (this.wins > team1.wins) {
            return 1;
        }
        if (this.wins < team1.wins) {
            return -1;
        }

        if (this.losses > team1.losses) {
            return -1;
        }
        if (this.losses < team1.losses) {
            return 1;
        }
        if (this.draws > team1.draws) {
            return 1;
        }
        if (this.draws < team1.draws) {
            return -1;
        }
        return 0;


    }
}






////////////////////////////////////////////////////////////////////////

/**
 * Class for Teamarray this array contains all team objects.
 */
class Teamarray {
    /**
     * variable Teamarray for teamobjects storing.
     */
    private Team[] Teamarray;
    /**
     * variable for keeping track of size.
     */
    private int size;
    /**
     * Constructor for team array.
     */
    Teamarray() {
        final int fifty = 50;
        Teamarray = new Team[fifty];
        size = 0;

    }


    /**
    * { this method is to return the team array }.
    *
    * @return     { the team array }
    */
    public Team[] getTeamArray() {
        return Teamarray;
    }


    /**
     * { this method will return the size }.
     *
     * @return     { this method will return the size }
     */
    public int getSize() {
        return size;
    }






    /**
     * { this method adds the team objects into team array }.
     * its complexity is O(1).
     *
     * @param      obj1  The object 1
     */
    public void add(final Team obj1) {
        Teamarray[size++] = obj1;

    }

    /**
     * { this method is used to send the array
     *  to the insertion sort class }.
     * its complexity is O(1)
     */

    public void sendArray() {
        Selectionsort sortobj = new Selectionsort();
        sortobj.sort(Teamarray, size);
    }


    /**
     * { This method is used to print the Teamarray which is sorted }
     * its complexity is O(n) as it itterates through the entire array.
     */
    public void print() {

        String str = "";
        int i;
        for (i = 0; i < size - 1; i++) {
            str += Teamarray[i].getteamname() + ",";
        }
        str += Teamarray[i].getteamname();
        System.out.println(str);
    }
}

/////////////////////////////////////////////////////////////////////////////

/**
 * Class for Selectionsort which contains sort method for sorting.
 */
class Selectionsort {
    /**
     * Constructor for selection sort.
     */
    Selectionsort() {

    }
    /**
     * { will exchange the objects in the team array}.
     * its complexity is O(1).
     *
     * @param      Teamarray  The Teamarray
     * @param      index1     The index 1
     * @param      index2     The index 2
     */
    public void exchange(final Team[] Teamarray,
                         final int index1, final int index2) {
        Team extra = new Team();
        extra = Teamarray[index1];
        Teamarray[index1] = Teamarray[index2];
        Teamarray[index2] = extra;
    }

    /**
     * { this method will perform the insertion sort  }.
     * its complexity is O(n^2) as it has a nested for loops
     * which is iterating n times.
     *
     * @param      a      { this is the Teamarray }
     * @param      size1  The size 1
     */

    public void sort(final Team[] a, final int size1) {

        for (int i = 0; i < size1; i++) {
            int maximum = i;
            for (int j = i + 1; j < size1; j++) {
                if (a[j].compareTo(a[i]) == 1) {
                //a[j].getwins() > a[i].getwins()
                    maximum = j;
                    exchange(a, i, maximum);
                } else if (a[j].compareTo(a[i]) == 0) {
                //a[j].getwins() == a[i].getwins()
                    if (a[j].compareTo(a[i]) == 1) {
                    //a[j].getlosses() < a[i].getlosses()
                        maximum = j;
                        exchange(a, i, maximum);
                    } else if (a[j].compareTo(a[i]) == 0) {
                    //a[j].getlosses() == a[i].getlosses()
                        if (a[j].compareTo(a[i]) == 1) {
                        //a[j].getdraws() > a[i].getdraws()
                            maximum = j;
                            exchange(a, i, maximum);
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

        while (scan.hasNext()) {
            String[] token = scan.nextLine().split(",");
            Team obj = new Team(token[0], Integer.parseInt(token[1]),
                                Integer.parseInt(token[1 + 1]),
                                Integer.parseInt(token[2 + 1]));
            object.add(obj);

        }
        object.sendArray();


        object.print();





    }
}
