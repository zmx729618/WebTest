package zmx.observer.test;

import java.util.Observable;
import java.util.Observer;

public class MyObserver implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		//获取消息并打印
		System.out.println("获取的消息为:"+arg);
		
	}

}
