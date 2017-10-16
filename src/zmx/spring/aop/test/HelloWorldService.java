package zmx.spring.aop.test;

public class HelloWorldService implements IHelloWorldService {

	@Override
	public void sayHello() {
		 System.out.println("============Hello World!================");  	
	}

	@Override
	public void recordLog(String log) {
		
		 System.out.println("============record Log================"+log);
	}
	
	

}
