package advance.java.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionAlgorithms {
	
	
	public static <T> T[] list2Array(List<T> list){
		
		Object[] array = new Object[list.size()];
		for(int i=0;i<list.size();i++){
			
			array[i] = list.get(i);
		}
		
		return (T[])array;
		
	}
	
	public static void main(String[] args){
		List<Integer> list = new  ArrayList<Integer>();
		
		for(int i=0; i<100; i++){
			list.add((int)(Math.random()*100));
		}
		System.out.println(list); 
		
		Collections.sort(list); //对list进行自然顺序排序
		
		System.out.println(list);
		
		int testNumber = 10;
		int index = Collections.binarySearch(list, testNumber);
		
		if(index >=0){
			System.out.println(index);
		}
		
		System.out.println(Collections.max(list));				
		System.out.println(Collections.min(list));
		System.out.println(Collections.frequency(list, testNumber));
		
		Set<Integer> sortedSet = new HashSet<>();
		sortedSet.addAll(list);
		System.out.println(sortedSet);
		list.clear();
		list.addAll(sortedSet);
		
		
		Collections.shuffle(list);
		System.out.println(list);
		
		List<Integer> subList = list.subList(0, 10);
		
		System.out.println(subList);
		
	}

}
