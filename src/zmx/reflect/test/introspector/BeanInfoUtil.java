package zmx.reflect.test.introspector;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

public class BeanInfoUtil {
	
    public static void setProperty(UserInfo userInfo, String propertyName)throws Exception{
        PropertyDescriptor propDesc=new PropertyDescriptor(propertyName,UserInfo.class);
        Method methodSetUserName=propDesc.getWriteMethod();
        methodSetUserName.invoke(userInfo, "wong");
        System.out.println("set "+propertyName+":"+userInfo.getUserName());
    }
  
    public static void getProperty(UserInfo userInfo, String propertyName)throws Exception{
        PropertyDescriptor proDescriptor =new PropertyDescriptor(propertyName,UserInfo.class);
        Method methodGetUserName=proDescriptor.getReadMethod();
        Object objUserName=methodGetUserName.invoke(userInfo);
        System.out.println("get "+propertyName+":"+objUserName.toString());
    }
    
    
    public static void setPropertyByIntrospector(UserInfo userInfo, String propertyName)throws Exception{
        BeanInfo beanInfo=Introspector.getBeanInfo(userInfo.getClass());
        PropertyDescriptor[] proDescrtptors=beanInfo.getPropertyDescriptors();
        if(proDescrtptors!=null&&proDescrtptors.length>0){
            for(PropertyDescriptor propDesc:proDescrtptors){
                if(propDesc.getName().equals(propertyName)){
                    Method methodSetUserName=propDesc.getWriteMethod();
                    methodSetUserName.invoke(userInfo, "alan");
                    System.out.println("set "+propertyName+":"+userInfo.getUserName());
                    break;
                }
            }
        }
    }
    
    public static void getPropertyByIntrospector(UserInfo userInfo,String propertyName)throws Exception{
        BeanInfo beanInfo=Introspector.getBeanInfo(userInfo.getClass());
        PropertyDescriptor[] proDescrtptors=beanInfo.getPropertyDescriptors();
        if(proDescrtptors!=null&&proDescrtptors.length>0){
            for(PropertyDescriptor propDesc:proDescrtptors){
                if(propDesc.getName().equals(propertyName)){
                    Method methodGetUserName=propDesc.getReadMethod();
                    Object objUserName=methodGetUserName.invoke(userInfo);
                    System.out.println("get "+propertyName+":"+objUserName.toString());
                    break;
                }
            }
        }
    }


	
	public static void main(String[] args) throws Exception {
		
		UserInfo userInfo = new UserInfo();
		
		BeanInfoUtil.setProperty(userInfo, "userName");
		BeanInfoUtil.getProperty(userInfo, "userName");
		
		BeanInfoUtil.setPropertyByIntrospector(userInfo, "userName");
		BeanInfoUtil.getPropertyByIntrospector(userInfo, "userName");
		
				
		
	}

}
