/**
 * Class for student.
 */
class Student implements Comparable<Student> {
    /**
     * name.
     */
    private String name;
    /**
     * marks1.
     */
    private int marks1;
    /**
     * marks2.
     */
    private int marks2;
    /**
     * marks3.
     */
    private int marks3;
    /**
     * markst.
     */
    private int tmarks;
    /**
     * resCat.
     */
    private String resCat;
    /**
     * day.
     */
    private int day;
    /**
     * month.
     */
    private int month;
    /**
     * year.
     */
    private int year;
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the marks 1.
     *
     * @return     The marks 1.
     */
    public int getMarks1() {
        return marks1;
    }
    /**
     * Gets the marks 2.
     *
     * @return     The marks 2.
     */
    public int getMarks2() {
        return marks2;
    }
    /**
     * Gets the marks 3.
     *
     * @return     The marks 3.
     */
    public int getMarks3() {
        return marks3;
    }
    /**
     * Gets the total.
     *
     * @return     The total.
     */
    public int getTotal() {
        return tmarks;
    }
    /**
     * Gets the resCat.
     *
     * @return     The resCat.
     */
    public String getresCat() {
        return resCat;
    }
    /**
     * Gets the day.
     *
     * @return     The day.
     */
    public int getDay() {
        return day;
    }
    /**
     * Gets the month.
     *
     * @return     The month.
     */
    public int getMonth() {
        return month;
    }
    /**
     * Gets the year.
     *
     * @return     The year.
     */
    public int getYear() {
        return year;
    }



    /**
     * Constructs the object.
     *
     * @param      n  The name
     * @param      dob   The dob
     * @param      m1    The m 1
     * @param      m2    The m 2
     * @param      m3    The m 3
     * @param      tm    The total
     * @param      r     { reservation }
     */
    Student(final String n,
            final String dob, final String m1,
            final String m2, final String m3,
            final String tm, final String r) {
        this.name = n;
        String[] d = dob.split("-");
        this.day = Integer.parseInt(d[0]);
        this.month = Integer.parseInt(d[1]);
        this.year = Integer.parseInt(d[2]);
        this.marks1 = Integer.parseInt(m1);
        this.marks2 = Integer.parseInt(m2);
        this.marks3 = Integer.parseInt(m3);
        this.tmarks = Integer.parseInt(tm);
        this.resCat = r;

    }
    /**
     * { this method will compare and returns 1 if greater
     *    -1 if less and 0 if equal }.
     *    its complexity is O(1).
     *
     * @param      other  The other
     *
     * @return     { integer ,either 1,-1,0 }
     */
    public int compareTo(final Student other) {
        if (this.getTotal() > other.getTotal()) {
            return 1;
        }
        if (this.getTotal() < other.getTotal()) {
            return -1;
        }
        if (this.getMarks3() > other.getMarks3()) {
            return 1;
        }
        if (this.getMarks3() < other.getMarks3()) {
            return -1;
        }
        if (this.getMarks2() > other.getMarks2()) {
            return 1;
        }
        if (this.getMarks2() < other.getMarks2()) {
            return -1;
        }
        if (this.getYear() > other.getYear()) {
            return 1;
        }
        if (this.getYear() < other.getYear()) {
            return -1;
        }
        if (this.getMonth() > other.getMonth()) {
            return 1;
        }
        if (this.getMonth() < other.getMonth()) {
            return -1;
        }
        if (this.getDay() < other.getDay()) {
            return 1;
        }
        if (this.getDay() > other.getDay()) {
            return -1;
        }
        return 0;
    }
    // /**
    //  * { function_description }.
    //  *
    //  * @param      other  The other
    //  *
    //  * @return     { description_of_the_return_value }
    //  */
    // public int compareAgain(final Student other) {
    //     if ((this.getresCat().equals("SC") || this.getresCat().equals("ST")
    //             || this.getresCat().equals("BC")
    //             && other.getresCat().equals("Open"))) {
    //         return 1;
    //     }
    //     if ((other.getresCat().equals("SC")
    //             || other.getresCat().equals("ST") || other.getresCat().equals("BC")
    //             && this.getresCat().equals("Open"))) {
    //         return -1;
    //     }

    //     return 0;
    // }
}
