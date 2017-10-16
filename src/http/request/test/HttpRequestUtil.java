package http.request.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;



/**
 * 发起Https和http Request请求的工具
 * @author zhangwenchao
 *
 */
public class HttpRequestUtil {
	
	/**
	 * 内部类
	 * 证书信任管理器（用于https请求）
     * 这个证书管理器的作用就是让它信任我们指定的证书，下面的代码意味着信任所有证书，不管是否权威机构颁发。
	 * @author zhangwenchao
	 *
	 */
	static class MyX509TrustManager implements  X509TrustManager{

		@Override
		public void checkClientTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {				
		}

		@Override
		public void checkServerTrusted(X509Certificate[] chain, String authType)
				throws CertificateException {						
		}

		@Override
		public X509Certificate[] getAcceptedIssuers() {

			return null;
		}
	}
	
    /** 
     * 发起https请求并获取结果 
     *  
     * @param requestUrl 请求地址 
     * @param requestMethod 请求方式（GET、POST） 
     * @param outputStr 提交的数据 
     * @return JSONObject(通过JSONObject.get(key)的方式获取json对象的属性值) 
     */  
    public static String httpsRequest(String requestUrl, String requestMethod, String outputStr) {  
         
        StringBuffer buffer = new StringBuffer();  
        try {  
        	
            // 创建SSLContext对象，并使用我们指定的信任管理器初始化   
            TrustManager[] tm = { new MyX509TrustManager() };  
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");  
            sslContext.init(null, tm, new java.security.SecureRandom());  
            
            // 从上述SSLContext对象中得到SSLSocketFactory对象   
            SSLSocketFactory ssf = sslContext.getSocketFactory();  
  
            //打开连接
            URL url = new URL(requestUrl);  
            HttpsURLConnection httpUrlConn = (HttpsURLConnection) url.openConnection();  
            httpUrlConn.setSSLSocketFactory(ssf);  
            httpUrlConn.setDoOutput(true);  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setUseCaches(false);  
            
            // 设置请求方式（GET/POST）   
            httpUrlConn.setRequestMethod(requestMethod);  
  
            if ("GET".equalsIgnoreCase(requestMethod)){  
                httpUrlConn.connect();  
            }
            // 当有数据需要提交时   
            if (null != outputStr) {  
                OutputStream outputStream = httpUrlConn.getOutputStream();  
                // 注意编码格式，防止中文乱码   
                outputStream.write(outputStr.getBytes("UTF-8"));  
                outputStream.close();  
            }  
  
            // 将返回的输入流转换成字符串   
            InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
            bufferedReader.close();  
            inputStreamReader.close();  
            // 释放资源   
            inputStream.close();  
            inputStream = null;  
            httpUrlConn.disconnect();              
        } catch (ConnectException e) {  
        	e.printStackTrace();
        } catch (Exception e) {  
        	e.printStackTrace();
        }  
        return buffer.toString();  
    }
    
    
    public static String httpRequest(String requestUrl, String requestMethod, String outputStr) { 
        StringBuffer buffer = null;  
        try {  
            // 建立连接   
            URL url = new URL(requestUrl);  
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();  

            httpUrlConn.setDoOutput(true);  
            httpUrlConn.setDoInput(true);  
            httpUrlConn.setUseCaches(false);
            // 设置请求方式（GET/POST）   
            httpUrlConn.setRequestMethod(requestMethod);
            
            if ("GET".equalsIgnoreCase(requestMethod)){  
                httpUrlConn.connect();  
            }
            
            // 当有数据需要提交时   
            if (null != outputStr) {  
                OutputStream outputStream = httpUrlConn.getOutputStream();  
                // 注意编码格式，防止中文乱码   
                outputStream.write(outputStr.getBytes("UTF-8"));  
                outputStream.close();  
            } 
  
            // 获取输入流   
            InputStream inputStream = httpUrlConn.getInputStream();  
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);  
           //if( httpUrlConn.getResponseCode()==200)
            // 读取返回结果   
            buffer = new StringBuffer();  
            String str = null;  
            while ((str = bufferedReader.readLine()) != null) {  
                buffer.append(str);  
            }  
  
            // 释放资源   
            bufferedReader.close();  
            inputStreamReader.close();  
            inputStream.close();  
            httpUrlConn.disconnect();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return buffer.toString();  
    }  
    
    
    
    
    
    public static void main(String[] args) {
    	
    	/*
    	String httpsUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET"; 
        // 第三方用户唯一凭证   
        String appId = "wx8ef34d51408a8114";  
        // 第三方用户唯一凭证密钥   
        String appSecret = "bdd71a7bba8255234cd149a1d6e1cebb"; 
        
        String httpsRequestUrl = httpsUrl.replace("APPID", appId).replace("APPSECRET", appSecret);  
    	
    	String result =  HttpRequestUtil.httpsRequest(httpsRequestUrl, "GET", null);
   	
    	System.out.println(result);
    	*/
    	String re =HttpRequestUtil.httpsRequest("https://www.baidu.com/s?word=刘德华", "GET", null);
    	
    	//String httpUrl = "http://www.rijiben.com/"; 
    	
    	//String result2 =  HttpRequestUtil.httpRequest(httpUrl, "GET", null);

    	//System.out.println(result2);
    	System.out.println(re);
    	
		
	}
    
    
    
    
    

}
