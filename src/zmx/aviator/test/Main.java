package zmx.aviator.test;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import com.googlecode.aviator.AviatorEvaluator;

public class Main {
	
	public static void main(String[] args) throws Exception {
		double result = (double) AviatorEvaluator.execute("1.00+2+3");  
		System.out.println(result);
		
		System.out.println(AviatorEvaluator.execute("3>1 && 2!=4 || true"));  
		String yourname = "aviator";
		Map<String, Object> env = new HashMap<String, Object>();  
		env.put("yourname", yourname);

		System.out.println(AviatorEvaluator.execute(" 'hello ' + yourname ",env));  
		System.out.println(new DecimalFormat("#.00").format(AviatorEvaluator.execute("1000+100.0*99-(600-3*15)/(((68-9)-3)*2-100)+10000%7*71")));
		
		ScriptEngineManager manager = new ScriptEngineManager();

        ScriptEngine se = manager.getEngineByName("js");

        System.out.println(new DecimalFormat("#.00").format(se.eval("1000+100.0*99-(600-3*15)/(((68-9)-3)*2-100)+10000%7*71")));
		
		System.out.println(new DecimalFormat("#.00").format(1000+100.0*99-(600-3*15)/(((68-9)-3)*2-100)+10000%7*71));
	}

}
