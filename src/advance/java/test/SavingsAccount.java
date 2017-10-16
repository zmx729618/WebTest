package advance.java.test;


public class SavingsAccount extends BankAccount{
	
	public static int aa = 8;
	
	private float interestRate;
	
	public SavingsAccount() {
		
		System.out.println("Creating SavingAccount...");
		
	}
	
	

	public SavingsAccount(float interestRate) {
		super();
		this.interestRate = interestRate;
	}



	public float getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(float interestRate) {
		this.interestRate = interestRate;
	}
	
	
	 public static void main(String[] args) {
		 
		 SavingsAccount savingsAccount = new SavingsAccount();
				 
		
	}
	
	

}
