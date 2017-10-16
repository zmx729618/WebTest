package zmx.hibernate.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class MainTest {
	
	
	@Test
	public void testinsertdata(){
		
		    ApplicationContext ctx = new ClassPathXmlApplicationContext("zmx/hibernate/test/applicationContext.xml");
		    SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");  
		    
	        Session session=sessionFactory.openSession();
	        Transaction t=session.beginTransaction();
	        
	        Student stu=new Student();
	        stu.setName("tom11");
	        session.save(stu);
	        t.commit();
	        
	        List<Student> users = new ArrayList<Student>();    
	        Iterator<Student> iter = users.iterator();
	        while(iter.hasNext()){
	        	Student s =iter.next();
	        	
	        	
	        }
		
	}
	
	@Test
	public void testHibernateVersion(){
		
		    ApplicationContext ctx = new ClassPathXmlApplicationContext("zmx/hibernate/test/applicationContext.xml");
		    SessionFactory sessionFactory = (SessionFactory) ctx.getBean("sessionFactory");  
		    
	        /*
	         * 模拟多个session操作student数据表
	         */
	        
	        Session session1=sessionFactory.openSession();
	        Session session2=sessionFactory.openSession();
	        Student stu1=(Student)session1.createQuery("from Student s where s.name='tom11'").uniqueResult();
	        Student stu2=(Student)session2.createQuery("from Student s where s.name='tom11'").uniqueResult();
	        
	        //这时候，两个版本号是相同的
	        System.out.println("v1="+stu1.getVersion()+"--v2="+stu2.getVersion());
	        
	        Transaction tx1=session1.beginTransaction();
	        stu1.setName("session1");
	        tx1.commit();
	        //这时候，两个版本号是不同的，其中一个的版本号递增了
	        System.out.println("v1="+stu1.getVersion()+"--v2="+stu2.getVersion());
	        
	        Transaction tx2=session2.beginTransaction();
	        stu2.setName("session2");
	        tx2.commit();
	       
		
	}

}

