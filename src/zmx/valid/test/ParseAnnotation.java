package zmx.valid.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import zmx.valid.test.Yts.YtsType;

public class ParseAnnotation {

	public void parseMethod(Class clazz) throws Exception{
		 Object obj = clazz.getConstructor(new Class[]{}).newInstance(new Object[]{});
         for(Method method : clazz.getDeclaredMethods()){
                  HelloWorld say = method.getAnnotation(HelloWorld.class);
                  String name = "";
				  if(say != null){
					  name = say.name();
					  method.invoke(obj, name);
				  }
				  
                  Yts yts = (Yts)method.getAnnotation(Yts.class);
                  if(yts != null){
                      if(YtsType.util.equals(yts.classType())){
                          System.out.println("this is a util method");
                      }else{
                          System.out.println("this is a other method");
                      }
                  }
          }
    }
	@SuppressWarnings("unchecked")
	public void parseType(Class clazz) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException{
		Yts yts = (Yts) clazz.getAnnotation(Yts.class);
		if(yts != null){
			if(YtsType.util.equals(yts.classType())){
				System.out.println("this is a util class");
			}else{
				System.out.println("this is a other class");
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		ParseAnnotation parse = new ParseAnnotation();
		parse.parseMethod(SayHell.class);
		parse.parseType(SayHell.class);
	}
	
}
