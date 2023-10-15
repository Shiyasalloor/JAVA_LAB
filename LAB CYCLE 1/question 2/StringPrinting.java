/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.stringprinting;

/**
 *
 * @author shiya
 */
public class StringPrinting {

    public static void main(String[] args) {
        String n = args[0];
        String str = args[1];
        int num=Integer.parseInt(n);
        for(int i=0 ; i<num ; i++){
            System.out.println(str);
        }
    }
}
