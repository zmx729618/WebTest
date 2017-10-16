package zwc.framwork;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;


@Repository
public class GenericBaseDao<T,PK extends Serializable > {
	
	protected Logger logger =  LoggerFactory.getLogger(getClass());
	//实体类类型
	private Class<T> entityClass;
	
	//注入sessionFactory
	@Resource(name="sessionFactory")
	protected SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory(){
	    return this.sessionFactory;
	}
	
	public Session getSession(){
	    return this.sessionFactory.getCurrentSession();
	}
	
	public void setEntityClass(Class<T> entityClass) {
		    this.entityClass = entityClass;
    }
	
	protected Class<T> getEntityClass(){
	    return this.entityClass;
	}
	
	@SuppressWarnings("unchecked")
	public GenericBaseDao(){
	   if (this.entityClass == null){
	      this.entityClass = (Class<T>)((ParameterizedType)this.getClass()
	    		                         .getGenericSuperclass())
	    		                         .getActualTypeArguments()[0];
	    }
	}
	
	
	public void flush()
	  {
	    getSession().flush();
	  }

	public void clear()
	  {
	    getSession().clear();
	  }
	  
	  

	@SuppressWarnings("unchecked")
	public T findById(PK id)
	  {
	    Assert.notNull(id, "id不能为空");
	    return (T)getSession().load(getEntityClass(), id);
	  }

	@SuppressWarnings("unchecked")
	public T findByIdForLock(PK id)
	  {
	    Assert.notNull(id, "id不能为空");
	    return (T)getSession().load(getEntityClass(), id, LockOptions.UPGRADE);
	  }

	  public void save(T entity)
	  {
	    Assert.notNull(entity, "entity不能为空");
	    getSession().save(entity);
	    this.logger.info("save entity: {}", entity);
	  }

	  public void update(T entity)
	  {
	    Assert.notNull(entity, "entity不能为空");
	    getSession().update(entity);
	    this.logger.info("update entity: {}", entity);
	  }

	  public void saveOrUpdate(T entity) {
	    Assert.notNull(entity, "entity不能为空");
	    getSession().saveOrUpdate(entity);
	    this.logger.debug("save entity: {}", entity);
	  }

	  public void delete(T entity)
	  {
	    Assert.notNull(entity, "entity不能为空");
	    getSession().delete(entity);
	    this.logger.info("delete entity: {}", entity);
	  }

	  public void deleteById(PK id)
	  {
	    Assert.notNull(id, "id不能为空");
	    delete(findById(id));
	    this.logger.info("delete entity {}, id is {}", this.entityClass.getSimpleName(), id);
	  }
	  
	  /**
	   * hql
	   * @param queryString
	   * @param values
	   * @return
	   */
	  public Query createQuery(String hql, Object... values)
	  {
	    Query queryObject = getSession().createQuery(hql);
	    if (values != null)
	      for (int i = 0; i < values.length; ++i)
	        queryObject.setParameter(i, values[i]);


	    return queryObject;
	  }
	  
	  
	  /**
	   * 原生sql
	   * @param queryString
	   * @param values
	   * @return
	   */
	  public Query createSqlQuery(String queryString, Object... values)
	  {
	    Query queryObject = getSession().createSQLQuery(queryString);
	    if (values != null)
	      for (int i = 0; i < values.length; ++i)
	        queryObject.setParameter(i, values[i]);

	    return queryObject;
	  }
	  
	  
	  public List findByHql(String hql, Object... values)
	  {
	    return createQuery(hql, values).list();
	  }
	  
	  
	 public Page<T> findPageByQuerys(Page<T> page, String hql, Object... values) {
			
			Assert.notNull(page, "page不能为空");
			Assert.hasText(hql, "hql不能为空");
			long count = findCountByHql(hql, values);
			if(count>-1)
				page.setTotalCount((int)count);
			Query q = createQuery(hql, values);
			q.setFirstResult(page.getPageNo());
			q.setMaxResults(page.getPageSize());
		
			page.setResult(q.list());
			return page;
		}

	private long findCountByHql(String hql, Object... values) {	
			Query query = createQuery(hql, values);
			return Long.parseLong(query.uniqueResult().toString());
	}
	  
	  
	  
	
	  
	  
	
	

}
