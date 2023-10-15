/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pascaltriangle;

import static java.time.Clock.system;
import java.util.Scanner;

/**
 *
 * @author shiya
 */
class PrintPascalTriangle{
    public static int getPascalValue(int row, int col) {
        if (col == 0 || col == row) {
            return 1;
        } else {
            return getPascalValue(row - 1, col - 1) + getPascalValue(row - 1, col);
        }
    }
    public void display(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(getPascalValue(i, j) + " ");
            }
            System.out.println();
        }
    }
}

public class PascalTriangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n;
        System.out.print("Enter the number of rows : ");
        n=sc.nextInt();
        PrintPascalTriangle obj1=new PrintPascalTriangle();
        obj1.display(n);
    }
}
