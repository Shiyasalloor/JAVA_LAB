/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.primenumbers;

/**
 *
 * @author shiya
 */


public class PrimeNumbers {
    public static boolean checkPrime(int num) {
        
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        
        String n = args[0];
        int no = Integer.parseInt(n);
        int count = 0;
        int num = 2;

        System.out.print("First " + n + " Prime Numbers : ");

        while (count < no) {
            if (checkPrime(num)) {
                System.out.print(num + " ");
                count++;
            }
            num++;
        }
    }
}


