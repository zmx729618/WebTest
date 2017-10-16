package zmx.spring;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
/**
 * 定义StudentAddListener监听器
 * @author zhangwenchao
 *
 */
public class StudentAddListener implements ApplicationListener {


	@Override
	public void onApplicationEvent(ApplicationEvent  _event) {
        // 1.判断是否是增加学生对象的事件   
        if (!(_event instanceof StudentAddEvent)) {  
            return;  
        }  
  
        // 2.是增加学生事件的对象，进行逻辑处理，比如记日志、积分等  
        StudentAddEvent studentAddEvent = (StudentAddEvent) _event;  
        System.out.println("增加了学生:::" + studentAddEvent.getStudentName()); 
		
	}
	
	

}
