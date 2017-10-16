package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Vector;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import program.test.ClonabledObj;

public  class Advance implements Serializable{
	
	
	
	
	private static final long serialVersionUID = 1516747721305415092L;
	

	public static  void  main(String[] args) throws Exception   {
		

		/*int i =  80;
		String s1 = String.valueOf(i<100? 90 : 100);
		String s2 = String.valueOf(i<100? 90 : 100.0);  
		System.out.println(s1);
		System.out.println(s2);
		System.err.println(s1.endsWith(s2));*/
		
		/*int count = 0;
		for(int i=0; i<10;i++){
			count = count++;
			
		}
		
		System.out.println(count);*/
		
		
/*		//获取一个javascript执行引擎
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("javascript");
		
		//建立上下文变量
		Bindings bind = engine.createBindings();
		
		bind.put("factor", 3);  
		
		//绑定上下文 作用域 是当前引擎范围
		engine.setBindings(bind, ScriptContext.ENGINE_SCOPE);
		
		Scanner input = new Scanner(System.in);
		
		while(input.hasNextInt()){   //JVM不需要重启，
			
			int first = input.nextInt();
			int second = input.nextInt();
			
			System.out.println("输入参数："+first +","+second);
			
			engine.eval(new FileReader("D:\\Workspaces\\projects\\testWeb\\src\\test\\model.js"));
			
			if(engine instanceof Invocable){
				
				Invocable in = (Invocable)engine;
				
				Double result =(Double)in.invokeFunction("formula", first, second);
				
				System.out.println("运算结果："+result);
			}
			
		}*/
		
		/*//java源代码
		String sourceStr = " package test; public class Hello{public String sayHello(String name){ return \"hello, \"+name+\"!\";}}";
		
		//类名及文件名
		String clazzName = "Hello";
		
		//方法名
		String methodName = "sayHello";
		
		//当前编译器
		JavaCompiler cmp =  ToolProvider.getSystemJavaCompiler();
		
		//java标准文件管理器
		StandardJavaFileManager fm = cmp.getStandardFileManager(null, null, null);
		
		//java文件对象
		JavaFileObject jfo = new StringJavaObject(clazzName,sourceStr);
		
		//编译参数，类似于javac <options>中的options
		List<String> options = new ArrayList<String>();
		
		//编译文件的存放地方，注意：此处是为eclipse工具特设的
		options.addAll(Arrays.asList("-d","D:\\Workspaces\\projects\\testWeb\\WebRoot\\WEB-INF\\classes"));
		
		//要编译的单元
		List<JavaFileObject> jfos = Arrays.asList(jfo);
		
		//设置编译环境
		JavaCompiler.CompilationTask task = cmp.getTask(null, fm, null, options, null, jfos);
		
		//编译成功
		if(task.call()){
			
			//反射生成对象
			Object obj = Class.forName("test.Hello").newInstance();
			
			//得到class对象
			Class<? extends Object> clazz = obj.getClass();
			
			//调用sayHello方法
			Method m = clazz.getMethod(methodName, String.class);
			
			String result = (String)m.invoke(obj, "Dynamic Compilation");
			
			System.out.println(result);
			
		}
		*/
		
		
	/*	System.out.println("人类寿命的极限是："+Constant.MAX_AGE);
		
		NumberFormat f = new DecimalFormat("0000.00##");
		System.out.println(f.format(111.00-9.6));
		long distance = 1L*Constant.LIGHT_SPEED*60*8;
		
		System.out.println(distance);
		
		
		
		BigDecimal d = new BigDecimal(88888);
		
		BigDecimal r = new BigDecimal(0.001875*3);
		
		BigDecimal i = d.multiply(r).setScale(2, RoundingMode.HALF_EVEN);  //四舍六入五考虑
		
		System.out.println("季利率是:"+i);*/
		
		
		
	/*
	  
	 	Scanner input = new Scanner(System.in);
		while(input.hasNextInt()){
			int ii = input.nextInt();
			System.out.println("=========="+ii+"的相等判断=============");
			
			//new产生的Integer对象
			Integer i = new Integer(ii);
			Integer j = new Integer(ii);
			
			System.out.println("new产生的对象："+(i==j));
			
			//基本类型转换为包装类型
			i = ii;
			j = ii;
			
			System.out.println("基本类型转换为包装类型产生的对象："+(i==j));
					
			
			//通过静态方法产生的对象
			i= Integer.valueOf(ii);
			j = Integer.valueOf(ii);
			
			System.out.println("通过静态方法产生的对象产生的对象："+(i==j));
			
		}
		
	*/
		
		
       /*  Random r = new Random();
         for(int i=0;i<3;i++){
        	System.out.println(r.nextInt()); 
         }
         */
		
       /*		
		String ss = "$是$";
		String result =  ss.replace("$", "");
		//String result =  ss.replaceAll("\\$", "");
		System.out.println(result);
		*/
		
	/*	String str = "汉字";
		
		byte[] b = str.getBytes("UTF-8");

		System.out.println(new String(b));
		
		*/
		
	   /*
	  	String[] strs = {"张三(Z)","李四(L)","王五(W)"};
		
		Comparator c = Collator.getInstance(Locale.CHINA);
		
		Arrays.sort(strs,c);
		
		int i=0;
		
		for(String str : strs){
			System.out.println((++i)+"："+str);
		}*/
		
		
        /*		
        Integer[] data =  {1,2,3,4,5};
		
		List<Integer> list = Arrays.asList(data);   // 原始类型不能作为Arrays.asList()的输入参数。
		
		System.out.println("列表长度："+list.size()); 
		
		//list.add(6);   // Arrays.asList(data)生成的列表不能添加 java.lang.UnsupportedOperationException
		
	   */
		
	/*	
		List<String> c1 = new ArrayList<String>();
		c1.add("A");
		c1.add("B");
		
		List<String> c2 = new ArrayList<String>(c1);
		
		
		List<String> c3 = c1.subList(0, c1.size());
		System.out.println(c1.equals(c2));
		
		c3.add("C");
		System.out.println(c1.equals(c2));
		
		System.out.println(c1==c3);
		
		System.out.println(c1.equals(c3));
		
		*/
		
		/*
		// 初始化一个固定长度，不可变列表
		List<Integer> initData =  Collections.nCopies(100, 0);
		
		//转换为可变列表
		List<Integer> list = new ArrayList<Integer>(initData);
		
		
		/*
		 for(int i=0; i<list.size();i++){
		
			if(i>=20 && i<30){
				list.remove(i);
			}
	
		}
		
		list.subList(20, 30).clear();
		System.out.println(initData.size());
		
		list.add(0, 3);
		list.set(1, 4);
			
		System.out.println(list.size());
		System.out.println(list.get(0) +" "+ list.get(1));
		
		
		*/
		
		/*
		ClonabledObj obj = new ClonabledObj();
		obj.setId("10222");
		
		
		
		ClonabledObj clonabledObj = (ClonabledObj)obj.clone();
		
		System.out.println(obj == clonabledObj);
		
		System.out.println(obj.getId());
		
		*/
		
       /* Map<String,String> map = new HashMap<String,String>();
        
        final Runtime rt = Runtime.getRuntime();
        
        //JVM终止前记录内存信息
        
		rt.addShutdownHook(new Thread(){
			    @Override
				public void run(){
			    	
					StringBuffer sb = new StringBuffer();
					
					long heapMaxSize =  rt.maxMemory() >> 20; //将单位转换为MB
					
					sb.append("最大可用内存为："+heapMaxSize+"M\n");
					
					long total = rt.totalMemory() >> 20; 
					
					sb.append("堆内存为："+total+"M\n");
					
                    long free = rt.freeMemory() >> 20; 
					
					sb.append("空闲内存为："+free+"M\n");
					
					System.out.println(sb.toString());
				}	    
	    });
		
		for(int i=0; i<392317;i++){
			map.put("key"+i, "value"+i);
		}*/
		
/*		//火车票列表
		final List<String> tickets =  new Vector<String>();
		
		//初始化票据池
		for(int i=0; i<100000; i++){
			tickets.add("火车票"+i);
		}
		
		//退票
		Thread returnThread =  new Thread(new  Runnable() {
			
			@Override
			public void run() {
				
				while(true){
					tickets.add("火车票" + new Random().nextInt());
					System.out.println(Thread.currentThread().getId()+":"+tickets.size());
				}
				
			}
		});
		
		//售票
		Thread saleThread =  new Thread(new  Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getId()+":"+tickets.size());
				for(String ticket : tickets){
					tickets.remove(ticket);
				}
				
				System.out.println("for运行完毕");
				throw new RuntimeException("线程执行完毕");
	
			}
		});
		
		saleThread.start();
		returnThread.start();
		*/
		Queue<String> q = new ArrayDeque<String>(5); 
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(5);
		for(int i=0; i<10; i++){
			bq.add("AA");
		}
		
	
			

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	


}
