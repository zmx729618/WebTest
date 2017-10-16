package io.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedOutputStreamTest {
	
	public static void main(String[] args) throws Exception{  
        
       
        try {  
        	PipedOutputStream pos = new PipedOutputStream();  
            PipedInputStream pis = new PipedInputStream(pos);  
            new Thread(new InputStreamRunnable(pis)).start();  
            new Thread(new OutputStreamRunnable(pos)).start();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
   
	/**
	 * 
	 * @author zhangwenchao
	 *
	 */
    static class InputStreamRunnable implements Runnable{  
        private PipedInputStream pis = null;  
        public InputStreamRunnable(PipedInputStream pis){  
            this.pis = pis;  
        }  
        @Override  
        public void run() {  
            BufferedReader sr = new BufferedReader(new InputStreamReader(pis));  
            try {  
                System.out.println("读取到的内容:"+sr.readLine());  
                sr.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
          
    }  
      
    /**
     * 
     * @author zhangwenchao
     *
     */
    static class OutputStreamRunnable implements Runnable{  
        private PipedOutputStream pos = null;  
        public OutputStreamRunnable(PipedOutputStream pos){  
            this.pos = pos;  
        }  
        @Override  
        public void run(){  
            try {  
                pos.write("Hello World!".getBytes());  
                pos.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  


}
