package zmx.test;

import java.util.WeakHashMap;

public class WeakHashMapTest {
	
	public static void main(String[] args) {
		
			WeakHashMap<String, String> map = new WeakHashMap<String, String>();
			map.put(new String("1"), "1");
			map.put("2", "2");
			String s = new String("3");
			map.put(s, "3");
			while (map.size() > 0) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException ignored) {
				}
				System.out.println("Map Size:" + map.size());
				System.out.println(map.get("1"));
				System.out.println(map.get("2"));
				System.out.println(map.get("3"));
				System.gc();
			}

	}

}
