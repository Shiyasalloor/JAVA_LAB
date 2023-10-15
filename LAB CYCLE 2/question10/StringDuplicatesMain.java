/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package QUESTION10;

/**
 *
 * @author cusat
 */
import java.util.TreeSet;

public class StringDuplicatesMain {
    public static void main(String[] args) {
        String[] stringArray = {"kerala","tamilnadu","andhra pradesh","haryana","kerala","haryana" };
        TreeSet<String> treeSet = new TreeSet<>();
        for (String string : stringArray) {
                treeSet.add(string);
        }
        System.out.println(treeSet);
    }
}