package zmx.event.test;

import java.util.EventObject;

/**
 * 事件驱动模式：包括事件、事件监听器、事件源。
 * @author zhangwenchao
 * 自定义事件类： 用于封装事件源及一些与事件相关的参数. 
 */
public class CustomEvent extends EventObject{

	private static final long serialVersionUID = 5225598291894523778L;
	
	private Object source;//事件源
	
	public CustomEvent(Object source) {
		super(source);
		this.source = source;
	}

	public Object getSource() {
		return source;
	}

	public void setSource(Object source) {
		this.source = source;
	}
	
	
	
	
	
	
	
	

	
	
	

}
