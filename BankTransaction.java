package atm;

public class BankTransaction{
	
	    private String type;
	    private double amount;

	    public BankTransaction(String type, double amount) {
	        this.type = type;
	        this.amount = amount;
	    }

	    public String getType() {
	        return type;
	    }

	    public double getAmount() {
	        return amount;
	    }
	}

