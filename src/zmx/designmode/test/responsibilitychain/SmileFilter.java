package zmx.designmode.test.responsibilitychain;

public class SmileFilter implements Filter {

	@Override
	public String doFilter(String str) {
		
        String r = str;  
        //过滤msg中的笑脸标记  
        r = r.replace(":)", "^_^");  
        return r;  

	}

}
