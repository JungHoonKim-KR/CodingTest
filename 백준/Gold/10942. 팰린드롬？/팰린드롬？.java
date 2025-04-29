import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[n+1];

        for(int i =1; i<=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int dp[][] = new int[n+1][n+1];
        // 질문의 수가 많은 것이 문제이므로 처음부터 dp를 다 채운 후 질문을 o(1)로 처리하면 깔끔
        // 구간1
        for(int i =1; i<=n; i++){
            dp[i][i] = 1;
        }

        // 구간2
        for(int i =1; i<=n-1; i++){
            if(arr[i] == arr[i+1]){
                dp[i][i+1] = 1;
            }
        }

        //나머지
        for(int gap = 2; gap<=n-1; gap++){
            for(int start = 1; start <= n-gap; start++){
               if(arr[start] == arr[start+gap] && dp[start+1][start+gap-1] == 1){
                   dp[start][start+gap] = 1;
               }
            }
        }


        int m = Integer.parseInt(br.readLine());
        while(m-->0){
            st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(dp[start][end] == 1)sb.append(1+"\n");
            else sb.append(0+"\n");

        }
        System.out.println(sb);
    }

}