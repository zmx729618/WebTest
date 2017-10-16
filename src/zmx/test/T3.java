package zmx.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

public class T3 {
   /* static final int c = 3;

    static final int d;

    static int e = 5;
    static {
            d = 5;
            e = 10;
            System.out.println("Initializing");
    }

    T3() {
            System.out.println("Building");
    }*/

	
	public static void main(String[] args) throws Exception {
		// System.out.println(T3.c);
        // System.out.println(T3.d);
        // System.out.println(T3.e);
		// Class c = Class.forName("zmx.test.Toy");
		// Class c = Toy.class;		
		// System.out.println(Toy.price);
		
		/*Properties props = System.getProperties(); 
		Runtime runtime = Runtime.getRuntime();  
		long freeMemoery = runtime.freeMemory();  
		long totalMemory = runtime.totalMemory();  
		long usedMemory = totalMemory - freeMemoery;  
		long maxMemory = runtime.maxMemory();  
		long useableMemory = maxMemory - totalMemory + freeMemoery;  

		System.out.println(freeMemoery);
		System.out.println(totalMemory);
		System.out.println(usedMemory);
		System.out.println(maxMemory);
		System.out.println(useableMemory);*/
		
	/*	Random random1 = new Random(100);
        System.out.println(random1.nextInt());
        System.out.println(random1.nextFloat());
        System.out.println(random1.nextBoolean());
        Random random2 = new Random(100);
        System.out.println(random2.nextInt());
        System.out.println(random2.nextFloat());
        System.out.println(random2.nextBoolean());
        
        Random random = new Random();
        for(int i = 0; i < 10;i++) {
            System.out.println(Math.abs(random.nextInt())%10);
        }*/
		
		
		 /*String s1=new String("zhaoxudong"); 
		 String s2=new String("zhaoxudong"); 
		 System.out.println(s1==s2);//false 
		 System.out.println(s1.equals(s2));//true 
		 System.out.println(s1.hashCode());//s1.hashcode()等于s2.hashcode() 
		 System.out.println(s2.hashCode()); 
		 Set hashset=new HashSet(); 
		 hashset.add(s1); 
		 hashset.add(s2);
		
		System.out.println(hashset);*/
		
        HashSet hs=new HashSet(); 
        hs.add(new Student(1,"zhangsan")); 
        hs.add(new Student(2,"lisi")); 
        hs.add(new Student(3,"wangwu")); 
        hs.add(new Student(1,"zhangsan"));



       Iterator it=hs.iterator(); 
        while(it.hasNext()) 
        { 
               System.out.println(it.next()); 
        } 

		
	}
	
	
	

}


class Student 
{ 
  int num; 
  String name; 
  Student(int num,String name) 
             { 
             this.num=num; 
              this.name=name; 
              } 
           public String toString() 
             { 
                 return num+":"+name; 
              }
		@Override
		public int hashCode() {
			 return num*name.hashCode(); 
			
		}
		@Override
		public boolean equals(Object obj) {
			Student s=(Student)obj; 
            return num==s.num && name.equals(s.name);
		} 
		
           
           
  }
