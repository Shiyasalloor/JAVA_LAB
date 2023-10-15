/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rectanglemain;

import java.util.Scanner;

/**
 *
 * @author shiya
 */
class Rectangle{
    protected double length;
    protected double breadth;
    protected double area;
    
    public Rectangle(double length,double breadth){
        this.length = length;
        this.breadth = breadth;
        calc_Area();
    }
    public void calc_Area(){
        area = length * breadth;
    }
    public double get_Area(){
        return area;
    }
}

class Box extends Rectangle{
    private double height;
    private double volume;
    
    public Box(double length,double breadth,double height){
        super(length,breadth);
        this.height = height;
        calc_Volume();
    }
    public void calc_Volume(){
        volume = length * breadth * height;
    }
    public double get_Volume(){
        return volume;
    }
}

public class Rectanglemain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double length,breadth,height;
        System.out.println("Object of Rectangle Class");
        System.out.print("Enter the length : ");
        length=sc.nextDouble();
        System.out.print("Enter the breadth : ");
        breadth=sc.nextDouble();
        Rectangle rectangle=new Rectangle(length,breadth);
        System.out.println("Area of the Rectangle : " + rectangle.get_Area());
        System.out.println("***************************************************");
        
        System.out.println("Object of Box Class");
        System.out.print("Enter the length : ");
        length=sc.nextDouble();
        System.out.print("Enter the breadth : ");
        breadth=sc.nextDouble();
        System.out.print("Enter the height : ");
        height=sc.nextDouble();
        Box box=new Box(length,breadth,height);
        System.out.println("box area : " + box.get_Area());
        System.out.println("box volume : " + box.get_Volume());
    }
}
