package zmx.calss.loadorder;

public class D extends C{
	
	
	public static String sd=getSd();
	      static{
	          System.out.println("执行D的static块(D继承C)");
	         
	     }
         {
	         System.out.println("执行D实例的普通初始化块");
	     }
         
         public String sd1=getSd1();
         
	     D(){
	         System.out.println("执行D的构造函数(D继承C);父类B的实例成员变量sb的值为："+sb+";本类D的static成员变量sd的值为："+sd+";本类D的实例成员变量sd1的值是："+sd1);
	    }
	     
	     static public String getSd()
	     {
	         System.out.println("初始化D的static成员变量sd");
	         return "sd";
	     }
	     public String getSd1()
	    {
	        System.out.println("初始化D的实例成员变量sd1");
	         return "sd1";
	     }


}
