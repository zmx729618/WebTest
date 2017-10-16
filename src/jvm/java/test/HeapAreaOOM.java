package jvm.java.test;

import java.util.ArrayList;
import java.util.List;



public class HeapAreaOOM {
	
	private static class OOMObject{}
	
	public static void main(String[] args) {
		
		List<OOMObject> lists = new ArrayList<OOMObject>();
		while(true){
			
			//JVM配置参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
			lists.add(new OOMObject());
		}
	}

}
