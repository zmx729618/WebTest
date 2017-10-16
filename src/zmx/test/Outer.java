package zmx.test;

public class Outer {  
    static {  
        System.out.println("load outer class...");  
    }  
      
    //静态内部类  
    static class StaticInner {  
        static {  
            System.out.println("load static inner class...");  
        }  
          
        static void staticInnerMethod() {  
            System.out.println("static inner method...");  
        }  
    }
    
    class Inner{
    	
    	public void innerMethod(){
    		System.out.println(" inner method");
    	}
    }
          
    public static void main(String[] args) {  
         Outer outer = new Outer();      //此刻其内部类是否也会被加载？  
         System.out.println("===========分割线===========");  
         Outer.StaticInner.staticInnerMethod();      //调用内部类的静态方法  
   
        // Outer outer2 = new Outer();  
    }  
}  

