package zmx.clone.test;


public class Account implements Cloneable {
	
	private Person person;
	
	private long balance;


	public Person getPerson() {
		return person;
	}



	public void setPerson(Person person) {
		this.person = person;
	}



	public long getBalance() {
		return balance;
	}



	public void setBalance(long balance) {
		this.balance = balance;
	}



	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	

}
