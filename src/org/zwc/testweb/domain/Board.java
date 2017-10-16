package org.zwc.testweb.domain;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@Table(name="t_board")
public class Board extends BaseIdEntity {

	/**
	 * 串行化版本号
	 */
	private static final long serialVersionUID = -5713445162979854056L;
	
	
	private String name;
	
	private String description;
	
	private int topicNum;


    public Board() {
		
	}

	public Board(String name, String description, int topicNum) {
		super();
		this.name = name;
		this.description = description;
		this.topicNum = topicNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getTopicNum() {
		return topicNum;
	}

	public void setTopicNum(int topicNum) {
		this.topicNum = topicNum;
	}


	
	
	
	
	
	
	
	

}
