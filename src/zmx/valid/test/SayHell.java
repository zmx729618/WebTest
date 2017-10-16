package zmx.valid.test;

import zmx.valid.test.Yts.YtsType;

@Yts(classType =YtsType.util)
public class SayHell {

	@HelloWorld(name = " 小明 ")
	@Yts
	public void sayHello(String name){
		if(name == null || name.equals("")){
			System.out.println("hello world!");
		}else{
			System.out.println(name + "say hello world!");
		}
	}
}
