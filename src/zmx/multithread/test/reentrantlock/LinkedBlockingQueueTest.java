package zmx.multithread.test.reentrantlock;

import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueTest {

    private LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<Object>(10);
    private int MAX = 10;
    
    public void start(){
            new Producer().start();
            new Consumer().start();
    }
    
    public static void main(String[] args) throws Exception{
    	LinkedBlockingQueueTest s3 = new LinkedBlockingQueueTest();
        s3.start();
    }
    
    class Producer extends Thread{        
        public void run(){
            while(true){
                //synchronized(this){
                try{
                    if(queue.size() == MAX)
                        System.out.println("warning: it's full!");
                    Object o = new Object();
                    queue.put(o);
                    System.out.println("Producer: " + o);
                    }catch(InterruptedException e){
                        System.out.println("producer is interrupted!");
                    }
                //}
            }
        }
    }
    
    class Consumer extends Thread{
        public void run(){
            while(true){
                //synchronized(this){
                try{
                    if(queue.size() == 0)
                        System.out.println("warning: it's empty!");
                    Object o = queue.take();
                    System.out.println("Consumer: " + o);
                    }catch(InterruptedException e){
                        System.out.println("producer is interrupted!");
                    }
                //}
            }
        }
    }
    
}