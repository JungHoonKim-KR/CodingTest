import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	int r = Integer.parseInt(st.nextToken());
    	int item[] = new int[n];
    	long arr[][] = new long[n][n];
    	for(int i = 0; i<n; i++) {
    		Arrays.fill(arr[i], Integer.MAX_VALUE);
    		arr[i][i]=0;
    	}
    	
    	item = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    	
    	 for(int i = 0; i<r; i++) {
    		  st = new StringTokenizer(br.readLine());
    		    int a = Integer.parseInt(st.nextToken()) - 1;
    		    int b = Integer.parseInt(st.nextToken()) - 1;
    		    int l = Integer.parseInt(st.nextToken());
    		    
    		    arr[a][b] = l;
    		    arr[b][a] = l;
    	 }
    	for(int k=0; k<n; k++) {
    		for(int i = 0; i<n; i++) {
    			for(int j =0; j<n; j++) {
    				if(arr[i][k] + arr[k][j] < arr[i][j]) {
    					 arr[i][j]=arr[i][k] + arr[k][j];
    				}
    			}
    		}
    	}
    	int result = 0;
    	for(int i= 0; i<n; i++) {
    		int count = 0;
    		for(int j = 0; j<n; j++) {
    			if(arr[i][j] <=m)
    				count += item[j];
    		}
    		result = Math.max(result,  count);
    	}
    	System.out.println(result);
    }
}