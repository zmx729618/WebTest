package zmx.sort.algorithm.test;

public class SortAlgorithm {
  
	    static int data[] = { 9, 2, 7, 19, 100, 97, 63, 208, 55, 78 };  
	    public static void insertSort() {  
	        int tmp, j = 0;  
	        for (int k = 0; k < data.length; k++) {//-----1-----  
	            tmp = data[k];  
	            j = k - 1;  
	            while (j >= 0 && tmp < data[j]) {//-----2-----  
	                data[j + 1] = data[j];  //后移
	                j--;  
	            }  
	            data[j + 1] = tmp;//------3-------  
	        }  
	    }
	    
	    
	    public static void selectSort() {    
	    	        int i, j, k, tmp = 0;    
	    	        for (i = 0; i < data.length - 1; i++) {    
	    	            k = i;    
	    	            for (j = i + 1; j < data.length; j++)    
	    	                if (data[j] < data[k])    
	    	                    k = j;    
	    	            if (k != i) {    
	    	                tmp = data[i];    
	    	                data[i] = data[k];    
	    	                data[k] = tmp;    
	    	            }    
	    	        }    
	   }

	    public static void main(String[] args) {  
	        /*print();   
	        insertSort();  	       
	        print();*/  
	        
	        
	        print();   
	        selectSort();  	       
	        print();
	    }  
	  
	    static void print() {  
	        for (int i = 0; i < data.length; i++) {  
	            System.out.print(data[i] + " ");  
	        } 
	        System.out.println();
	    }  
	  

}
