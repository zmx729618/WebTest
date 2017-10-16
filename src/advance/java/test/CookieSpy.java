package advance.java.test;

import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class CookieSpy {
	
	private final static String TIME_FORMAT_NOW = "HH:mm:ss";
	private final static DateFormat DATE_FORMAT = new SimpleDateFormat(TIME_FORMAT_NOW);
	
	public static void main(String[] args) {
		
		String urlString = "http://www.baidu.com";
		CookieManager manager = new CookieManager();
		manager.setCookiePolicy(new CookiePolicy() {
			@Override
			public boolean shouldAccept(URI uri, HttpCookie cookie) {
				//return uri.getHost().equals("www.baidu.com"); //仅接受主机为"www.baidu.com"
				return true;  //接受任何cookie
			}
		});
		CookieHandler.setDefault(manager);
		
		try {
			URL url = new URL(urlString);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
			Object obj = connection.getContent();
			List<HttpCookie> cookies =  manager.getCookieStore().getCookies();
			for(HttpCookie cookie : cookies){
				System.out.println("name: "+ cookie.getName());
				System.out.println("domain: "+ cookie.getDomain());
				long age = cookie.getMaxAge();
				if(age == -1){
					System.out.println("This cookie will expire when browser closes");					
				}else{
					System.out.printf("This cookie will expire in %s seconds%n",DATE_FORMAT.format(age));
				}
				System.out.println("Secured: "+ cookie.getSecure());				
				System.out.println("value: "+ cookie.getValue());
				System.out.println();
				
				
			}
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
