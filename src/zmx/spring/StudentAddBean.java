package zmx.spring;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentAddBean implements ApplicationContextAware {


	
    /** 
     * 定义Spring上下文对象 
     */  
    private ApplicationContext m_applicationContext = null;  
  
    /* 
     * (non-Javadoc) 
     *  
     * @see 
     * org.springframework.context.ApplicationContextAware#setApplicationContext 
     * (org.springframework.context.ApplicationContext) 
     */
    @Override
    public void setApplicationContext(ApplicationContext _applicationContext)  
            throws BeansException {  
        this.m_applicationContext = _applicationContext;  
  
    }  
  
    /** 
     * 增加一个学生 
     *  
     * @param _sStudentName 
     */  
    public void addStudent(String _sStudentName) {  
        // 1.构造一个增加学生的事件   
        StudentAddEvent aStudentEvent = new StudentAddEvent(  
                m_applicationContext, _sStudentName);  
        // 2.触发增加学生事件   
        m_applicationContext.publishEvent(aStudentEvent);  
    }  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        String[] xmlConfig = new String[] { "zmx/spring/applicationContext.xml" };  
        // 使用ApplicationContext来初始化系统  
        ApplicationContext context = new ClassPathXmlApplicationContext(  
                xmlConfig);  
        StudentAddBean studentBean = (StudentAddBean) context  
                .getBean("StudentAddBean");  
        studentBean.addStudent("我是第一个学生");  
        studentBean.addStudent("第二个学生已经添加");  
  
    }

}
