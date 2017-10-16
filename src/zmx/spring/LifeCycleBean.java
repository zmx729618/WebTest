package zmx.spring;

import org.springframework.beans.factory.InitializingBean;

public class LifeCycleBean implements InitializingBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		 System.out.println("LifeCycleBean initializing...");
	   
	}
	
	

}
