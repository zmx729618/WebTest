package zmx.reference.test;
import java.lang.ref.WeakReference;   

public class WeakReferenceTest {   
  
    /**  
     * @param args  
     */  
    public static void main(String[] args) {   
        Object a = new Object();   
        a = "Hello, reference";   
        WeakReference<Object> weak = new WeakReference<Object>(a);   
        a = null;   
        int i = 0;   
        while (weak.get() != null) {   
            System.out.println(String.format("Get str from object of WeakReference: %s, count: %d", weak.get(), ++i));   
            if (i % 10 == 0) {   
                System.gc();   
                System.out.println("System.gc() was invoked!");   
            }   
            try {   
                Thread.sleep(5);   
            } catch (InterruptedException e) {   
  
            }   
        }   
        System.out.println("object a was cleared by JVM!");   
    }   
  
}

