package program.test;
/**
 * 控制CUP的运行效率  
 * CUP利用率 = 一个刷新周期内CPU运行时间/刷新周期总时间（ 一个刷新周期为1S）
 * @author zhangwenchao
 *
 */
public class UseRatio4CPU {
	
	public static void main(String[] args) throws Exception {
		
	//	useRatio50PER();
	   
		sineForCUP();

		


		
	}
	
	
	
	public static void useRatio50PER() throws Exception{
		
		
        int busyTime = 50; //运行时间 50ms
        
        int idleTime =busyTime; //空闲时间50ms
        
        long startTime=0L;   //获取开始时间
        
		while(true){
			startTime=System.currentTimeMillis();   //获取开始时间
			while((System.currentTimeMillis()-startTime)<busyTime){
				;  
			}
			Thread.sleep(idleTime);  //空闲10ms
		}
	}
	
	
	/**
	 * 让CPU画出正弦曲线
	 * @throws Exception 
	 */
	
	public static void  sineForCUP() throws Exception{
		
		final double SPILT = 0.01; // 
		
		final int COUNT = 200;  //
		
		final double PI = 3.14159265;  //pi
		
		final int INTERVAL = 100;   //
		
		
		Long[] busySpan = new Long[COUNT];  
		Long[] idleSpan = new Long[COUNT]; 
		
		int half = INTERVAL/2;
		
		double radian = 0.0;
		
		for(int i=0; i<COUNT; i++){
			
			busySpan[i] = Math.round((half + (Math.sin(PI*radian)*half)));
			
			idleSpan[i] = INTERVAL - busySpan[i];
			
			radian +=SPILT;
			
		}
		
		Long startTime = 0L;
		int j = 0;
		while(true){
			
			j = j%COUNT;
			
			startTime = System.currentTimeMillis(); 
			
			while(System.currentTimeMillis() - startTime <=busySpan[j]){
				; //运行时间
			}
			
			Thread.sleep((Long)idleSpan[j]);  //停止时间
			
			j++;
			
		}
		
		
		
		
		
		
	}
	
	
	
}
