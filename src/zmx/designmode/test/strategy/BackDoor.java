package zmx.designmode.test.strategy;

/**
 * 妙计一：找乔国老帮忙，使孙权不能杀刘备。
 * @author zhangwenchao
 *
 */
public class BackDoor implements IStrategy{

	@Override
	public void operate() {
		System.out.println("找乔国老帮忙，让吴国太给孙权施压，使孙权不能杀刘备！"); 	
	}

}
