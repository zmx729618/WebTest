package zmx.multithread.test.threadlocal;

public class T1 extends Thread {
	 
    private NumCreator creator; 
    
    public T1(NumCreator creator) {  
	    this.creator = creator;
    }      
	      
	public void run() {  
	    //使用数字生成器生成三个数字  
        for (int i = 0; i < 3; i++){  
	           System.out.println(Thread.currentThread().getName()+ "print num:" + creator.getNextNum());              
	    }          
    } 
	
	
	
	public static void main(String[] args) {
		
		NumCreator n1 = new NumCreator();
		
		T1  t1 = new  T1(n1);
		T1  t2 = new  T1(n1);
		T1  t3 = new  T1(n1);
		
		t1.start();
		t2.start();
		t3.start();
		
	}

	//数字生成器。该类对象将被多个线程共享。
	static class NumCreator {
		
		private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();  
		
	    public int getNextNum() {
	    	if(threadLocal.get()==null){
	    		threadLocal.set(1);  
	    		return 0;	    		
	    	}else{
	    		Integer num= threadLocal.get();  
		        threadLocal.set(new Integer(num+1));  
		        return num;
	    		
	    	}	

	    }
	}
	
	
	

}
