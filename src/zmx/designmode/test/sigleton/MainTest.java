package zmx.designmode.test.sigleton;


public class MainTest {
	
	public static void main(String[] args) {
		
		Sigleton instance = Sigleton.INSTENCE;
		
		instance.setAnotherfied("xxx");
		instance.doSomething();
	}

}
