package test;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Stack implements Cloneable{
	
	private static final int DEFAULT_INITIAL_CAPACITY=16;
	
	private Object[] elements;
	
	private int size = 0;
	
	public Stack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];			
	}
	
	private void ensureCapacity(){
		if(elements.length == size){
			elements = Arrays.copyOf(elements, 2*size+1);
		}
	}
	
	
	public void push(Object obj){
		
		ensureCapacity();
		elements[size++] = obj;
		
		
	}
	
	public Object pop(){
		
		if(this.size==0){ throw new EmptyStackException();}
		Object result = elements[--size];
		elements[size] =null;  //防止内存泄露，删除数组中的引用，使垃圾回收器回收掉
		return result;
		
		
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		Stack result = (Stack)super.clone();
		result.elements = elements.clone();
		return result;
		
	} 
	
	
	
	
	
	
	
	
	
	

}
