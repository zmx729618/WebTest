package sort.test;
/**
 * 从1开始把一个无需数组的依次插入到有序数组中。
 * @author zhangwenchao
 *
 */
public class InsertSort{
	public static void main(String[] agrs) {
		int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};    
        int temp=0;    
        for(int i=1;i<a.length;i++){    
            temp=a[i];
            int j=i-1;
            for(;j>=0 && temp<a[j];j--){ //J停留在需要插入位置  ，跳出循环。 
                a[j+1]=a[j];//将已经排好顺序的序列中，大于temp的值整体后移一个单位 ，将temp插入到自己应该的位置   
            }    
            a[j+1]=temp;    
        }    
  
        for(int i=0;i<a.length;i++)    
            System.out.println(a[i]);    

	}
	


}
