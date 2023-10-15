/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.complexmain;

/**
 *
 * @author shiya
 */
import java.lang.Math;
import java.util.Scanner;

class Complex{
    public float real;
    public float imaginary;
    
    public Complex(float real,float imaginary){
        this.real = real;
        this .imaginary = imaginary;
    }
    public Complex(){
        
    }
    public float getReal(){
        return real;
    }
    public float getImaginary(){
        return imaginary;
    }
    public void printComplex(){
        System.out.println(real + "+" + imaginary + "i");
    }
}

class complexOperations{
    public static Complex add(Complex c1,Complex c2){
        Complex result = new Complex();
        result.real = c1.real + c2.real;
        result.imaginary = c1.imaginary + c2.imaginary;
        return result;
    }
    public static Complex multiply(Complex c1,Complex c2){
        Complex result = new Complex();
        result.real = (c1.real * c2.real) - (c1.imaginary * c2.imaginary);
        result.imaginary = (c1.real * c2.imaginary)+(c2.real * c1.imaginary);
        return result;
    }
    public static double getModulus(Complex c){
        double mod;
        mod=Math.sqrt((c.real*c.real) + (c.imaginary*c.imaginary));
        return mod;
    }
    
}

public class Complexmain {

    public static void main(String[] args) {
        float a,b,c,d;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the real part of the 1st Complex number : ");
        a = sc.nextFloat();
        System.out.print("Enter the imaginary part of the 1st Complex number : ");
        b = sc.nextFloat();
        System.out.print("Enter the real part of the 2nd Complex number : ");
        c = sc.nextFloat();
        System.out.print("Enter the imaginary part of the 2nd Complex number : ");
        d = sc.nextFloat();
        
        Complex c1 = new Complex(a,b);
        Complex c2 = new Complex(c,d);
        
        System.out.print("1st Complex number : ");
        c1.printComplex();
        System.out.print("2nd Complex number : ");
        c2.printComplex();
        
        System.out.print("Sum of the Complex numbers : ");
        Complex sum = complexOperations.add(c1, c2);
        sum.printComplex();
        
        System.out.print("Product of the Complex numbers : ");
        Complex product = complexOperations.multiply(c1, c2);
        product.printComplex();
        
        System.out.println("Modulus of Complex Number 1: " + complexOperations.getModulus(c1));
        System.out.println("Modulus of Complex Number 2: " + complexOperations.getModulus(c2));
          
    }
}
