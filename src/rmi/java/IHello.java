package rmi.java;

import java.rmi.Remote;
import java.rmi.RemoteException;
/** 
 * 定义远程接口，必须继承Remote接口， 
 * 其中所有需要远程调用的方法都必须抛出RemoteException异常  
 */ 
public interface IHello extends Remote {
	
	public String sayHello(String name) throws RemoteException;   
	public int sum(int a, int b)throws RemoteException; 


}
