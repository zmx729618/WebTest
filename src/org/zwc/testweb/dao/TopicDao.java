package org.zwc.testweb.dao;

import org.springframework.stereotype.Repository;
import org.zwc.testweb.domain.Topic;

import zwc.framwork.GenericBaseDao;
import zwc.framwork.Page;

@Repository
public class TopicDao extends GenericBaseDao<Topic, Integer>{
	
	/**
	 * 获取话题的数量
	 * @return
	 */
	public Integer getTopicNum(){
		
		String hql = "select count(t.id) from Topic t";
		
		Integer num = (Integer) getSession().createQuery(hql).uniqueResult();
		
		return num;
		
	}
	
	/**
	 * 根据板块获取精华帖子
	 * @param page
	 * @param BoardId
	 * @return
	 */
	public Page<Topic>  getEssenceTopicsByBoard(Page<Topic> page,Integer BoardId){
		String hql = "from Topic t where t.board.id = ? and t.essence=1 order by t.lastPostTime desc";
		if(page ==null){
			page = new Page<Topic>();
		}
		return findPageByQuerys(page, hql, BoardId);
	}
	
	
	/**
	 * 根据板块获取精华帖子
	 * @param page
	 * @param BoardId
	 * @return
	 */
	public Page<Topic>  getTopicsByBoard(Page<Topic> page,Integer BoardId){
		String hql = "from Topic t where t.board.id = ?  order by t.lastPostTime desc";
		if(page ==null){
			page = new Page<Topic>();
		}
		return findPageByQuerys(page, hql, BoardId);
	}
	
	/**
	 * 
	 * @param page
	 * @param title
	 * @return
	 */
	public Page<Topic>  queryTopicByTitle(Page<Topic> page,String title){
		
		String hql = "from Topic t where t.title = ?  order by t.lastPostTime desc";
		if(page ==null){
			page = new Page<Topic>();
		}
		return findPageByQuerys(page, hql, title);
		
	}
	
	
	
}
