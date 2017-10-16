package advance.java.test;

public class Teller {

	public static void getService(int i) {		
		
		try {
			System.out.println("serving:"+i);
			Thread.sleep((long)(Math.random()*10));
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
	
	

}
