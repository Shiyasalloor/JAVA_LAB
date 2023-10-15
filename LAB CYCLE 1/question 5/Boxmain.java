/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.boxmain;

/**
 *
 * @author shiya
 */
import java.util.Scanner;

class box{
    private int length;
    private int breadth;
    private int height;
    private int area;
    private float volume;
    
    public box(int a){
        this.length = a;
        this.breadth = a;
        this.height = a;
        calc_Area();
        calc_Volume();    
    }
    public box(int a, int b){
        this.length=a;
        this.breadth=a;
        this.height=b;
        calc_Area();
        calc_Volume();
    }
    public box(int a, int b,int c){
        this.length=a;
        this.breadth=b;
        this.height=c;
        calc_Area();
        calc_Volume();
    }
    private void calc_Area(){
        area = 2 * (length * breadth + breadth * height + height * length);
    }
    private void calc_Volume(){
        volume = length * breadth * height;
    }
    public int get_Area(){
        return area;
    }
    public double get_Volume(){
        return volume;
    }
}

public class Boxmain {

    public static void main(String[] args) {
        int a,b,c;
        Scanner sc = new Scanner(System.in);
        System.out.println("**** SHAPE CUBE ****");
        System.out.print("Enter the value for the side : ");
        a = sc.nextInt();
        box cube = new box(a);
        System.out.println("Area of the cube : " + cube.get_Area());
        System.out.println("Volume of the cube : " + cube.get_Volume());
        System.out.println("*****************************************");
        
        System.out.println("**** SHAPE SQUARE PRISM ****");
        System.out.print("Enter the value for the sides : ");
        a = sc.nextInt();
        System.out.print("Enter the value of the height : ");
        b = sc.nextInt();
        box square = new box(a,b);
        System.out.println("Area of the Square prism : " + square.get_Area());
        System.out.println("Volume of the Square prism : " + square.get_Volume());
        System.out.println("******************************************");
        
        System.out.println("**** SHAPE RECTANGLE PRISM ****");
        System.out.print("Enter the value for the length : ");
        a = sc.nextInt();
        System.out.print("Enter the value of the breadth : ");
        b = sc.nextInt();
        System.out.print("Enter the value of the height : ");
        c = sc.nextInt();
        box rectangle = new box(a,b,c);
        System.out.println("Area of the Square prism : " + rectangle.get_Area());
        System.out.println("Volume of the Square prism : " + rectangle.get_Volume());
        System.out.println("*******************************************");
    }
}
