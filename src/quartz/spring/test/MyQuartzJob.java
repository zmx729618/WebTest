package quartz.spring.test;

import org.apache.log4j.Logger;

public class MyQuartzJob {
	
    private static final Logger LOG = Logger.getLogger(MyQuartzJob.class);  
    private static int counter = 0;  
      
    public void scan() { 
    	//System.out.println("Execute quartz job " + (++counter) + ".");
        LOG.info("Execute quartz job " + (++counter) + ".");  
    } 

}
