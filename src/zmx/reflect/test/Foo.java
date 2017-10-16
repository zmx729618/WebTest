package zmx.reflect.test;

import java.lang.reflect.Method;

public class Foo {
	
	private String msg;

    public Foo(String msg) { 
         this.msg = msg; 
    }

    public void setMsg(String msg) { 
         this.msg = msg; 
    }

    public String getMsg() { 
         return msg; 
    }

    public void outInfo() { 
         System.out.println("这是测试Java实例方法反射调用的测试类"); 
    } 
    
    public static void print(){
    	System.out.println("这是测试Java静态方法反射调用的测试类"); 
    }
    
    
    public static void main(String[] args) throws Exception {
        Foo foo = new Foo("这个一个Foo对象！"); 
        Class clazz = foo.getClass(); 
        Method m1 = clazz.getDeclaredMethod("outInfo"); 
        Method m2 = clazz.getDeclaredMethod("setMsg", String.class); 
        Method m3 = clazz.getDeclaredMethod("getMsg"); 
       
        //调用实例方法
        m1.invoke(foo); 
        m2.invoke(foo, "重新设置msg信息！"); 
        String msg = (String) m3.invoke(foo); 
        System.out.println(msg);
        
        //调用静态方法
        Method m4 = clazz.getDeclaredMethod("print", null);
        m4.invoke(null, null);
	}
    
    


}
