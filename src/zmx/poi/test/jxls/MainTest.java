package zmx.poi.test.jxls;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jxls.transformer.XLSTransformer;

public class MainTest {
	
	public static void main(String[] args) throws Exception {
		
		String srcFilePath = "D:\\projects\\testWeb\\WebRoot\\WEB-INF\\classes\\zmx\\poi\\test\\template-simple.xlsx";  
		Map<String, Object> beanParams = new HashMap<String, Object>();  
		List<BeanEntity> beans = new ArrayList<BeanEntity>();  
		BeanEntity bean1 = new BeanEntity(); 
		bean1.setId("1001");
		bean1.setName("我的CENTOS");  
		bean1.setPrice(103.0);  
		bean1.setScale("2CPU, 2G MEM, 2T DISK");  
		bean1.setCreatedTime(new Date());  
		beans.add(bean1);  
		
		BeanEntity bean2 = new BeanEntity(); 
		bean2.setId("1002");
		bean2.setName("my-ubuntu");  
		bean2.setPrice(200.00);  
		bean2.setScale("1CPU, 3G MEM, 1T DISK");  
		bean2.setCreatedTime(new Date());  
		beans.add(bean2);  
		
		beanParams.put("beans", beans);  
		String destFilePath = "D:\\projects\\testWeb\\WebRoot\\WEB-INF\\classes\\zmx\\poi\\test\\simple.xlsx";  
		XLSTransformer transformer = new XLSTransformer();     
		transformer.transformXLS(srcFilePath, beanParams, destFilePath);  
        System.out.println("生成excel文件成功！");
		
	}

}
