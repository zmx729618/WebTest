package zmx.event.test;

import java.util.EventListener;

/**
 * 事件监听器
 * @author zhangwenchao
 *
 */
public class CustomEventListener implements EventListener{
	
    //事件发生后的回调方法  
    public void fireCustomEvent(CustomEvent e){  
    	EventSourceObject eObject = (EventSourceObject)e.getSource();  
        System.out.println("My name has been changed!");  
        System.out.println("I got a new name,named \""+eObject.getName()+"\"");    
    } 


}
