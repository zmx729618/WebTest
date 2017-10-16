package jvm.java.test;

import java.util.ArrayList;
import java.util.List;

public class ConstantPoolOOM {
	// JVM args: -XX:PermSize=2M -XX:MaxPermSize=4M
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		
		Long i = 1L;
		while(true){
			System.out.println(String.valueOf(i++));
			list.add(String.valueOf(i++).intern());
		}
	}

}
