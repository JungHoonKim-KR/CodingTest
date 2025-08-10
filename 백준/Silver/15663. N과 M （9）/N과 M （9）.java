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
            dfs(0); 
   
        
        System.out.println(sb);
    }
    
    static void dfs(int curDepth) {
        if(curDepth == k) {
            for(int num : arr) {
                sb.append(num + " ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1; // 이전에 선택한 원소를 저장할 변수
        for(int i = 0; i < n; i++) {
            // 이전에 선택한 원소와 현재 원소가 같으면 건너뜁니다.
            if (prev != input[i] && !visit[i]) {
            	visit[i] = true;
                arr[curDepth] = input[i];
                prev = input[i]; // 현재 원소를 prev에 저장합니다.
                dfs(curDepth + 1);
                visit[i] = false;
            }
        }
    }
   
}