package zmx.spring;

import org.springframework.context.ApplicationEvent;
/**
 * 定义StudentAddEvent监听事件
 * @author zhangwenchao
 *
 */
public class StudentAddEvent extends ApplicationEvent{

	

	private static final long serialVersionUID = -8166410280997185181L;
	
    /** 
     * 学生姓名 
     */  
    private String m_sStudentName;
    
    
    public StudentAddEvent(Object source) {
		super(source);
	}
  
    /** 
     * @param source 
     */  
    public StudentAddEvent(Object source, String _sStudentName) {  
        super(source);  
        this.m_sStudentName = _sStudentName;  
    }  
  
    /** 
     * 获取学生姓名 
     *  
     * @return 
     */  
    public String getStudentName() {  
        return m_sStudentName;  
    } 



}
