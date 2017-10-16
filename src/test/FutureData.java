package test;

import java.util.Observable;
import java.util.Observer;

public class FutureData implements Data, Observer{  //观察者
	
	private volatile RealData realData = null;
	
	private Object mutex = new Object();  
	
	public boolean isFinished(){
		return realData !=null;
	}
	
	@Override
	public String getContent() {
		synchronized (mutex) {
			while(!isFinished()){ //只要数据没有准备完毕，就阻塞调用线程
				try {
					mutex.wait();
				} catch (InterruptedException e) {					
					e.printStackTrace();
				}
			}
			
		}
		return realData.getContent();
	}

	@Override
	public void update(Observable realData, Object event) { //观察者更新自己的方法
		System.out.println("通知："+event);
		
		if( !(realData instanceof RealData)){
			throw new IllegalArgumentException("主题的数据类型必须是RealData");
		}
		
		if( !(event instanceof String)){
			throw new IllegalArgumentException("事件的数据类型必须是String");
		}
		
		synchronized (mutex) {
			
			if("Finished".equalsIgnoreCase((String)event)){  // 数据准备好了的时候，便可以通知数据准备好了
				this.realData = (RealData)realData;
				mutex.notifyAll();  //唤醒被阻塞的线程
			}
			
			if(isFinished()){
				mutex.notifyAll();
				return;  //如果数据准备已经好了直接返回
			}
			
			
			
		}
		
	}



}
