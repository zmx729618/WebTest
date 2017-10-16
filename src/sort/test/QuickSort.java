package sort.test;

import java.util.Random;

public class QuickSort {
	
    public void quickSort(int[] list, int low, int high) {       
        if (low < high) {       
            int middle = getMiddle(list, low, high);  //将list数组进行一分为二       
            quickSort(list, low, middle - 1);         //对低字表进行递归排序       
            quickSort(list, middle + 1, high);        //对高字表进行递归排序       
        }       
    }
    
    public int getMiddle(int[] list, int low, int high) {       
        int tmp = list[low];    //数组的第一个作为中轴       
        while (low < high){       
            if(low < high && list[high] >= tmp) {       
                high--;       
            }       
            list[low] = list[high];   //比中轴小的记录移到低端
            if(low < high && list[low] <= tmp) {       
                low++;       
            }       
            list[high] = list[low];   //比中轴大的记录移到高端       
        }       
        list[low] = tmp;              //中轴记录到尾     
        System.out.println( high+"?="+low);
        return low;                   //返回中轴的位置       
  
    }
    
    /**
     * 选取数组第一个元算作为 中轴数据，对组数进行一份为二，
     * 返回分解之后的中轴数据对应的下标
     * @param args
     */
    public int getMiddleIndex(int[] list, int low, int high) {  
    	int middleDate = list[low];
        while(low <high){
        	
        	while(low <high && list[high]>=middleDate){
        		high--;
        	}
        	list[low] = list[high];
        	
        	while(low <high && list[low] <= middleDate){
        		low++;
        	}
        	list[high] = list[low];
        	
        	
        }
        list[low] = middleDate;
        System.out.println( high+"?="+low);
        return low;
    }
    
    public void quickSort2(int[] list, int low, int high) {   
    	if(low < high){
	    	int middleIndex = getMiddleIndex(list, low, high);
	    	quickSort2(list, low, middleIndex-1);
	    	quickSort2(list, middleIndex+1, high);
    	}  
    }
    
    
	
	
	public static void main(String[] args) {
		
		Random r  = new Random(10);
		int[] list = new int[20];
		for(int i=0;i<20;i++){
			list[i]=Math.abs(r.nextInt(100)) ;
			System.out.print(list[i]+" ");
	
		}
		System.out.println();
		
		
		QuickSort qs = new QuickSort();
		
		
		
       /*if (list.length > 0) {    //查看数组是否为空       
        	qs.quickSort(list, 0, list.length - 1);       
        }*/
        
        
        qs.quickSort2(list, 0, list.length - 1);
		
        for(int i=0;i<list.length;i++){    
			 System.out.print(list[i]+" ");
        }
	}

}
