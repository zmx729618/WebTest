package zmx.designmode.test.responsibilitychain;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {
	
	public List<Filter> filters = new ArrayList<Filter>();
	
	public FilterChain addFilter(Filter f){
		filters.add(f);  
	    return this;
	}

	@Override
	public String doFilter(String str) {
		
        String r = str;  
        for(Filter f : filters){  
	        r = f.doFilter(r);  
        }  
        return r; 

	}

}
