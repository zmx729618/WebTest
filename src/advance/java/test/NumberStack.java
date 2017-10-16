package advance.java.test;

public class NumberStack<T extends Number> {
	
	private Number[] stack = new Number[100];
	
	private int ptr = -1;
	
	void push(T data){
		
		ptr++;
		stack[ptr] = data;
		
	}
	
	@SuppressWarnings("unchecked")
	T pop(){
		return (T)stack[ptr--];
	}
	
	
    public static void dumpStack(NumberStack<?> stack){
    	
    	for(Number n : stack.stack){
    		System.out.println(n);
    	}
    	
    }
}
