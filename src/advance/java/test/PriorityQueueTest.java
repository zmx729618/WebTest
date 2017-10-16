package advance.java.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=0; i<100; i++){
			list.add((int)(Math.random()*10));
		}
		
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		queue.addAll(list);
		
		for(Iterator<Integer> iter = queue.iterator(); iter.hasNext();){
			System.out.print(iter.next());
		}
		
		System.out.println();
		
		while(!queue.isEmpty()){
			System.out.print(queue.poll());
		}
		
		
		
		
	}
	


}
