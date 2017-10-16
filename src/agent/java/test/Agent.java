package agent.java.test;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

/**
 * 使用该自定义代理类，利用java的instrumentation 将转化器添加到JVM中
 * @author zhangwenchao
 *
 */
public class Agent {
	
	public static void premain(String agentArgs, Instrumentation instrumentation) {
		
		ClassFileTransformer transformer = new MyClassTransformer(); //初始化类转化器
		
		instrumentation.addTransformer(transformer);  //向组件中添加类转化器
	}

}
