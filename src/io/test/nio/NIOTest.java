package io.test.nio;


import java.util.Scanner;
/**
 * 测试方法
 * @author yangtao__anxpp.com
 * @version 1.0
 */
public class NIOTest {
	//测试主方法
	public static void main(String[] args) throws Exception{
		//运行服务器
		NIOServerNormal.start();
		//避免客户端先于服务器启动前执行代码
		Thread.sleep(100);
		//运行客户端 
		NIOClientNormal.start();
		while(NIOClientNormal.sendMsg(new Scanner(System.in).nextLine()));
	}
}
