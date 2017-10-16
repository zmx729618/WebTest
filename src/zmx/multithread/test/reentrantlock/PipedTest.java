package zmx.multithread.test.reentrantlock;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedTest {
	
	private PipedOutputStream pos;
    private PipedInputStream pis;
    //private ObjectOutputStream oos;
    //private ObjectInputStream ois;
    
    public PipedTest(){
        try{
            pos = new PipedOutputStream();
            pis = new PipedInputStream(pos);
            //oos = new ObjectOutputStream(pos);
            //ois = new ObjectInputStream(pis);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    public void start(){
        new Producer().start();
        new Consumer().start();
    }
    
    public static void main(String[] args) throws Exception{
    	PipedTest s4 = new PipedTest();
        s4.start();
    }
    
    class Producer extends Thread{
        public void run() {
            try{
                while(true){
                    int b = (int) (Math.random() * 255);
                    System.out.println("Producer: a byte, the value is " + b);
                    pos.write(b);
                    pos.flush();
                    //Object o = new MyObject();
                    //oos.writeObject(o);
                    //oos.flush();
                    //System.out.println("Producer: " + o);
                }
            }catch(Exception e){
                //System.out.println(e);
                e.printStackTrace();
            }finally{
                try{
                    pos.close();
                    pis.close();
                    //oos.close();
                    //ois.close();
                }catch(IOException e){
                    System.out.println(e);
                }
            }
        }
    }
    
    class Consumer extends Thread{
        public void run(){
            try{
                while(true){
                    int b = pis.read();
                    System.out.println("Consumer: a byte, the value is " + String.valueOf(b));
                    //Object o = ois.readObject();
                    //if(o != null)
                        //System.out.println("Consumer: " + o);
                }
            }catch(Exception e){
                //System.out.println(e);
                e.printStackTrace();
            }finally{
                try{
                    pos.close();
                    pis.close();
                    //oos.close();
                    //ois.close();
                }catch(IOException e){
                    System.out.println(e);
                }
            }
        }
    }

}
