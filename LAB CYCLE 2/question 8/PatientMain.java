/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.patientmain;

/**
 *
 * @author shiya
 */
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class Patient{
    private String name;
    private int age;

    public Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void checkEligibility() throws InvalidAgeException {
        if (age >130) {
            throw new InvalidAgeException("Sorry, " + name + ". You entered invalid age.");
        }
        System.out.println(name + " you entered a valid age.");
    }
}

public class PatientMain {

    public static void main(String[] args) {
        Patient patient1 = new Patient("Shiyas", 20);
        Patient patient2 = new Patient("Bob", 150);

        try {
            patient1.checkEligibility();
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }

        try {
            patient2.checkEligibility();
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}
