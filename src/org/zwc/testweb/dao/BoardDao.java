package org.zwc.testweb.dao;

import org.springframework.stereotype.Repository;
import org.zwc.testweb.domain.Board;

import zwc.framwork.GenericBaseDao;

@Repository
public class BoardDao extends GenericBaseDao<Board, Integer>{
	
	/**
	 * 获取帖子的数量
	 * @return
	 */
	public Integer getBoardNum(){
		
		String hql = "select count(b.id) from Board b";
		
		Integer num = (Integer) getSession().createQuery(hql).uniqueResult();
		
		return num;
		
	}
	
	
}
