package test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializableTest implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public static int staticVar = 5;

	public static void main(String[] args) {
		try {
			//初始时staticVar为5
			ObjectOutputStream out = new ObjectOutputStream(
					new FileOutputStream("result.obj"));
			out.writeObject(new SerializableTest());
			out.close();

			//序列化后修改为10
			SerializableTest.staticVar = 10;
			
			SerializableTest t2 =  new SerializableTest();

			ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
					"result.obj"));
			SerializableTest t = (SerializableTest) oin.readObject();
			oin.close();
			
			//再读取，通过t.staticVar打印新的值
			System.out.println(SerializableTest.staticVar);
			System.out.println(t.staticVar);
			System.out.println(t2.staticVar);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


}
