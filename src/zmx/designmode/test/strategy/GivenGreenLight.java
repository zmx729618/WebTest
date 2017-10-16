package zmx.designmode.test.strategy;
/**
 * 妙计二：求吴国太开个绿灯，放行
 * @author zhangwenchao
 *
 */
public class GivenGreenLight implements IStrategy{

	@Override
	public void operate() {
		
		System.out.println("求吴国太开个绿灯，放行！");  
		
	}

}
