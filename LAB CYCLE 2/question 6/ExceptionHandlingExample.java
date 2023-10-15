/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.exceptionhandlingexample;

import java.util.Scanner;

/**
 *
 * @author shiya
 */
public class ExceptionHandlingExample {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String : ");
        String string = sc.nextLine();
        
        try{
            int number = Integer.parseInt(string);
            System.out.println("Changed number : "+ number);
        }catch(NumberFormatException e){
            System.out.println("Number format Exception "+ e.getMessage());
        }
        
        
        String str = null;
        System.out.println("str : null");
        try{
            int length = str.length();
            System.out.println("Length of the string : "+length);
        }catch(NullPointerException e){
            System.out.println("Null pointer Exception "+e.getMessage());
        }
    }
}
