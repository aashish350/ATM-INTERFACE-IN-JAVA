package atm;

import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
	        // Create a bank and add an account
	        Bank bank = new Bank();
	        System.out.println("enter amount of the account");
	        Scanner sc=new Scanner (System.in);
	        double amount=sc.nextDouble();
	        
	       
	        Account account = new Account("1234567890", amount);
	        bank.addAccount(account);

	        // Create an account holder
	        AccountHolder accountHolder = new AccountHolder("user123", "1234");

	        // Create an ATM and start the program
	        ATM atm = new ATM(accountHolder, bank);
	        atm.start();
	    }
}
