package test;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

public class InstrumentedHashSet<E> extends HashSet<E> {
	
	private int addCount = 0;
	
	public InstrumentedHashSet() {}
	
	public InstrumentedHashSet(int initCap,float loadFactor){
		super(initCap, loadFactor);
	}
	
	@Override
	public boolean add(E e){
		boolean result = super.add(e);
		if(result){
			addCount++;
		}
		
		return result;
	}
	
	public boolean addAll(Collection<? extends E> c){
		
	//	addCount += c.size();
		return super.addAll(c);
		
	}
	
	public  int  getAddcount(){
		
		return addCount;
		
	}
	
	
	public static void main(String[] args) {
		
		InstrumentedHashSet<String>  ihs = new InstrumentedHashSet<String>();
		ihs.addAll(Arrays.asList("aaa","aaa","aaa"));
		String b = "bbb";
		System.out.println(ihs.addCount);
		
		ihs.addAll(Arrays.asList(b,b,b));
		System.out.println(ihs.addCount);
		System.out.println(ihs);
		
	}

}
