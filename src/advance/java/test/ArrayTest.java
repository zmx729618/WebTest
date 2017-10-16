package advance.java.test;

import java.util.Arrays;

import org.junit.Test;

public class ArrayTest {
	public static void main(String[] args) {
		System.out.println("hello");
	}
	
	@Test
	public void testMultiArray(){
		
		int[][] aa = new int[3][];
		aa[0] = new int[]{1,2,3};
		aa[1] = new int[]{2,3,4};
		aa[2] = new int[]{4,5,67};
		
		int[][] bb = aa.clone();
		for(int[] b: bb){
			System.out.println(Arrays.toString(b));
			for(int v : b){
				System.out.print(" "+v);
			}
			System.out.println();
		}
		
		
		System.out.println(aa.getClass().getName());
		
	}

}
