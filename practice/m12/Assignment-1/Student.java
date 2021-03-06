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

	public Student(String studentName1, String dateOfBirth1, int sub11, int sub21, int sub31, int total1, String res1) {
		this.studentName = studentName1;
		this.dateOfBirth = dateOfBirth1;
		this.sub1 = sub11;
		this.sub2 = sub21;
		this.sub3 = sub31;
		this.total = total1;
		this.res = res1;




	}


	// @Override
	// 	public void compareTo(Student s1, Student s2) {
	// 		if (s1.total - s2.total < 0)  return -1;
	// 		if (s1.total - s2.total > 0)  return 1;
	// 		if (s1.sub3 - s2.sub3 < 0)  return -1;
	// 		if (s1.sub3 - s2.sub3 > 0)  return 1;
	// 		if (s1.sub2 - s2.sub2 < 0)  return -1;
	// 		if (s1.sub2 - s2.sub2 > 0)  return 1;
	// 		else
	// 			return 0;


	// // 		return s1.total - s2.total;
	// // 		// else if (s1.sub3-s2.sub3 != 0)
	// // 		// 	return s1.sub3-s2.sub3;
	// // 		// else if (s1.sub2-s2.sub2 != 0)
	// // 		// 	return s1.sub2-s2.sub2;
	// // 		// else
	// // 		// 	return s1.dateOfBirth.compareTo(s2.dateOfBirth);

	// 	}
	public static Comparator<Student> totalComparator = new Comparator<Student>() {
		@ Override
		public int compare(Student s1, Student s2) {
			if (s1.total - s2.total != 0)
				return  s1.total - s2.total;
			else if (s1.sub3 - s2.sub3 != 0)
				return s1.sub3 - s2.sub3;
			else if (s1.sub2 - s2.sub2 != 0)
				return s1.sub2 - s2.sub2;
			else
				return s1.dateOfBirth.compareTo(s2.dateOfBirth);
		}
	};

	// static Comparator<Student> sub3Comparator = new Comparator<Student>() {
	// 	public int compare(Student s1, Student s2) {
	// 		return s1.sub3 - s2.sub3;
	// 	}
	// };

	// static Comparator<Student> sub2Comparator = new Comparator<Student>() {
	// 	public int compare(Student s1, Student s2) {
	// 		return s1.sub2 - s2.sub2;
	// 	}
	// };

	// static Comparator<Student> birthComparator = new Comparator<Student>() {
	// 	public int compare(Student s1, Student s2) {
	// 		return s1.dateOfBirth.compareTo(s2.dateOfBirth);
	// 	}
	// };






	public String toString() {
		return this.studentName + "," + this.total + "," + this.res;
	}
}