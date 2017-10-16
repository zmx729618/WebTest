package zmx.designmode.test.responsibilitychain;

public class HtmlFilter implements Filter {

	@Override
	public String doFilter(String str) {
		
        String r = str;  
        //过滤msg中的HTML标记  
        r = r.replaceAll("<.*>", "");  
        return r;  

	}

}
