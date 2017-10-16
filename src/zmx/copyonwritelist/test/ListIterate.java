package zmx.copyonwritelist.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIterate {

	public static void main(String[] args) throws InterruptedException {
		List<String> a = new ArrayList<String>();
		a.add("a");
		a.add("b");
		a.add("c");
		final ArrayList<String> list = new ArrayList<String>(a);
		Thread t = new Thread(new Runnable() {
			int count = -1;
			@Override
			public void run() {
				while (true) {
					list.add(count++ + "");
				}
			}
		});
		t.setDaemon(true);
		t.start();
		Thread.currentThread().sleep(4);
		Iterator iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
