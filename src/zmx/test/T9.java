package zmx.test;

import java.util.HashMap;
import java.util.Map;

public class T9 {
	public static void main(String[] args) {
		
/*		int i = Float.floatToIntBits(200.223f);
		System.out.println(i);
		
		long d = Double.doubleToLongBits(200.223d);
		System.out.println(d);
		
		
		System.out.println("99".matches("^[0-9]+((\\.[0-9]{2})|(\\.[0-9]{1}))?$"));
		System.out.println("99.0".matches("^[0-9]+((\\.[0-9]{2})|(\\.[0-9]{1}))?$"));
		System.out.println("99.00".matches("^[0-9]+((\\.[0-9]{2})|(\\.[0-9]{1}))?$"));
		System.out.println("99.1".matches("^[0-9]+((\\.[0-9]{2})|(\\.[0-9]{1}))?$"));
		System.out.println("99.01".matches("^[0-9]+((\\.[0-9]{2})|(\\.[0-9]{1}))?$"));
		System.out.println("00".matches("^[0-9]+((\\.[0-9]{2})|(\\.[0-9]{1}))?$"));*/
		
		
        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put( "key1", 1);
        Map<String,Integer> mapFirst = map;
        System.out.println( map);
        System.out.println( mapFirst);
        map.put( "key2", 2);
        System.out.println( map);
        System.out.println( mapFirst);
		
		
		
	}

}
