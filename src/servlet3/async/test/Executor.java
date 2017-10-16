package servlet3.async.test;

import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.AsyncContext;

public class Executor implements Runnable {
	
	private AsyncContext ctx;
    
	
	public Executor(AsyncContext ctx) {
		this.ctx = ctx;
	}


	@Override
	public void run() {
        try {  
            //等待十秒钟，以模拟业务方法的执行   
            Thread.sleep(10000);  
            PrintWriter out = ctx.getResponse().getWriter();  
            out.println("业务处理完毕的时间：" + new Date() + ".");  
            out.flush();  
            ctx.complete();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }

	}

}
