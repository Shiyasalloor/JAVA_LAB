/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.employeemain;

import java.util.Scanner;

/**
 *
 * @author shiya
 */
interface Salary{
    double calcSalary(double basicpay);
}

class Employee{
    String name;
    int code;
    double basicpay;
    
    public Employee(String name,int code,double basicpay){
        this.name=name;
        this.code=code;
        this.basicpay=basicpay;
    }
    public void printInfo(){
        System.out.println("Name of Employee : "+name);
        System.out.println("Code of Employee : "+code);
        System.out.println("Basicpay of Employee : "+basicpay+"$");
    }
}
class SalarySlip extends Employee implements Salary{
    public SalarySlip(String name,int code,double basicpay){
        super(name,code,basicpay);
    }
    @Override
    public double calcSalary(double basicpay){
        double deductions = 0.2 * basicpay;
        double allowances = 0.1 * basicpay;
        double netSalary = basicpay - deductions + allowances;
        return netSalary;
    }
    public void printSalarySlip(){
        System.out.println("\n*****Salary Slip*****");
        printInfo();
        double netSalary = calcSalary(basicpay);
        System.out.println("Net Salary : " + netSalary+"$");
    }
    
}


public class EmployeeMain {

    public static void main(String[] args) {
        String name;
        int code;
        double basicpay;
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee Name : ");
        name=sc.nextLine();
        System.out.print("Enter Employee code : ");
        code=sc.nextInt();
        System.out.print("Enter Basic pay : ");
        basicpay=sc.nextDouble();
        
        SalarySlip employee1 = new SalarySlip(name,code,basicpay);
        employee1.printSalarySlip();    
    }
}
