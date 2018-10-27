// class List {
//     Student[] array;
//     int size;
//     List() {
//         array = new array[50];
//         size = 0;

//     }

//     public void put(Student obj) {
//         array[size++] = obj;
//     }

//     public void get(String rollno, int Student) {
//         if (Student == 1) {
//             for (int i = 0; i < size; i++) {


//             }

//         }
//     }
// }
import java.util.Scanner;
/**
 * Class for student.
 */

class Student {
    // Stringrollno;
    String name;
    Double marks;
    Student() {

    }
    Student(final String name1, final  Double marks1) {
        // rollno = roll;
        name = name1;
        marks = marks1;
    }

    // public String getName(){
    //     return name;
    // }

    // public Double getMarks(){
    //     return marks;
    // }

    public String toString(final Student obj) {
        System.out.println("entered...");

        //System.out.println(obj.name);
        return obj.name;

        // if(num == 1) {
        //     System.out.println(obj.name);
        // }
        // if(num == 2) {
        //     System.out.println(obj.marks);
        // }
    }

}






/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */

    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        LinearProbingHashST obj = new LinearProbingHashST();
        Student seperate = new Student();
        for (int i = 0; i < num; i++) {
            String[] student = scan.nextLine().split(",");
            Student object = new Student(student[1], Double.parseDouble(student[2]));
            obj.put(student[0], object);

        }
        int cmd = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < cmd; i++) {
            String[] command = scan.nextLine().split(" ");
            switch (command[0]) {
            case "get" :
                // seperate.toString(obj.get(command[1]),Integer.parseInt(command[2]));
                // if(Integer.parseInt(command[2]) == 1)
                // System.out.println((obj.get(command[1])).getName());
                // if(Integer.parseInt(command[2]) == 2)
                // System.out.println((obj.get(command[1])).getMarks());
                System.out.println(obj.get(command[1]));
                break;
            }
        }

    }
}