/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentmain;

/**
 *
 * @author shiya
 */
import java.util.Scanner;


class Student{
    public String name;
    public int roll_no;
    public int marks[];
    public int total;
    
    Scanner sc=new Scanner(System.in); 
    
    public Student() {
        marks = new int[5];
    }
    
    public void set_data(){
        System.out.print("Enter student name : ");
        name=sc.nextLine();
        System.out.print("Enter the Roll no : ");
        roll_no=sc.nextInt();
        System.out.println("Enter the marks in 5 subjects");
        System.out.print("Subject 1 : ");
        marks[0]=sc.nextInt();
        System.out.print("Subject 2 : ");
        marks[1]=sc.nextInt();
        System.out.print("Subject 3 : ");
        marks[2]=sc.nextInt();
        System.out.print("Subject 4 : ");
        marks[3]=sc.nextInt();
        System.out.print("Subject 5 : ");
        marks[4]=sc.nextInt();    
    }
    
    public void calc_total(){
        total=marks[0]+marks[1]+marks[2]+marks[3]+marks[4];
    }
    
    public void display(){
        System.out.println("**************************************************");
        System.out.println("Student Name : "+name);
        System.out.println("Roll no : "+roll_no);
        System.out.println("Marks in 5 subjects");
        System.out.println("Subject 1 : "+marks[0]);
        System.out.println("Subject 1 : "+marks[1]);
        System.out.println("Subject 1 : "+marks[2]);
        System.out.println("Subject 1 : "+marks[3]);
        System.out.println("Subject 1 : "+marks[4]);
        System.out.println("Total Marks : "+total);
        System.out.println("**************************************************");
    }
}    
public class Studentmain{
    public static void main(String[] args) {
        Student st1 = new Student();
        Student st2 = new Student();
        st1.set_data();
        st1.calc_total();
        
        st2.set_data();
        st2.calc_total();
        
        if(st1.total>st2.total){
            st1.display();
            st2.display();
        }else{
            st2.display();
            st1.display();
        }
    }
}
