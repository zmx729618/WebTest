package zmx.bean.copy.test;

public interface IMethodCallBack {
	
    String getMethodName();

    ToBean callMethod(FromBean frombean)  throws Exception;


}
