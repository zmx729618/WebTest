package zmx.jersey.test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class RestClient {
	
	public static void main(String[] args) {
		
		String restURI = "http://localhost:8080/RestDemo/webapi/myresource";
		
		Client client = ClientBuilder.newClient();  
		
		WebTarget target = client.target(restURI + "/您好"); 
		
		Response response = target.request().get();  
		 
		System.out.println(response);
	}

}
