/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.employemain;

import java.util.Scanner;

/**
 *
 * @author shiya
 */

class Employe{
    static class Date{
        int day,month,year;
        public Date(int day,int month,int year){
            this.day = day;
            this.month = month;
            this.year = year;
        }
        
        @Override
        public String toString(){
            return day + "-" + month +"-" + year;
        }
        
    }
    String emp_id,emp_name;
    Date dob,doj;
    float salary;
    public Employe(String emp_id,String emp_name,Date dob,Date doj,float salary){
            this.emp_id = emp_id;
            this.emp_name = emp_name;
            this.dob = dob;
            this.doj = doj;
            this.salary = salary;    
    }
    
    @Override
    public String toString(){
        return "Employee ID: " + emp_id + ", Name: " + emp_name + ", DOB: " + dob + ", DOJ: " + doj + ", Salary: " + salary;
    }
    
    public float getSalary(){
        return salary;
    }
    
    public void printDetails() {
        System.out.println("Employee ID: " + emp_id);
        System.out.println("Employee Name: " + emp_name);
        System.out.println("Date of Birth: " + dob);
        System.out.println("Date of Joining: " + doj);
        System.out.println("Salary: " + salary);
        System.out.println();
    }
}


public class EmployeMain {
    static Scanner sc = new Scanner(System.in);
    public static Employe.Date getDate(){
        System.out.print("Enter day: ");
        int day = sc.nextInt();
        System.out.print("Enter month: ");
        int month = sc.nextInt();
        System.out.print("Enter year: ");
        int year = sc.nextInt();
        return new Employe.Date(day, month, year);
    }
    public static void main(String[] args) {
        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();
        Employe[] employees = new Employe[n];

        for(int i=0;i<n;i++){
            System.out.println("\nEnter details for Employee " + (i + 1) + ":");
            sc.nextLine();
            System.out.print("Employee ID: ");
            String emp_id = sc.nextLine();
            System.out.print("Employee Name: ");
            String emp_name = sc.nextLine();
            System.out.println("Date of Birth:");
            Employe.Date dob = getDate();
            System.out.println("Date of Joining:");
            Employe.Date doj = getDate();
            System.out.print("Salary: ");
            float salary = sc.nextFloat();
            employees[i] = new Employe(emp_id, emp_name, dob, doj, salary);
        }
        for(int i=1;i<n;i++){
            Employe current = employees[i];
            int k=i-1;
            while(k>=0 && current.getSalary()>employees[k].getSalary()){
                employees[k+1]=employees[k];
                k--;
            }
            employees[k+1]=current;
        }
        System.out.println("");
        System.out.println("Employees Details");
        System.out.println("");
        for(int i=0;i<n;i++){
            employees[i].printDetails();
        }
    }
}

