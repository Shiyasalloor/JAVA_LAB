import java.util.Scanner;
import java.io.IOException;

class Student {
    private String name;
    private int rollNo, totalMark;
    private int[] marks;

    public Student() {
        marks = new int[3];
    }

    public void read() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the name : ");
        name = sc.nextLine();
        System.out.print("Enter the roll no : ");
        rollNo = sc.nextInt();
        System.out.print("Enter 3 subject marks : ");
        for (int i = 0; i < 3; i++) {
            marks[i] = sc.nextInt();
        }
    }

    public void calculate() {
        totalMark = 0;
        for (int i = 0; i < 3; i++) {
            totalMark += marks[i];
        }
    }

    public int getTotalMark() {
        return totalMark;
    }

    public void display() {
        System.out.println("Name : " + name);
        System.out.println("Roll No : " + rollNo);
        System.out.print("Marks : ");
        for (int i = 0; i < 3; i++) {
            System.out.print(marks[i] + " ");
        }
        System.out.println("\nTotal Mark : " + totalMark);
    }
}

class StudentList {
    int count;
    Student[] students;

    public StudentList(int count) {
        this.count = count;
        students = new Student[count];
    }

    public void readList() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < count; i++) {
            students[i] = new Student();
            students[i].read();
            students[i].calculate();
        }
    }

    public void sort() {
        for (int i = 1; i < count; i++) {
            Student current = students[i];
            int k = i - 1;
            while (k >= 0 && current.getTotalMark() > students[k].getTotalMark()) {
                students[k + 1] = students[k];
                k--;
            }
            students[k + 1] = current;
        }
    }

    public void displayList() {
        for (int i = 0; i < count; i++) {
            students[i].display();
        }
    }
}

public class StudentMain {
    public static void main(String[] args) {
        StudentList slist = new StudentList(5);
        slist.readList();
        slist.sort();
        slist.displayList();
    }
}
