package rmi.http.test;

public class HttpInvokerTestImpl implements HttpInvokerTest{

	@Override
	public int getTestPo(int a) {
		
		return 1+a;
	}

}
