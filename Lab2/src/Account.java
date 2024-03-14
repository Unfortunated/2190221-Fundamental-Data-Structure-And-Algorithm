public class Account {
    private String accountId;
    private String accountName;
    private TransactionManager transactionManager;
    private double balance;

    public Account(String accountId, String accountName) {
    	// Put your code here
    	this.accountId = accountId;
    	this.accountName = accountName;
    	this.transactionManager = transactionManager.getInstance();
    	this.balance = 0;
    }

    public void deposit(double amount) throws NegativeAmountException {
    	// Put your code here
    	if (amount < 0) {
    		throw new NegativeAmountException("The deposit amount can't be negative.");
    	}
    	this.balance += amount;
    	transactionManager.logTransaction("DEPOSIT - Amount: " + amount + " - Account ID: " + this.accountId);    	
    }

    public void withdraw(double amount) throws NegativeAmountException, InsufficientAmountException {
    	// Put your code here
    	if (amount < 0) {
    		throw new NegativeAmountException("The withdrawn amount can't be negative.");
    	} else if (amount > this.balance) {
    		throw new InsufficientAmountException("The withdrawn amount can't be larger than the balance");
    	}
    	transactionManager.logTransaction("WITHDRAWAL - Amount: " + amount + " - Account ID: " + this.accountId);
    	this.balance -= amount;
    
    }

    public void transfer(Account targetAccount, double amount) throws NegativeAmountException, InsufficientAmountException {
    	// Put your code here
    	if (amount < 0) {
    		throw new NegativeAmountException("The transferred amount can't be negative.");
    	} else if (amount > this.balance) {
    		throw new InsufficientAmountException("The transferred amount can't be larger than the balance");
    	}
    	transactionManager.logTransaction("TRANSFER - Amount: " + amount + " - From Account ID: " + this.accountId 
    			+ "- To Account ID:" + targetAccount);
    	this.balance -= amount;
    	targetAccount.balance += amount;
    }

    public double getBalance() {
        return balance;
    }
    
    public String getAccountId() {
    	return accountId;
    }

}