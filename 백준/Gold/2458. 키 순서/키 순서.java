import java.io.*;
import java.util.*;


public class Main {
	static long INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        boolean arr[][] = new boolean[n][n];
        
        for(int i =0; i<m; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	arr[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = true;
        }
        for(int k = 0; k<n; k++) {
        	for(int i=0; i<n; i++) {
        		for(int j=0;j<n; j++) {
        			if(arr[i][k] && arr[k][j])
        				arr[i][j] = true;
        		}
        	}
        }
        int result=0;
        for(int i = 0; i<n; i++) {
        	int count=0;
        	for(int j = 0; j<n; j++) {
        		if(arr[i][j] || arr[j][i])
        			count++;
        	}
        	if(count == n-1) {
        		result++;
        	}
        }
        System.out.println(result);
        
       
    }


   
 
}