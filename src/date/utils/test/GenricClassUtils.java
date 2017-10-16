package date.utils.test;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenricClassUtils {
	
	/**
	 * 获得一个泛型类的实际泛型类型
	 */
    public static <T> Class<T> getGenricClassType(Class clazz){
    	
    	Type type = clazz.getGenericSuperclass();   //返回此 Class 所表示的实体（类、接口、基本类型或 void）的直接超类的 Type
    	
    	if(type instanceof ParameterizedType){ //如果type是ParameterizedType：表示参数化类型
    		ParameterizedType pt = (ParameterizedType)type;
    		Type[] types = pt.getActualTypeArguments(); //返回表示此类型实际类型参数的 Type 对象的数组
    		if(types.length > 0 && types[0] instanceof Class){
    			
    			return (Class)types[0];
    		}
    	}
    	return (Class)Object.class;
    }
}
