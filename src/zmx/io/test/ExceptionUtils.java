package zmx.io.test;


	
//打印全部异常堆栈
public class ExceptionUtils {
	public static void main(String[] args) {
		try {
			int a=1/0;
		} catch (Exception e) {
			
			e.printStackTrace();
			String fullStackTrace = org.apache.commons.lang.exception.ExceptionUtils.getFullStackTrace(e);
			System.out.println(fullStackTrace);

		}
	}
}


