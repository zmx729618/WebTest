package zmx.sort.test;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionSort {
	
	public static void main(String[] args) {
		
		//集合排序
		List<String> list = new ArrayList<>();
		list.add("刘媛媛");
		list.add("王硕");
		list.add("李明");
		list.add("张迪");
		list.add("刘布");	
		//升序
		Collections.sort(list,Collator.getInstance(java.util.Locale.CHINA));//注意：是根据的汉字的拼音的字母排序的，而不是根据汉字一般的排序方法
		for(int i=0;i<list.size();i++)
		{
		    System.out.print(list.get(i));
		}

		System.out.println("");

		//降序
		Collections.reverse(list);//不指定排序规则时，也是按照字母的来排序的
		for(int i=0;i<list.size();i++)
		{
		     System.out.print(list.get(i));
		}
		
		
		
		//数组排序
		System.out.println();
		String[] names = {"王林",  "杨宝", "李镇", "刘迪", "刘波"}; 
		Arrays.sort(names, Collator.getInstance(java.util.Locale.CHINA));
		System.out.println(Arrays.toString(names));      
		
		
	}

}
