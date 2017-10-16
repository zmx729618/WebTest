package zmx.designmode.test.sigleton;

public enum Sigleton {
	
	INSTENCE;
	
	private String anotherfied;
	
	public void doSomething(){
		System.out.println("do something ...");
		
	}

	public String getAnotherfied() {
		return anotherfied;
	}

	public void setAnotherfied(String anotherfied) {
		this.anotherfied = anotherfied;
	}
	
	

}
