/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.accountmain;

import java.util.Scanner;

/**
 *
 * @author shiya
 */
abstract class Account{
    protected String accHolderName;
    protected String accNo;
    protected float balance;
    
    public Account(String accHolderName,String accNo,float balance){
        this.accHolderName=accHolderName;
        this.accNo=accNo;
        this.balance=balance;
    }
    public void deposit(float amount){
        balance+=amount;
        System.out.println("Deposited successfully..");
        System.out.println("Current Balance : "+balance);
    }
    public abstract void withdrawel(float amount);
}

class SavingsAccount extends Account{
    public SavingsAccount(String accHolderName,String accNo,float balance){
        super(accHolderName,accNo,balance);
    }
    @Override
    public void withdrawel(float amount){
        if(balance - amount >= 1000){
            balance-=amount;
            System.out.println("Withdrawed Successfully");
            System.out.println("Currrent Balance : "+balance);
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }
}

class CurrentAccount extends Account{
    public CurrentAccount(String accHolderName,String accNo,float balance){
        super(accHolderName,accNo,balance);
    }
    @Override
    public void withdrawel(float amount) {
        float maxWithdrawal = (float) (balance * 0.05);
        if (amount <= maxWithdrawal) {
            balance -= amount;
            System.out.println("Withdrawn " + amount + ". Current balance: " + balance);
        } else {
            System.out.println("Exceeded overdraft limit.");
        }
    }
}

public class AccountMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("****WELCOME TO BANK****");
        System.out.println("Enter the Accont holder name : ");
        String name = sc.nextLine();
        System.out.print("Enter Account Number: ");
        String accNum = sc.nextLine();
        System.out.print("Enter Initial Balance: ");
        float balance = sc.nextInt();
        
        Account account;
        System.out.print("Select account type (Savings/Current): ");
        String accountType = sc.next().toLowerCase();
        if (accountType.equals("savings")) {
            account = new SavingsAccount(name, accNum, balance);
        } else if (accountType.equals("current")) {
            account = new CurrentAccount(name, accNum, balance);
        } else {
            System.out.println("Invalid account type.");
            return;
        }
        
        while (true) {
            System.out.println("\n1. Deposit Cash");
            System.out.println("2. Withdraw Cash");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the amount to deposit: ");
                    float depositAmount = sc.nextFloat();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: ");
                    float withdrawalAmount = sc.nextFloat();
                    account.withdrawel(withdrawalAmount);
                    break;
                case 3:
                    System.out.println("Thank you for using our services. Have a great day!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
