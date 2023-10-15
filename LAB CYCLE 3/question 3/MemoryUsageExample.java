/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question3;

/**
 *
 * @author ganes
 */
public class MemoryUsageExample {
    public static void main(String[] args) {
        // Get the runtime instance
        Runtime runtime = Runtime.getRuntime();

        // Get total memory (in bytes)
        long totalMemory = runtime.totalMemory();

        // Get free memory (in bytes)
        long freeMemory = runtime.freeMemory();

        // Display initial memory usage
        System.out.println("Total Memory: " + totalMemory + " bytes");
        System.out.println("Free Memory: " + freeMemory + " bytes");

        // Execute garbage collector
        runtime.gc();

        // Get memory usage after garbage collection
        long memoryAfterGC = runtime.freeMemory();

        // Display memory usage after garbage collection
        System.out.println("Free Memory after Garbage Collection: " + memoryAfterGC + " bytes");
    }
}

