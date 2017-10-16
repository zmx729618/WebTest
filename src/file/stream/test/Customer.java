package file.stream.test;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Customer implements Externalizable{
	
	private int id;
	
	private String creditCard;
	
	//此类为加密和解密提供密码功能
	private static Cipher cipher;
	
	//可以使用此类来根据一个字节数组构造一个 SecretKey
	private static SecretKeySpec secretKeySpec;
	
	public Customer() {
		
		this.id = 0;
				
		this.creditCard="";
		
	}
	
	
	public Customer(int id, String creditCard) {
		this.id = id;
		this.creditCard = creditCard;
	}


	static{
		
		try {
			createCipher();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
		
	}
	
	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCreditCard() {
		return creditCard;
	}


	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}


	private static void createCipher() throws Exception {
		//此类提供（对称）密钥生成器的功能
		KeyGenerator generator = KeyGenerator.getInstance("AES");
		
		generator.init(128);
		
		//密钥
		SecretKey secretKey = generator.generateKey();
		
		byte[] raw = secretKey.getEncoded();
		
		secretKeySpec = new SecretKeySpec(raw, "AES");
		
		cipher = Cipher.getInstance("AES");
		
		
	}
	

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		
		try {
			out.write(id);
			encrypt();
			out.writeUTF(creditCard);
			System.out.println("ID:"+id +" CC: "+creditCard);
		} catch (Exception e){			
			e.printStackTrace();
		}
		
	}



	@Override
	public void readExternal(ObjectInput in) throws IOException,
			ClassNotFoundException {

		try {
			id = in.read();
			String str =  in.readUTF();
			decrypt(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private void encrypt() throws Exception {
		
		cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
		byte[] buff = cipher.doFinal(creditCard.getBytes());
		creditCard = new String(buff);

	}


	private void decrypt(String str) throws Exception {
		cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
		byte[] buff = cipher.doFinal(str.getBytes());
		creditCard = new String(buff);
		
	}
	

}
