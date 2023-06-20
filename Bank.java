package atm;

import java.util.ArrayList;
import java.util.List;

 class Bank {
	    private List<Account> accounts;
	    

	    public Bank() {
	        this.accounts = new ArrayList<>();
	    }

	    public void addAccount(Account account) {
	        accounts.add(account);
	    }
//        public Account getAccount( String a) {
//        	return account;
//        }
	    public Account findAccount(String accountId) {
	        for (Account account : accounts) {
	            if (account.getAccountId().equals(accountId)) {
	            	System.out.println("wright account");
	                return account;
	            }
	        }
	        return null;
	    }
	}

