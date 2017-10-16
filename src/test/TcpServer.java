package test;

import java.lang.Thread.UncaughtExceptionHandler;

public class TcpServer implements Runnable{
	//创建后立即运行
	public TcpServer() {
		Thread t =  new Thread(this);
		t.setUncaughtExceptionHandler(new UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				
				System.out.println("线程"+t.getName()+"出现异常,自行重启，请分析原因");
				e.printStackTrace();
				new TcpServer();
			}
		});
		
		t.start();
	}

	@Override
	public void run() {
		
		for(int i=0; i<3; i++){
			try {
				
				Thread.sleep(1000);
				System.out.println("系统正常运行："+i);
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		throw new RuntimeException();
	}
	
	
	public static void main(String[] args) {
		
		TcpServer server = new TcpServer();
		
	}

}
