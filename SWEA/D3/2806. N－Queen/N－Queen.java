import java.util.*;
import java.awt.Checkbox;
import java.io.*;

public class Solution {
	static int arr[][];
	static int count=0;
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder result = new StringBuilder();
    	int n =Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= n; tc++) {
        
        	result.append("#"+tc+" ");
        	
        	int num =Integer.parseInt(br.readLine());
        	arr =new int[num][num];
        	
        
        	queen(0,num);
        	result.append(count+"\n");
        	count=0;

        }
        System.out.println(result);
   
    }
    
    static void queen(int x, int n) {
    		if(x==n ){
    			count++;
    			return;
    		}
    		
    		for(int i =0;i<n;i++) {
    			if(check(x, i ,n)) {
    				arr[x][i] =1;
    				queen(x+1, n);
        			arr[x][i]=0;
    			}
    			
    		}
    	
    }
    static boolean check(int x, int y, int n) {
    	for(int i =0;i<x;i++) {
    		if(arr[i][y] ==1)
    			return false;
    		
    	}
    	
    	for(int i=0;i<y;i++) {
    		if(arr[x][i] ==1)
    			return false;
    	}
    	
    	for(int i=x-1, j=y-1; i>=0 &&j>=0; i--,j--) {
    		if(arr[i][j]==1)
    			return false;
    	}
    	
    	for(int i=x-1, j=y+1; i>=0 && j<n;i--,j++) {
    		if(arr[i][j]==1)
    			return false;
    	}
		return true;
    	
    	
    }
    
    
 

}