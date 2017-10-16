package advance.java.test;

import java.util.Random;

public class VisitorRoster {
	
	private final int MAX_CAPACITY = 100;
	
	private String[] visitors;
	
	
	private void init(){
		visitors = new String[MAX_CAPACITY];
	}
	
	private void registerVisitor(){
		Random r = new Random();
		
		System.out.println("Registering visitors");
		
		for(int i=0; i<MAX_CAPACITY; i++){
			
			visitors[i] = Long.toString(Math.abs(r.nextLong()),36);
						
		}
	}
	
	private void printVisitorList(){
		System.out.println("\nToday's Visitors：");
		int i = 0;
		
		try {
			while(i <=  MAX_CAPACITY){
				System.out.println("visitor ID #" + visitors[i++]);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("");
		//	System.out.println("Quitting end of list");
		//	e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		
		VisitorRoster roster =  new VisitorRoster();
		roster.init();
		roster.registerVisitor();
		
		roster.printVisitorList();
		
		
	}
	
	
			

}
