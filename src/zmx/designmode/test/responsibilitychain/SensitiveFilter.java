package zmx.designmode.test.responsibilitychain;

public class SensitiveFilter implements Filter {

	@Override
	public String doFilter(String str) {
		
        String r = str;  
        //过滤str中的敏感信息 
        r = r.replace("敏感信息", "").replace("被就业", "就业");
		return r;  

	}

}
