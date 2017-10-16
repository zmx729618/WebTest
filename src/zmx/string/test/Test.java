package zmx.string.test;

import java.util.ArrayList;
import java.util.List;


public class Test {
	
	public static void main(String[] args) {
		
		/*List<String> handler = new ArrayList<String>();
		for(int i=0; i<1000;i++){
			//HugeStr str =  new HugeStr();
		    ImprovedHugeStr str =  new ImprovedHugeStr();
			handler.add(str.getSubString(1, 5));
		}
		   */
		
		int i=1;
		switch(i){
		
		  case 1:  
			   System.out.println("XXXXXXXXXXXX-----1");
			   break;
		
		  case 2:  
			   System.out.println("XXXXXXXXXXXX-----2");
		       break;
		
		  default:
		       System.out.println("XXXXXXXXXXXX-----3");
		       break;


		
		}
		
		
		
	}
	
	static class HugeStr{
		
		private String str = new String(new char[100000]);
		
		public String getSubString(int begin,int end){
			return str.substring(begin,end);
		}
		
	}
	
	
	static class ImprovedHugeStr{
		
		private String str = new String(new char[100000]);
		
		public String getSubString(int begin,int end){
			return new String(str.substring(begin,end));
		}
		
	}



	
	
	

}


