package multi.thread;

import java.util.List;
import java.util.Vector;

/**
 * 实现一个生产者消费者模型
 * 一条街,有很多家包子铺,包子铺,开张的时候,都已经做好了19个包子,
 * 包子呢,是边做边卖.做1个包子,是铁定的800ms,而卖出1个包子不会超过1s(生意好).
 * @author zhangwenchao
 *
 */
public class WaitNotify {
	
	 static class BaoziShop implements Runnable{
		
		private boolean isRunning = false;  //是否开张
		
		private String name;  //包子铺的名字
		
		private int count = 0; //用于记录总共做出的包子的数量
		
		private Thread subMakeThread = null; //做包子的任务线程
		
		private Thread subSellThread = null; //卖包子的任务线程
		
		
		private List<Integer> baozis = new Vector<Integer>();  //包子铺的剩余的包子数量
		
		
		public BaoziShop(String name){ //构造方法
			
			this.name = name;  
			
            for (int i = 1; i < 20; i++) {   //初始化20个包子
                baozis.add(++count);  
            } 
			
		}
		
		/**
		 * 做包子，每秒做一个包子
		 */
		public void makeBaozi(){
			
			subMakeThread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(baozis.size() < 20 && isRunning){  //包子少于20个 并且  可以运行的情况下
						synchronized (baozis) { //使用baozis作为同步锁--
							try {
								Thread.sleep(800); //
								System.out.println("包子铺<<" + name + ">>开始做第[" + ++count + "]个包子!"); 
								baozis.add(count);
								
								
								
								if (baozis.size() >= 20) {  
                                    System.out.println("包子铺 << " + name + ">>包子满了,停止做包子!");
                                    baozis.wait();  // 包子圃的包子大于20个，不需要在做包子了， 线程等待
                                }else{
                                
								    baozis.notifyAll(); //通知 做了包子, 可以卖包子了
                                }
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							
						}
					}
					
				}
			});
			subMakeThread.start();
			
		}
		
		
		
        /** 
         * 出售包子,0.5秒卖出一个包子 
         */  
        public void sellBaozi() {  
        	subSellThread = new Thread() {  
                @Override  
                public void run() {  
                    while (baozis.size() > 0 && isRunning) {  
                        synchronized (baozis) {  
                            try {  
                                Thread.sleep((long) (Math.random() * 1000)); // 少于1秒就可以卖出1个包子   
                                System.out.println("包子铺<< " + name + ">>出售第[" + baozis.get(0) + "]个包子!");  
                                baozis.remove(0);
                                
                                
                                if (baozis.size() < 1) {  
                                    System.out.println("包子铺 <<" + name + ">> 没包子可以卖了,等待做包子!");  
                                    baozis.wait();  //没有包子了，需要等待，
                                }else{  
                                    baozis.notifyAll();  //通知制作包子   
                                } 
                            } catch (InterruptedException e) {  
                                e.printStackTrace();  
                            }  
                        }  
                    }  
                }  
            };  
            subSellThread.start();  
        } 
		
        
		@Override
		public void run() {
			 makeBaozi();
			 sellBaozi();
		}
        
        public void setRunning(boolean isRunning) {  
            this.isRunning = isRunning;  
            Thread thread = new Thread(this);  
            thread.start();  
        }  
  
        public void openShop() {  
            isRunning = true;  
            Thread thread = new Thread(this);  
            thread.start();  
        } 
        
        


		
	}
	 
	 public static void main(String[] args) {
		 BaoziShop shop1 = new BaoziShop("狗不理"); 
		 shop1.openShop();
		 
		 
		// BaoziShop shop2 = new BaoziShop("庆丰"); 
		// shop2.openShop();
	}
	
	

}
