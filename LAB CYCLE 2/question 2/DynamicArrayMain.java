/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.dynamicarraymain;

import java.util.Scanner;

/**
 *
 * @author shiya
 */
class DynamicArray{
     int[] array;
     int size;
     
    Scanner input=new Scanner(System.in); 
     public DynamicArray(int n){
         this.size=n;
         array=new int[n];
     }
     
     public void addElements(){
         System.out.print("enter elemetns : ");
         for (int i=0;i<size;i++){
             array[i]=input.nextInt();
         }
     }
     
     public void printElements(){
         for (int i=0;i<size;i++){
             System.out.println(array[i]);
         }
     }
     
     public int[] copyArray(int[] array){
         int[] temp=new int[size];
         for (int i=0;i<size;i++){
             temp[i]=array[i]; 
         }
         return temp;
     }
     
     public void put(int element ,int position){
         int[] temp=copyArray(array);
         int index=position-1;
         size=size+1;
         array=new int[size];
         for(int i=0;i<size;i++){
             if (i<index){
                 array[i]=temp[i];
             }
             else if (i==index){
                 array[i]=element;
             }
             else if(i>index){
                 array[i]=temp[i-1];
             }
         }
     }
     
     public void removeElement(int position){
         int[] temp=copyArray(array);
         int index=position-1;
         size=size-1;
         array=new int[size];
         for (int i=0;i<size;i++){
             if(i<index){
               array[i]=temp[i];  
             }
             else if(i>=index){
                 array[i]=temp[i+1];
             }
         }
     }
     
     
}

public class DynamicArrayMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        int n = sc.nextInt();
        DynamicArray array1=new DynamicArray(5);
        array1.addElements();
        array1.printElements();
        array1.put(5,3);
        System.out.print("printing after adding elememts");
        array1.printElements();
        array1.removeElement(3);
        array1.printElements();
        
        System.out.println(" ARRAY and ITS OPERATIONS ");
        
    }
}
