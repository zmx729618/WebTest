package zmx.cglib.test;

import net.sf.cglib.proxy.Enhancer;

public class LoaderBean {  
    private String loaderName;  
    private int loaderValue;  
    private PropertyBean propertyBean;  
    public LoaderBean(){  
        this.loaderName="loaderNameA";  
        this.loaderValue=123;  
        this.propertyBean=createPropertyBean();  
    }  
    protected PropertyBean createPropertyBean(){  
        Enhancer enhancer=new Enhancer();  
        enhancer.setSuperclass(PropertyBean.class);  
        return (PropertyBean)enhancer.create(PropertyBean.class,new ConcreteClassLazyLoader());  
    }
	public String getLoaderName() {
		return loaderName;
	}
	public void setLoaderName(String loaderName) {
		this.loaderName = loaderName;
	}
	public int getLoaderValue() {
		return loaderValue;
	}
	public void setLoaderValue(int loaderValue) {
		this.loaderValue = loaderValue;
	}
	public PropertyBean getPropertyBean() {
		return propertyBean;
	}
	public void setPropertyBean(PropertyBean propertyBean) {
		this.propertyBean = propertyBean;
	} 
	
	
	public static void main(String[] args) {
		LoaderBean loader=new LoaderBean();  
		System.out.println(loader.getLoaderName());  
		System.out.println(loader.getLoaderValue());  
		PropertyBean propertyBean=loader.getPropertyBean();//访问延迟加载对象  
		System.out.println(propertyBean.getPropertyName());  
		System.out.println(propertyBean.getPropertyValue());  
		System.out.println("after...");  
		//当再次访问延迟加载对象时,就不会再执行回调了  
		System.out.println(propertyBean.getPropertyName()); 
		System.out.println(propertyBean.getPropertyValue());

	}
 
}
