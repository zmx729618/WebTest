package zmx.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegularExpression {
	
	public static void regularExpressionMatcher(String str, String... regularExpression){
		
		for(int i = 0; i < regularExpression.length; i++) {
		      System.out.println("Regular expression: \"" + regularExpression[i] + "\"");
		      Pattern p = Pattern.compile(regularExpression[i]);
		      Matcher m = p.matcher(str);
		      while(m.find()) {
		        System.out.println("Match \"" + m.group() + "\"at positions " +m.start() + "-"+ (m.end() - 1));
		      }
		}
	}
	
	public static void main(String[] args) {
		
		TestRegularExpression.regularExpressionMatcher("abcabcabcdefabc ", new String[]{"abc+","(abc)+","(abc){2,}"});
	    
	}

}
