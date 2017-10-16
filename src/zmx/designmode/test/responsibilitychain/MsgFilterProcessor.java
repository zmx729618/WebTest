package zmx.designmode.test.responsibilitychain;

public class MsgFilterProcessor {
	
	private String msg;
	private Filter[] filters= new Filter[]{new HtmlFilter(),new SensitiveFilter()};
	
	public MsgFilterProcessor(String msg) {
		this.msg = msg;
	}
	
	public String process(){
		
        String r = msg;  
        for(Filter f : filters){  
	        r = f.doFilter(r);  
        }  
        return r;  

	}
	
	
	



}
