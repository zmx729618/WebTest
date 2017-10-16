package jvm.java.test;

public class JVMGCTest {
	private static final int _1MB = 1024*1024;
	/**
	 * GC测试
	 */
	//VM参数： -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails
	//解释：        堆区  ：最小20M    最大20M  其中新生代总共 10M   Eden：survivor = 8:1  所以新生到可用9M
	public static void testAllocation(){
			
		byte[] allocation1,allocation2,allocation3,allocation4;
		allocation1 = new  byte[2*_1MB];
		allocation2 = new  byte[2*_1MB];
		allocation3 = new  byte[2*_1MB];
		allocation4 = new  byte[3*_1MB];
		
	}
	
	/**
	 * 大对象直接分配到oldGen
	 * VM参数： -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:+PrintGCDetails
	 * -XX:PretenureSizeThreshold=4194304 表示超过4M的大对象直接分配到OldGen  只对部分回收器有效
	 */
	public static void testPretenureSizeThreshold(){
		
		byte[] allocation;
		allocation = new byte[4*_1MB];
	}
	
	
	/**
	 * 长期存活的对象进入老年代
	 * VM参数： -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintGCDetails
	 * -XX:+PrintTenringDistribution
	 * -XX:MaxTenuringThreshold=1     1代GC之后对象进入老年代
	 * -XX:MaxTenuringThreshold=15    15代GC之后对象进入老年代
	 * @param args
	 */
	public static  void testTenuringThreshold(){
		
		byte[] allocation1,allocation2,allocation3;
		
		allocation1 = new  byte[_1MB/4];
		allocation2 = new  byte[4*_1MB];
		
		allocation3 = new  byte[4*_1MB];
		allocation3 = null;
		allocation3 = new  byte[4*_1MB];
		
	}
	
	
	
	
	public static void main(String[] args) {
	//	testAllocation();
	//	testPretenureSizeThreshold();
		testTenuringThreshold();
	}

}
