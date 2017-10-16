package zmx.spring.threadpool.test;


import org.junit.Test; 
import org.junit.runner.RunWith; 
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor; 
import org.springframework.test.context.ContextConfiguration;  
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; 
@RunWith(SpringJUnit4ClassRunner.class) 
// 指定的运行runner，并且把你所指定的Runner作为参数传递给它 
@ContextConfiguration(locations = "classpath:zmx/spring/threadpool/test/applicationContext.xml") 
public class TestThreadPool{
	
     private static int produceTaskSleepTime = 10; 
     private static int produceTaskMaxNumber = 100; 
     @Autowired 
     private ThreadPoolTaskExecutor threadPoolTaskExecutor; 
     
     public ThreadPoolTaskExecutor getThreadPoolTaskExecutor() { 
         return threadPoolTaskExecutor; 
     } 
     public void setThreadPoolTaskExecutor(ThreadPoolTaskExecutor threadPoolTaskExecutor) { 
         this.threadPoolTaskExecutor = threadPoolTaskExecutor; 
     } 

     @Test 
     public void testThreadPoolExecutor() { 
         for (int i = 1; i <= produceTaskMaxNumber; i++) { 
             try { 
                 Thread.sleep(produceTaskSleepTime); 
             } catch (InterruptedException e1) { 
                 e1.printStackTrace(); 
             } 
             new Thread(new StartTaskThread(threadPoolTaskExecutor, i)).start(); 
             
             
         } 
         
         threadPoolTaskExecutor.shutdown();
     } 
     

 } 

