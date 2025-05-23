import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringBuilder result = new StringBuilder();
  
        for (int tc = 1; tc <= 10; tc++) {
        
        	result.append("#"+tc+" ");
        	int n =Integer.parseInt(br.readLine());
        	int max=100;
         	int arr[][] =new int[max][max];
         	int count=0;
         	for(int i=0;i<max;i++) {
         		arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
         		
         	}
         	
         	for(int col=0; col<max;col++) {
         		int oneLine=0;
         		int twoLine=max-1;
         		for(int row=0;row<max;row++) {
         			if(arr[row][col]==1)
         				break;
         			oneLine++;
         		}
         		
         		for(int row=max-1;row>=0;row--) {
         			if(arr[row][col]==2)
         				break;
         			twoLine--;
         		}
         		
         		if(oneLine<twoLine) {
         			boolean section=true;
         			for(int i=oneLine;i<=twoLine;i++) {
         				
         				if(arr[i][col]==2 && section) {
         					count++;
         					section=false;
         				}
         				else if(arr[i][col]==1)
         					section=true;
         			}
         		}
         	}
         	result.append(count+"\n");
         	
        }
        System.out.println(result);
   
    }
    

    
    
 

}