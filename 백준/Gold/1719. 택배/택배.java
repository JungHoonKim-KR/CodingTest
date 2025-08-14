import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
		
    	long arr[][] = new long[n+1][n+1];
    	int result[][] = new int[n+1][n+1];
    	for(int i =1; i<=n; i++) {
    		Arrays.fill(arr[i], Integer.MAX_VALUE);
    		arr[i][i] = 0;
    	}
    	
    	for(int i =0; i<m; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int l = Integer.parseInt(st.nextToken());
    		arr[a][b] = l;
    		arr[b][a] = l;
    		result[a][b] = b;
    		result[b][a] = a;
    	}
    	
    	for(int k=1; k<=n; k++) {
    		for(int i=1; i<=n; i++) {
    			for(int j=1; j<=n; j++) {
    				if(arr[i][k] + arr[k][j] < arr[i][j]) {
    					result[i][j] = result[i][k];
    					arr[i][j]=arr[i][k] + arr[k][j];
    				}
    			}
    		}
    	}
    	
    	for(int i=1; i<=n; i++) {
    		for(int j =1; j<=n; j++) {
    			if(i==j) {
    				sb.append("- ");
    			}
    			else sb.append(result[i][j]+" ");
    		}
    		sb.append("\n");
    	}
    	
    	System.out.println(sb);
    	
    	
    	
    
    }
}