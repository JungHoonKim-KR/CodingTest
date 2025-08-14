import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int n = Integer.parseInt(st.nextToken());
    	int m = Integer.parseInt(st.nextToken());
    	
    	long arr[][] = new long[n][n];
    	
    	for(int i =0; i<n; i++) {
    		arr[i] = Arrays.stream(br.readLine().split(" ")).mapToLong(Long :: parseLong).toArray();
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
    	for(int i =0; i<m; i++) {
    		st = new StringTokenizer(br.readLine());
    		if(arr[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] <= Integer.parseInt(st.nextToken()))
    			sb.append("Enjoy other party\n");
    		else sb.append("Stay here\n");
    	}
    	System.out.println(sb);
    }
}