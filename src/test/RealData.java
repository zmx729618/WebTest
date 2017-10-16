package test;

import java.util.Observable;

public class RealData extends Observable implements Data{ //被观察者
	
    private String content;  //真正的数据内容
    
	@Override
	public String getContent() {
		
		return content;
	}
	
	public void createRealData(int count, char c) throws Exception{
		 
		 System.out.println(" making RealData(" + count + ", " + c  + ") BEGIN");  
		 char[] buffer = new char[count];  
		 for (int i = 0; i < count; i++) {  
			     buffer[i] = c;  
				 try {  
				     Thread.sleep(200);  
				 } catch (InterruptedException e) {  
				 }  
		 }  
		System.out.println("  making RealData(" + count + ", " + c + ") END");  
		this.content = new String(buffer); //真实数据准备完毕了，通知FutureData2说数据已经准备好了.  
		setChanged();//必须先设置本对象的状态发生了变化，并且通知所有的观察者  
		notifyObservers("Finished");  //通知所有的观察者 
	}
	
	
	
	
	public static void main(String[] args) {
		
		// (1) 建立FutureData的实体    
        final FutureData future = new FutureData();    
        
        new Thread() {    
            public void run() {    
                RealData realdata = new RealData();    
                realdata.addObserver(future);//以便当RealData2把数据准备完毕后，通过该回调口子，通知FutureData2表示数据已经贮备好了    
                try {
					realdata.createRealData(100, 'c');
				} catch (Exception e) {
					e.printStackTrace();
				}    
            }    
        }.start();
        
        System.out.println(future.getContent());
		
	}
	
	

}
