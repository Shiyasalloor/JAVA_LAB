/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.finalizebookmain;

/**
 *
 * @author shiya
 */

class Book {
    private String title;

    public Book(String title) {
        this.title = title;
        System.out.println("Book \"" + title + "\" created.");
    }

    public void read() {
        System.out.println("Reading \"" + title + "\"");
    }

    @Override
    protected void finalize() throws Throwable {
        try {
            System.out.println("Finalizing book: \"" + title + "\"");
        } finally {
            super.finalize();
        }
    }
}

public class FinalizeBookMain {

    public static void main(String[] args) {
        Book book1 = new Book("The Great Gatsby");
        Book book2 = new Book("To Kill a Mockingbird");

        book1.read();
        book2.read();

        // Let's make book1 eligible for garbage collection
        book1 = null;

        // Trigger garbage collection
        System.gc();

        // Pause to allow finalize() methods to execute (not recommended in production code)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
