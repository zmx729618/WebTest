package zmx.observer.test;

public class Main {
	
	public static void main(String[] args) {
		MyObservable myObservable = new MyObservable(); //被观察者
		MyObserver myObserver1 = new MyObserver();   //观察者
		MyObserver myObserver2 = new MyObserver();   //观察者
		myObservable.addObserver(myObserver1);
		myObservable.addObserver(myObserver2);
		
		myObservable.sendMessages(new String("我已经发送信息过来了"));
		
	}

}
