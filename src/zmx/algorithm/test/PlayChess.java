package zmx.algorithm.test;

public class PlayChess { 
	public static int process(int m, int n) {  
	        if (m == 0 && n == 0)  
	           return 0;  
	               if (m==0 || n==0)  
	            return 1;  
	        return process(m, n - 1) + process(m - 1, n);  
    }  

	
	      
	   public static void main(String[] args) {  
	        int x = process(4,5);  
	        System.out.println(x);  
       }  


}
