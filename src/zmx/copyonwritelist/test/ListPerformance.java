package zmx.copyonwritelist.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 
 * 
 */
public class ListPerformance {
	private final int threadNumber;

	public ListPerformance(int n) {
		threadNumber = n;
	}

	private static class TestThread implements Runnable {
		private static long totolTime;
		private final int No;
		private final int loop = 1000000;
		private final Thread t;
		private final List<Integer> list;

		TestThread(int No, List<Integer> list) {
			this.No = No;
			this.list = list;
			t = new Thread(this);
		}

		public void start() {
			t.start();
		}

		public synchronized void addTime(long time) {
			totolTime += time;
		}

		@Override
		public void run() {
			long time = randomAccess();
			addTime(time);
		}

		@Override
		public String toString() {
			return "Thread " + No + ":";
		}

		public long randomAccess() {
			Date date1 = new Date();
			Random random = new Random();
			for (int i = 0; i < loop; i++) {
				int n = random.nextInt(loop);
				list.get(n);
			}
			Date date2 = new Date();
			long time = date2.getTime() - date1.getTime();
			/*
			 * 主程序System.out.println(TestThread.totolTime);处设置断点，监视该信息输出，所有线程都输出该信息说明，所有子线程运行完毕
			 */
			System.out.println(this + list.getClass().getSimpleName() + " time:" + time);  
			return time;
		}

	}

	public void initList(List<Integer> list, int size) {
		for (int i = 0; i < size; i++) {
			list.add(new Integer(i));
		}
	}

	public void test(List<Integer> list) {
		System.out.println("Test List Performance");
		TestThread[] ts = new TestThread[threadNumber];
		for (int i = 0; i < ts.length; i++) {
			ts[i] = new TestThread(i, list);
		}
		for (int i = 0; i < ts.length; i++) {
			ts[i].start();
		}
	}

	public static void main(String[] args) {
		ListPerformance lp = new ListPerformance(64);
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 1000000; i++) {
			list.add(new Integer(i));
		}
		List<Integer> al = Collections.synchronizedList(list);
		lp.test(al);
		System.out.println(al.size());
		System.out.println(TestThread.totolTime);

		TestThread.totolTime = 0;
		CopyOnWriteArrayList<Integer> cl = new CopyOnWriteArrayList<Integer>(list);
		lp.test(cl);
		System.out.println(cl.size());
		System.out.println(TestThread.totolTime);
	}
}
