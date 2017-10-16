package zwc.testweb.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.CacheMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.zwc.testweb.dao.BoardDao;
import org.zwc.testweb.domain.Board;

@RunWith(SpringJUnit4ClassRunner.class)  //用于配置spring中测试的环境 
@ContextConfiguration(locations="classpath:applicationContext.xml")  //用于指定配置文件所在的位置 
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback=false)  //defaultRollback=true恢复数据库现场
@Transactional
public class BoardDaoTest {
	@Autowired
	private BoardDao boardDao;
	
	@Resource(name="sessionFactory")   
	private SessionFactory sessionFactory;
	
	
	@Test
	public void testSave(){
		
		Board board = new  Board("网友自拍", "街拍", 222);
		boardDao.save(board);
		
	}
	
	
	@SuppressWarnings("rawtypes")
	@Test
	public void testCache(){
		
		Session session1 = sessionFactory.openSession();
		
		List list1 =  session1.createQuery("from Board").setCacheable(true).list();
		
		System.out.println(list1);
		
		session1.close();
		
        Session session2 = sessionFactory.openSession();
		
		List list2 =  session2.createQuery("from Board").setCacheable(true).list();
		
		System.out.println(list2);
		
		session2.close();
		
		
		
		
	}
	
	@Test
	public void testCacheLoad(){
		
		Session session1 = sessionFactory.openSession();
		
		Board b1 =  (Board) session1.load(Board.class, 1L);
		
		System.out.println(b1);
		
		session1.close();
		
		Session session2 = sessionFactory.openSession();
		
		Board b2 =  (Board) session2.load(Board.class, 1L);
		
		System.out.println(b2);
		
		session2.close();
		
		
	}
	
	//判断该实体
	@Test
	public void testEntityIsUsed(){
		
		Session session = sessionFactory.openSession();
		try {
			 session.beginTransaction();
			 session.createQuery("delete from Board where id=1 ").executeUpdate();			
			 session.getTransaction().rollback();
			 System.out.println("该实体没有关联任何其他实体，没有被使用");
		} catch (HibernateException e) {
			//出新删除异常
			System.out.println("该实体关联到其他实体，被使用");
			//e.printStackTrace();
		}finally{
			session.close();
		}
		
		
	}
	
	
	
	
	

}
