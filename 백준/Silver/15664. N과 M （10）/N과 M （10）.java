import java.io.*;
import java.util.*;
import java.util.concurrent.BrokenBarrierException;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int[] arr;
    static int[] input; 
    static int n,k;
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
             n = Integer.parseInt(st.nextToken());
             k = Integer.parseInt(st.nextToken());
            
         
            input = new int[n]; 
            arr = new int[k];
        	visit = new boolean[n];
             st = new StringTokenizer(br.readLine());
            for(int i = 0; i<n; i++) {
            	input[i]= Integer.parseInt(st.nextToken());
            }
            Arrays.sort(input);
            dfs(0,0); 
   
        
        System.out.println(sb);
    }
    
    static void dfs(int curDepth, int start) {
        if(curDepth == k) {
            for(int num : arr) {
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1; 
        for(int i = start; i < n; i++) {
           
            if (prev != input[i] && !visit[i]) {
            	visit[i] = true;
                arr[curDepth] = input[i];
                prev = input[i]; 
                dfs(curDepth + 1, i);
                visit[i] = false;
            }
        }
    }
   
}