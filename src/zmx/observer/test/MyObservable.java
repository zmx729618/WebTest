package zmx.observer.test;

import java.util.Observable;

public class MyObservable extends Observable{
	
	 public void sendMessages(String msg){  //发送消息
	        this.setChanged();  
	        this.notifyObservers(msg);  
	 } 
	 
	 
	 

}
