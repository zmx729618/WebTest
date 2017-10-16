package advance.java.test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Test {
	
	public static void main(String[] args) {
		
/*		
			System.out.println(Words.FIRST + " " +
			Words.SECOND + " " +
			Words.THIRD);*/
		
		
/*		long x = Long.MAX_VALUE;
		double y = (double) Long.MAX_VALUE;
		long z = Long.MAX_VALUE - 1;
		System.out.print((x == y) + ""); // Imprecise!
		System.out.print((y == z) + ""); // Imprecise!
		System.out.println(x == z);*/
		
	}

/*	public static  void main(String[] a){
		Thread t = new Thread(){
		     public void run(){ pong(); }
		};
		t.start();
		System.out.print( "Ping" );
	}
	static synchronized void pong(){
		   System.out.print( "Pong" );
	}*/
	
	

/*		Random rnd = new Random();
		Integer[ ] arr = new Integer[100];
		for (int i = 0; i < arr.length; i++)
		arr[i] = rnd.nextInt();
		Comparator<Integer> cmp = new Comparator<Integer>() {
		public int compare(Integer i1, Integer i2) {
			return (i2 < i1 ? -1 : (i2 == i1 ? 0 :1));
		}
		
		};
		Arrays.sort(arr, cmp);
		System.out.println(order(arr));
		}
		enum Order { ASCENDING, DESCENDING, CONSTANT, UNORDERED };
		static Order order(Integer[] a) {
			boolean ascending = false;
			boolean descending = false;
			for (int i = 1; i < a.length; i++) {
			      ascending |= a[i] > a[i-1];
			      descending |= a[i] < a[i-1];
			}
			if (ascending && !descending)
			      return Order.ASCENDING;
			if (descending && !ascending)
			      return Order.DESCENDING;
			if (!ascending)
			      return Order.CONSTANT; // All elements equal
			
			return Order.UNORDERED; // Array is not sorted
		}*/

		
		
		
		
	/*	final int MODULUS = 3;
		int[] histogram = new int[MODULUS];
		// Iterate over all ints (Idiom from Puzzle 26)
		int i = Integer.MIN_VALUE+1;
		do {
		    histogram[Math.abs(i) % MODULUS]++;
		} while (i++ != Integer.MAX_VALUE);
		for (int j = 0; j < MODULUS; j++)
		System.out.println(histogram[j] + " ");
		*/
	
		
/*		Test moreNames = new Test();
		System.out.println(moreNames.size());*/
		
/*		Map<String, String> m = new IdentityHashMap<String, String>();
		m.put("Mickey", "Mouse");
		m.put("Mickey", "Mantle");
		System.out.println(m.size());*/
		
/*		Calendar cal = Calendar.getInstance();
		cal.set(1999, Calendar.DECEMBER, 30);
		System.out.print(cal.get(Calendar.YEAR) + " ");
		System.out.print(cal.get(Calendar.MONTH) + 1+ " ");
		System.out.println(cal.get(Calendar.DAY_OF_MONTH));*/
		
		
		
/*		String[]s ={"111","222","333"};
		String[][] ss = {{"111","222","333"},{"222","333","444"},{"555","666","777"}};
		System.out.println(Arrays.toString(s));
		System.out.println(Arrays.deepToString(ss));*/
/*		String s = null;
		System.out.println(s instanceof String);*/
		
		
	/*	BigInteger fiveThousand = new BigInteger("5000");
		BigInteger fiftyThousand = new BigInteger("50000");
		BigInteger fiveHundredThousand = new BigInteger("500000");
		BigInteger total = BigInteger.ZERO;
		total.add(fiveThousand);
		total.add(fiftyThousand);
		total.add(fiveHundredThousand);
		System.out.println(total);*/
		
		
/*		BigInteger fiveThousand = new BigInteger("5000");
		BigInteger fiftyThousand = new BigInteger("50000");
		BigInteger fiveHundredThousand = new BigInteger("500000");
		BigInteger total = BigInteger.ZERO;
		total = total.add(fiveThousand);
		total = total.add(fiftyThousand);
		total = total.add(fiveHundredThousand);
		System.out.println(total);*/
		

	
/*	private static final int CURRENT_YEAR =Calendar.getInstance().get(Calendar.YEAR);
	public static final Test INSTANCE = new Test();
	private final int beltSize;
	
	private Test() {
	beltSize = CURRENT_YEAR - 1930;
	}
	public int beltSize() {
	return beltSize;
	}
	public static void main(String[] args) {
	System.out.println("Elvis wears a size " +
	INSTANCE.beltSize() + " belt.");
	}*/
/*	public static final int END = Integer.MAX_VALUE;
	public static final int START = END - 100;
	public static void main(String[] args) throws Exception {
		
		System.out.println("Hello world");
		Runtime.getRuntime().addShutdownHook(
			new Thread() {
			   public void run() {
			     System.out.println("Goodbye world");
			   }
			}
		);
		System.exit(0);
		*/
		/*
			try {
				System.out.println("Hello world");
			} catch (Exception e) {
				System.out.println("I've never seen println fail!");
				e.printStackTrace();
			}*/
		
			   
			
		
		
/*		System.out.println(Float.MAX_VALUE);
		final int START = 2000000000;
		int count = 0;
		for (float f = START; f < START + 50; f++)
		count++;
		System.out.println(count);*/
							
/*		int count = 0;
		for (long i = START; i <= END; i++)
		count++;
		System.out.println(count);*/
	
		
		/*StringBuffer word = null;
		switch(rnd.nextInt()) {
		   case 1:  word = new StringBuffer('P');
		   case 2:  word = new StringBuffer('G');
		   default: word = new StringBuffer('M');
		}
		word.append('a');
		word.append('i');
		word.append('n');
		System.out.println(word);*/
		
		
		
/*		System.out.print("iexplore:");
 http:  //www.google.com;
		System.out.println(":maximize");*/
		
		
		
		
/*		System.out.println(Test.class.getName().replaceAll("\\.", "/")+".class");
		System.out.println(Test.class.getName().replaceAll(Pattern.quote("."), "/")+".class");
		System.out.println(Pattern.quote("."));
		
		System.out.println(Test.class.getName().replaceAll(Pattern.quote("."),Matcher.quoteReplacement(File.separator))+".class");*/
/*		System.out.println(java.nio.charset.Charset.defaultCharset());
		byte bytes[] = new byte[256];
		for (int i = 0; i < 256; i++)
		bytes[i] = (byte)i;
		
		for(byte b: bytes){
			System.out.print((char)b);
		}
		*/
	/*	System.out.println();
	//	String str = new String(bytes);
		String str = new String(bytes, "ISO-8859-1");
		for (int i = 0, n = str.length(); i < n; i++)
		System.out.print((int)str.charAt(i) + " ");*/
		
		
		
		
/*		char c = '\n';
		System.out.println(c);*/
	/*	char c = 0x000A;
		System.out.println(c);*/
/*		System.out.print("Hell");
		System.out.println("o world");*/
		
	//	System.out.println("a\u0022.length()+\u0022b".length());
	//	System.out.println("a\".length()+\"b");
		/*final String pig = "length: 10";
		final String dog = "length: " + pig.length();
		System.out. println("Animals are equal: "
		+ (pig == dog));*/
		
/*		String letters = "ABC";
		char[] numbers = {'1', '2', '3'};
		System.out.println(numbers);
		System.out.println(letters + " easy as " + numbers);*/
		
//		System.out.print("2 + 2 = " + 2+2);

/*		char x = 'X';
		int i = 0;
		System.out.println(true ? x : 0);
		System.out.println(false ? i : x);*/
        
		
/*		System.out.println(Long.toHexString(0x100000000L + 0xcafebabe));
		
		System.out.println(Long.toHexString(0x100000000L + 0xcafebabeL));*/
		
//		System.out.println(Runtime.getRuntime().availableProcessors());
		
		
/*		System.out.println((-1)%2==1);
		System.out.println((1)%2==1);
		
		System.out.println((-1)%2!=0);
		System.out.println((1)%2!=0);
		
		System.out.println(2.00 - 1.10);
		System.out.println(new BigDecimal("2.00"));
		System.out.println(new BigDecimal("1.10"));
		System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.10")));
		*/
		/*final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
		final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;
		System.out.println(MICROS_PER_DAY/MILLIS_PER_DAY);*/
		
		
	/*	final long MICROS_PER_DAY = 24L * 60 * 60 * 1000 * 1000;
		final long MILLIS_PER_DAY = 24L * 60 * 60 * 1000;
		System.out.println(MICROS_PER_DAY/MILLIS_PER_DAY);*/
		
	  /*
	    Stack stack = new Stack();
		stack.push(2);
		stack.push("test String");
		
		for(int i=0;i<2; i++){
			
			System.out.println(stack.pop());
			
		}
		*/
		
	  /*
	    NumberStack<Long> numberStack = new  NumberStack<Long>();
		numberStack.push(10L);
		numberStack.push(12L);
		NumberStack.dumpStack(numberStack);
	  */
		
		
		/*Integer a  =  new  Integer(100);
		int b = 100;
		int c = a+b;
		System.out.println(c);*/

		
/*		System.out.println("最大值："+Integer.MAX_VALUE  +  "最小值:"+Integer.MIN_VALUE);
		System.out.println("最大值："+Double.MAX_VALUE  +  "最小值:"+Double.MIN_VALUE);
		System.out.println("最大值："+Float.MAX_VALUE  +  "最小值:"+Float.MIN_VALUE);
		System.out.println("最大值："+Character.MAX_VALUE  +  "最小值:"+Character.MIN_VALUE);
		
		Integer n1 = new Integer(0x100);
		Integer n2 = new Integer(0x1);
		
		System.out.println(n1);
		System.out.println(n2);
		
		n1 = Integer.rotateRight(n1, 1);
	    n2 = Integer.rotateLeft(n2, 1);
	    
		System.out.println(n1);
		System.out.println(n2);*/


}
