package zmx.designmode.test.strategy;

public class ZhaoYun {
	
	public static void main(String[] args) {
           Context context = null;  
          
        //刚到吴国的时候拆开第一个  
        System.out.println("----------当到大吴国的时候，拆第一个---------------");  
        context = new Context(new BackDoor());  
        context.operate();//拆开执行  
        System.out.println();  
         
        //当刘备乐不思蜀时，拆开第二个  
        System.out.println("----------当刘备乐不思蜀，拆第二个了---------------");  
        context = new Context(new GivenGreenLight());  
        context.operate();//拆开执行  
        System.out.println();  
          
        //孙权的小追兵了，咋办？拆开第三个锦囊  
        System.out.println("----------当孙权的追兵来了，拆开第三个--------------");  
        context = new Context(new BlackEnemy());  
        context.operate();//拆开执行  
        System.out.println(); 

	}

}
