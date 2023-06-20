package atm;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Scanner;

	class ATM {
	    private AccountHolder accountHolder;
	    private Bank bank;
	    private Scanner scanner;

	    public ATM(AccountHolder accountHolder, Bank bank) {
	        this.accountHolder = accountHolder;
	        this.bank = bank;
	        this.scanner = new Scanner(System.in);
	    }

	    public void start() {
	        System.out.println("Welcome to the ATM!");

	        // Prompt for user ID and PIN
	        System.out.print("Enter user ID: ");
	        String userId = scanner.nextLine();
	        System.out.print("Enter user PIN: ");
	        String userPin = scanner.nextLine();

	        // Check if the user ID and PIN are correct
	        if (userId.equals(accountHolder.getUserId()) && userPin.equals(accountHolder.getUserPin())) {
	            System.out.println("Login successful!");
	            showMenu();
	        } else {
	            System.out.println("Invalid user ID or PIN. Exiting...");
	        }
	    }

	    private void showMenu() {
	        boolean quit = false;

	        while (!quit) {
	            System.out.println("\n--- Menu ---");
	            System.out.println("1. Show transaction history");
	            System.out.println("2. Withdraw");
	            System.out.println("3. Deposit");
	            System.out.println("4. Transfer");
	            System.out.println("5. Quit");

	            System.out.print("Enter your choice: ");
	            int choice = scanner.nextInt();
	            scanner.nextLine(); // Consume the newline character

	            switch (choice) {
	                case 1:
	                    showTransactionHistory();
	                    break;
	                case 2:
	                    performWithdrawal();
	                    break;
	                case 3:
	                    performDeposit();
	                    break;
	                case 4:
	                    performTransfer();
	                    break;
	                case 5:
	                    quit = true;
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	            }
	        }

	        System.out.println("Thank you for using the ATM!");
	    }
           // bank.
	    private void showTransactionHistory() {
	        System.out.println("\n--- Transaction History ---");
	        Account acc=bank.findAccount("1234567890");
	        List<BankTransaction> transactions =acc.getTransactions();

	        if (transactions.isEmpty()) {
	            System.out.println("No transactions found.");
	        } else {
	            for (BankTransaction transaction : transactions) {
	                System.out.println(transaction.getType() + ": " + transaction.getAmount());
	            }
	        }
	    }

	    private void performWithdrawal() {
	        System.out.print("Enter withdrawal amount: ");
	        double amount = scanner.nextDouble();
	        Account acc=bank.findAccount("1234567890");
	        acc.withdraw(amount);
	    }

	    private void performDeposit() {
	        System.out.print("Enter deposit amount: ");
	        double amount = scanner.nextDouble();
	        Account acc=bank.findAccount("1234567890");
	         acc.deposit(amount);
	        System.out.println( acc.getBalance());
	    }

	    private void performTransfer() {
	        System.out.print("Enter recipient account ID: ");
	        String recipientId = scanner.nextLine();
//	        Account acc=bank.findAccount("1234567890");
	        Account recipient = bank.findAccount(recipientId);

	        if (recipient == null) {
	            System.out.println("Recipient account not found.");
	            return;
	        }

	        System.out.print("Enter transfer amount: ");
	        double amount = scanner.nextDouble();
//	        getAccount().transfer(recipient, amount);
	        recipient.transfer(recipient, amount);
	        
	    }

	    private Account getAccount() {
	        // In this example, we assume there's only one account per user for simplicity.
	        // You can modify this logic to handle multiple accounts per user if needed.
	        return bank.findAccount(accountHolder.getUserId());
	    }
	}



