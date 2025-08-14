import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	long arr[][] = new long [n+1][n+1];
    	
    	for(int i =1; i<=n; i++) {
    		Arrays.fill(arr[i], Integer.MAX_VALUE);
    		arr[i][i] = 0;
    	}
    	
    	while(m-->0) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		
    		arr[a][b] = 0;
    		arr[b][a] = c==0? 1 : 0;
    	}    	
    	
    	for(int k=1; k<=n; k++) {
    		for(int i = 1; i<=n; i++) {
    			for(int j = 1; j<=n; j++) {
    				if(arr[i][k] + arr[k][j] < arr[i][j]) {
    					 arr[i][j] = arr[i][k] + arr[k][j];
    				}
    			}
    		}
    	}
    	int q = Integer.parseInt(br.readLine());
    	while(q-->0) {
    		st = new StringTokenizer(br.readLine());
    		sb.append(arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]+"\n");
    	}
    	System.out.println(sb);
    	
    	
    	
    
    }
}