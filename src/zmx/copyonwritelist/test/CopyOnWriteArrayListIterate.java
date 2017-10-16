package zmx.copyonwritelist.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListIterate {

	public static void main(String[] args) throws InterruptedException {
		List<String> a = new ArrayList<String>();
		a.add("a");
		a.add("b");
		a.add("c");
		final CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>(a);
		Thread t = new Thread(new Runnable() {
			int count = -1;

			@Override
			public void run() {
				while (true) {
					list.add(++count + "");
				}
			}
		});
		t.setDaemon(true); 
		t.start();
		Thread.currentThread().sleep(1);
		for (String s : list) {
			//System.out.println(list.hashCode());
			System.out.println(s);
		}
	}
}
