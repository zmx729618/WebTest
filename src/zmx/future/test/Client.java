package zmx.future.test;
/**
 * 客户端
 * @author zhangwenchao
 *
 */
public class Client {
	
	public Data request(final String queryStr){
		final FutureData future = new FutureData();
		new Thread(){
			@Override
			public void run() {
				RealData realData = new RealData(queryStr);
				future.setRealData(realData);
			}			
		}.start();
		return future;
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		Data data = client.request("name");
		System.out.println("请求完毕");
		try{
			Thread.sleep(2000);	
		}catch (Exception e) {
			
		}
		System.out.println("数据="+data.getResult());
		
	}

}
