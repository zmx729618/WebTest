package zmx.designmode.test.responsibilitychain;

public class MainTest {
	
	public static void main(String[] args) {
		
	        //需要被过滤的语句  
	        String msg = "被就业了:),敏感信息,<script>";  
	        //实例化处理类  
	        //MsgProcessor mp = new MsgProcessor(msg);  	        
	        //MsgFilterProcessor mp = new MsgFilterProcessor(msg);
	        
	        //搞一个过过滤链  
	        FilterChain chain = new FilterChain();  
	        chain.addFilter(new HtmlFilter())
	             .addFilter(new SensitiveFilter())
	             .addFilter(new SmileFilter());  
	        //实例化处理类  
	        MsgFilterChainProcessor mp = new MsgFilterChainProcessor(msg,chain);

	        String r = mp.process();  
	        System.out.println(r);	
	}

}
