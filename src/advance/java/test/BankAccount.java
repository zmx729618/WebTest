package advance.java.test;

public class BankAccount extends Asset{
	
	private String bankName;
	private int accountNumber;
	
	private float balance;
	
	public BankAccount() {
		System.out.println("Create BankAccount ...");
	}
	
	

	public BankAccount(String bankName, int accountNumber, float balance) {
		super();
		this.bankName = bankName;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}



	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	

}
