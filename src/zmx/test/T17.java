package zmx.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T17 {
	
	public static void main(String[] args){
        String string = "213213/13123/14432432";
        //这里是获取"/"符号的位置
        Matcher slashMatcher = Pattern.compile("/1").matcher(string);
        int mIdx = 0;

        while(slashMatcher.find()) {
            System.out.println(slashMatcher.group());
            System.out.println(slashMatcher.start());
            mIdx++;
            //当"/"符号第2次出现的位置
            if(mIdx == 2){
                break;
            }
        }
        
        System.out.println(slashMatcher.start());
    }

}
