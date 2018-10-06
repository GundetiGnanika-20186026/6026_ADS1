import java.util.*;
class Solution {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int qualified = Integer.parseInt(scan.nextLine());
		int vacancy = Integer.parseInt(scan.nextLine());
		int unreservedVacancy = Integer.parseInt(scan.nextLine());
		int bcVacancy = Integer.parseInt(scan.nextLine());
		int scVacacy = Integer.parseInt(scan.nextLine());
		int stVacancy = Integer.parseInt(scan.nextLine());
		List peopleobj = new List();

		while (scan.hasNext()) {
// Student Name, Date of birth, subject1 marks, subject2 marks, subject3 marks, Total marks, Reservation category
			String[] token = scan.nextLine().split(",");
			Student stuobj = new Student(token[0], token[1], Integer.parseInt(token[2]), Integer.parseInt(token[3]), Integer.parseInt(token[4]), Integer.parseInt(token[5]), token[6]);
			peopleobj.addStudent(stuobj);
		}
		Student[] temp = peopleobj.getArray();
		Insertion insertobj = new Insertion();
		insertobj.sort(temp, Student.totalComparator);

		for (int i = 0; i < peopleobj.getSize(); i++) {
			System.out.println(temp[i]);
		}






	}
}