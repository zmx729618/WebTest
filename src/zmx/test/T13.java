package zmx.test;

public class T13 {
	
	
	public static boolean define(String x){
		

			if(x.contains(".")){
				String[] xx  =  x.split("\\.");
				
				if(xx[0].startsWith("0")){
					return false;
				}
				if(0==Integer.valueOf(xx[1])){
					return true;
				}
				return false;
			}else{
				
				if(0==Integer.valueOf(x)||!x.startsWith("0")){
					return true;
				}else{
					
					return false;
				}
			}
			

	}
	
	
	public static boolean define2(String x){
		
     String reg =  "^[-+]?[1-9]\\d*+(\\.0*)?$|^0$";
     
     return x.matches(reg);
		
    }
	
	
	 public static boolean define3(double x){
		 System.out.println(Math.abs(x));
         System.out.println((int)Math.abs(x));
	     return  Math.abs(x)==(int)Math.abs(x);
			
	 }

	
	
	
	public static void main(String[] args) {
//      String x ="7.0";
//		String x ="7";
//		String x ="7.00000";
//		String x ="-7.00000";
//		String x ="-7";
//		String x="7.01";
//		String x="-7.01";
//		String x="-0.01";
	    Double x=72000.0d;
		System.out.println(define3(x));
		
		System.out.println(new Double(7200.00)==7200);
	}

}
