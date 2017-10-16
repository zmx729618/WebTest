package sort.test;
/**
 * 相邻元素比较
 * @author zhangwenchao
 *
 */
public class BubbleSort {
	
	public static void main(String[] args) {
		boolean isChange = true;//记录每次有没有交换值的状态
		int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};      
        for(int i=0;i<a.length-1;i++){
        	isChange = false; //每次循环之前先修改为：不需要在交换的状态。
            for(int j=0;j<a.length-1-i;j++){    
                if(a[j]>a[j+1]){    
                	int temp=a[j];    
                    a[j]=a[j+1];    
                    a[j+1]=temp; 
                    isChange = true;  //如果有交换发生，需要为true
                }    
            }
            
            if(!isChange){
            	break; //如果一趟下来之后没有发生一次交换操作，说明数组已经有序了，直接跳出循环 
            }
            
        }    
        for(int i=0;i<a.length;i++)    
            System.out.println(a[i]);       
	}

}
