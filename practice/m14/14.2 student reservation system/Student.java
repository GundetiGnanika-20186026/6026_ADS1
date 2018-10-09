import java.util.*;
public class Student {
	//Student Name, Date of birth, subject1 marks, subject2 marks, subject3 marks, Total marks, Reservation category
	private String studentName;
	private String dateOfBirth;
	private int sub1;
	private int sub2;
	private int sub3;
	private int total;
	private String res;
	private int year;
	private int month;
	private int day;

	public Student(String studentName1, String dateOfBirth1, int sub11, int sub21, int sub31, int total1, String res1) {
		this.studentName = studentName1;
		this.dateOfBirth = dateOfBirth1;
		this.sub1 = sub11;
		this.sub2 = sub21;
		this.sub3 = sub31;
		this.total = total1;
		this.res = res1;
		String[] dobarray = dateOfBirth.split("-");
		this.year = Integer.parseInt(dobarray[2]);
		this.month = Integer.parseInt(dobarray[1]);
		this.day = Integer.parseInt(dobarray[0]);




	}


	public String getres(){
		return res;
	}



	public static Comparator<Student> totalComparator = new Comparator<Student>() {
		@ Override
		public int compare(Student s1, Student s2) {
			if (s1.total - s2.total != 0)
				return  s1.total - s2.total;
			else if (s1.sub3 - s2.sub3 != 0)
				return s1.sub3 - s2.sub3;
			else if (s1.sub2 - s2.sub2 != 0)
				return s1.sub2 - s2.sub2;
			else if (s1.year - s2.year != 0)
				 return s1.year - s2.year;
			else if (s1.month - s2.month != 0)
				return s1.month - s2.month;
			else if (s1.day - s2.day != 0)
				return s2.day - s2.day;
			else return 0;
				//return s1.dateOfBirth.compareTo(s2.dateOfBirth);
		}
	};







	public String toString() {
		return this.studentName + "," + this.total + "," + this.res;
	}
}