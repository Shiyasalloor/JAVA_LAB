/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mainclass;

import java.util.Scanner;

/**
 *
 * @author shiya
 */

interface ThreeDshapes{
    void printVolume();
    void printArea();
}

class Cylinder implements ThreeDshapes{
    private final float radius;
    private final float height;
    
    public Cylinder(float radius ,float height){
        this.radius=radius;
        this.height=height;
    }
    @Override
    public void printVolume(){
        float volume = (float) (3.14 * radius * radius * height);
        System.out.println("Volume of the Cylinder : "+volume);
    }
    @Override
    public void printArea(){
         float area = (float) (2 * 3.14 * radius * (radius + height));
         System.out.println("Surface area of the Cylinder : "+area);
    }  
}

class Sphere implements ThreeDshapes {
    private final float radius;

    public Sphere(float radius) {
        this.radius = radius;
    }

    @Override
    public void printVolume() {
        float volume = (float) ((4.0 / 3.0) * 3.14 * Math.pow(radius, 3));
        System.out.println("Sphere Volume: " + volume);
    }

    @Override
    public void printArea() {
        float area = (float) (4 * 3.14 * Math.pow(radius, 2));
        System.out.println("Sphere Surface Area: " + area);
    }
}


public class MainClass {

    public static void main(String[] args) {
        float radius,height;
        Scanner sc = new Scanner (System.in);
        System.out.println("****CYLINDER****");
        System.out.print("Enter the radius of the cylinder : ");
        radius=sc.nextFloat();
        System.out.print("Enter the height of the cylinder : ");
        height=sc.nextFloat();
        Cylinder cylinder = new Cylinder(radius,height);
        cylinder.printVolume();
        cylinder.printArea();
        System.out.println();
        
        System.out.println("****SPHERE****");
        System.out.print("Enter the radius of the sphere : ");
        radius=sc.nextFloat();
        Sphere sphere = new Sphere(radius);
        sphere.printVolume();
        sphere.printArea();
    }
}
