package zmx.test;

import java.math.BigDecimal;

public class T15 {
	
	public static void main(String[] args) {
		
		        System.out.println(0.05+0.01);
		        System.out.println(1.0-0.42);
		        System.out.println(4.015*100);
		        System.out.println(123.3/100);
		        System.out.println( Math.round(4.015*100)/100.00);
		        
		        
		        BigDecimal b1 = new BigDecimal(Double.toString(0.05));
		        BigDecimal b2 = new BigDecimal(Double.toString(0.01111));
		        System.out.println(b1.add(b2).doubleValue());

	}

}
