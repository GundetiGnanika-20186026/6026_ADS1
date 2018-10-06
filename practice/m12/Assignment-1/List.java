import java.util.*;
class List{
 	Student[] people;
	int size;
 	public List(){
		people = new Student[50];
		size = 0;
	}

	// public void resize(){
 //        people = Arrays.copyOf(people,2*size);
	// }

 	public void addStudent(Student obj){
		people[size++] = obj;
	}
 	public Student[] getArray(){
		return people;
	}

	public int getSize(){
		return size;
	}
}