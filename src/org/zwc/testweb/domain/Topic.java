package org.zwc.testweb.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Index;


/**
 * 话题
 * @author zhangwenchao
 *
 */

@Entity
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Table(name="t_topic")
public class Topic extends BaseIdEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3530630795994639431L;
	
	@Index(name="topic_title")
	private String title; 
	
	@ManyToOne(optional=false)
	@JoinColumn(name="board_id")
	private Board board;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="user_id")
	@Index(name="topic_user")
	private User user;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date createtime;  //创建时间
	
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable=false)
	private Date lastPostTime;  //最后回复时间
	
	@Column(nullable=false)
	private int viewNum; //浏览数
	
	@Column(nullable=false)
	private  int replyNum; //回复数
	
	@Column(nullable=false)
	private  int essence=0;  //0：不是精华帖子  1：是精华帖子

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Date getLastPostTime() {
		return lastPostTime;
	}

	public void setLastPostTime(Date lastPostTime) {
		this.lastPostTime = lastPostTime;
	}

	public int getViewNum() {
		return viewNum;
	}

	public void setViewNum(int viewNum) {
		this.viewNum = viewNum;
	}

	public int getReplyNum() {
		return replyNum;
	}

	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}

	public int getEssence() {
		return essence;
	}

	public void setEssence(int essence) {
		this.essence = essence;
	}
	
	
	
	
	
	

}
