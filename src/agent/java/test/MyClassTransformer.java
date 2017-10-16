package agent.java.test;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class MyClassTransformer implements ClassFileTransformer {  //自定义一个类转换器，可以改变Class字节码

	@Override
	public byte[] transform(ClassLoader loader, String className,
			Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
			byte[] classfileBuffer) throws IllegalClassFormatException {
		
		System.out.println("hello,"+className);
		return null;
	}

}
