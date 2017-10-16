package zmx.test;

import java.util.Scanner;

public class Luoxuandayin {
	
	public static  void fuck(int[][] a, int num, int start_position, int n){  
	    int i,x,y;  
	    if(n==0)return;  
	    if(n==1){  
	        a[start_position][start_position]=num;  
	        return ;  
	    }  
	    x=y=start_position;  
	    a[x][y]=num;  
	    for(i=0;i<n-1;++i){  
	        ++y;  
	        a[x][y]=num+1;  
	        num++;  
	    }  
	    for(i=0;i<n-1;++i){  
	        ++x;  
	        a[x][y]=num+1;  
	        num++;  
	    }  
	    for(i=0;i<n-1;++i){  
	        --y;  
	        a[x][y]=num+1;  
	        num++;  
	    }  
	    for(i=0;i<n-2;++i){  
	        --x;  
	        a[x][y]=num+1;  
	        num++;  
	    }  
	    fuck(a,num+1,start_position+1,n-2);  
	}  
	  

	public static void main(String[] args) {
		
	    int n;  
	    int[][] a = new int[21][21];
	    Scanner scanner = new Scanner(System.in);
	    System.out.print("请输入要打印螺旋层数：");
	    String num = scanner.next();
	   
	    n = Integer.valueOf(num);
	    fuck(a,1,0,n);  
	    for(int i=0;i<n;++i){  
	        for(int j=0;j<n;++j){  
	        	System.out.print(a[i][j]+"\t");
	             
	        }  
	        System.out.println();
	    }  
	  
		
	}
}
