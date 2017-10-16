package zmx.event.test;

import java.util.EventListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 事件源
 * @author zhangwenchao
 *
 */
public class EventSourceObject {
	
	private String name;  
    //监听器容器  
    private Set<EventListener> listener;  
	public EventSourceObject(){  
	        this.listener = new HashSet<EventListener>();  
	        this.name = "defaultname";  
	}  
	//给事件源注册监听器  
	public void addCustomListener(CustomEventListener cel){  
	        this.listener.add(cel);  
	} 
	
	//当事件发生时,通知注册在该事件源上的所有监听器做出相应的反应（调用回调方法）  
	protected void notifies(){  
        CustomEventListener cel = null;  
        Iterator<EventListener> iterator = this.listener.iterator();  
        while(iterator.hasNext()){  
            cel = (CustomEventListener)iterator.next();  
            cel.fireCustomEvent(new CustomEvent(this));  
        }  
    }
	
	public String getName() {  
	    return name;  
	} 
	
	//模拟事件触发器，当成员变量name的值发生变化时，触发事件。  
	public void setName(String name) {  
        if(!this.name.equals(name)){  
            this.name = name;  
            notifies();  
        }        
	} 
	
	
	
	public static void main(String[] args) {
		
		
        EventSourceObject object = new EventSourceObject();  
        //注册监听器  
        object.addCustomListener(new CustomEventListener(){  
            @Override  
            public void fireCustomEvent(CustomEvent e) {  
                super.fireCustomEvent(e);  
            }  
        });  
        //触发事件  
        object.setName("eric"); 

		
	}


}
