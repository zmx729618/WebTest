package test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class HashStack extends Stack{
	
	private static final String[]  strArray= {"aaa","bbb","ccc"};
	
	public static final List<String> VALUES = Collections.unmodifiableList(Arrays.asList(strArray));
	
	private int hashCode;
	
	
	
	public static void main(String[] args) {
		
		Stack s = new Stack();
		HashStack hs = new HashStack();
		System.out.println( s instanceof Stack);
		System.out.println( s instanceof HashStack);
		System.out.println( hs instanceof Stack);
		System.out.println( hs instanceof HashStack);
		
		
	Set<BigDecimal> hashSet = new  HashSet<BigDecimal>();
	
	Set<BigDecimal> treeSet = new TreeSet<BigDecimal>();
	
	hashSet.add(new BigDecimal("1.0"));
	hashSet.add(new BigDecimal("1.00"));
	treeSet.add(new BigDecimal("1.0"));
	treeSet.add(new BigDecimal("1.00"));
	
		
	System.out.println(hashSet.size());	
	System.out.println(treeSet.size());
	strArray[2]= "DDD";
	for(String ss : strArray){
		System.out.println(ss);
	}
	
	System.out.println(VALUES);
	
	
	
		
		
	}

}
