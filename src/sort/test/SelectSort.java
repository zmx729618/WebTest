package sort.test;
/**
 * 选择一个最小值放到其位置
 * @author zhangwenchao
 *
 */
public class SelectSort {
	
	public static void main(String[] args) {
		
		int a[]={1,54,6,3,78,34,12,45};       
        for(int i=0;i<a.length;i++){            
            for(int j=i+1;j<a.length;j++){    
                if(a[j]<a[i]){    
                    int temp=a[j];
                    a[j]=a[i];
                    a[i]=temp; 
                }    
            }    
   
        } 
        
        for(int i=0;i<a.length;i++)    
            System.out.println(a[i]); 
		
	}

}
