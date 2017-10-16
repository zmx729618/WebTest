package zmx.designmode.test.responsibilitychain;

public class MsgFilterChainProcessor {
	
    private String msg;  
    private FilterChain chain = new FilterChain();  
    public MsgFilterChainProcessor(String msg, FilterChain filterChain){  
        this.msg = msg;  
        this.chain = filterChain;  
    }  
    public String process(){  
        return chain.doFilter(msg);  
    } 


}
