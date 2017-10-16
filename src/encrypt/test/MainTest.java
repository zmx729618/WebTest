package encrypt.test;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class MainTest {
     
	
	
	  public static void main(String[] args) throws Exception {
		  
		  //md5
		  MessageDigest md5 = MessageDigest.getInstance("md5"); 
		  byte[] cipherData = md5.digest("中国ren".getBytes());
		  StringBuilder builder = new StringBuilder();
		  for(byte b :cipherData){
			 
			  String toHexStr = Integer.toHexString(b & 0xff);
			  builder.append(toHexStr.length() == 1 ? "0" + toHexStr : toHexStr);  
		  }
		  System.out.println(builder.toString());  
		  
		  //base64
		  BASE64Encoder encoder = new BASE64Encoder(); 
		  String cipherText = encoder.encode("中国ren".getBytes());
		  System.out.println(cipherText);  
		  
		  
		  BASE64Decoder decoder = new BASE64Decoder();  
		  String plainText = new String(decoder.decodeBuffer(cipherText)); 
		  System.out.println("plainText : " + plainText);
		  
		  
		  //des
		  DESKeySpec keySpec = new DESKeySpec("12345678".getBytes());  
		  SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("des");  
		  SecretKey secretKey = keyFactory.generateSecret(keySpec);
		  Cipher cipher = Cipher.getInstance("des");  
		  
		  cipher.init(Cipher.ENCRYPT_MODE, secretKey, new SecureRandom());  
		  cipherData = cipher.doFinal(plainText.getBytes());
		  cipherText = new BASE64Encoder().encode(cipherData);
          System.out.println(cipherText);
          
          cipher.init(Cipher.DECRYPT_MODE, secretKey, new SecureRandom());  
          byte[] plainData = cipher.doFinal(cipherData);  
          System.out.println("plainText : " + new String(plainData));
          
          
          
          //RSA
          KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("rsa");  
          keyPairGenerator.initialize(1024);  
          KeyPair keyPair = keyPairGenerator.generateKeyPair();  
                
          PublicKey publicKey = keyPair.getPublic();  
          PrivateKey privateKey = keyPair.getPrivate();  
          cipher = Cipher.getInstance("rsa");  
          SecureRandom random = new SecureRandom();  
          cipher.init(Cipher.ENCRYPT_MODE, privateKey, random);  
          cipherData = cipher.doFinal(plainText.getBytes());  
          System.out.println("cipherText : " + new BASE64Encoder().encode(cipherData));  

          cipher.init(Cipher.DECRYPT_MODE, publicKey, random);  
          plainData = cipher.doFinal(cipherData);  
          System.out.println("plainText : " + new String(plainData));  
            
          Signature signature  = Signature.getInstance("MD5withRSA");  
          signature.initSign(privateKey);  
          signature.update(cipherData);  
          byte[] signData = signature.sign();  
          System.out.println("signature : " + new BASE64Encoder().encode(signData));  

          signature.initVerify(publicKey);  
          signature.update(cipherData);  
          boolean status = signature.verify(signData);  
          System.out.println("status : " + status);



		  

	  }	 
}
