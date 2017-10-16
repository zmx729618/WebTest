package array.collection.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayListUtil {
	
	
	/**
	 * 比较两个数组中的元素是否相同
	 * @param array1
	 * @param array2
	 * @return
	 */
	public static boolean isEquals(Object[] array1,Object[] array2){
		
        Arrays.sort(array1);
        Arrays.sort(array2);
        if (Arrays.equals(array1, array2)) {
                System.out.println("两个数组中的元素值相同");
                return true;
        } else {
                System.out.println("两个数组中的元素值不相同");
                return  false;
        }
		
	}
	
	
	 /**
     * 将Set集合转换为数组
     * 
     * @author zhangwenchao
     */
    public static <T> Object[] setToArray(Set<T> set ){

           return set.toArray();
          
    }
	
	public static void main(String[] args) {
        String [] array1 = {"1","2","3"};
        String [] array2 = {"3","2","1"};
        
        ArrayListUtil.isEquals(array1, array2);
        
        
        
        Set<String> setNames = new HashSet<String>();
        setNames.add("欧阳一博");
        setNames.add("东方弘一");
        setNames.add("田中义一");
        
        Object[] arryNames= ArrayListUtil.setToArray(setNames);
        for (Object name:arryNames) {
            System.out.println((String)name);
        }


	}

}
