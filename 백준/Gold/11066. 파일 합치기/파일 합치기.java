import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < tc; t++) {
            int n = Integer.parseInt(br.readLine());
            int sum[] = new int[n + 1];
            int dp[][] = new int[n+1][n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 입력
            for (int i = 1; i < n+1; i++) {
                sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());
            }

            for(int gap =1; gap<=n-1; gap++){
                for(int start = 1; start <= n-gap; start++){
                    int end = start + gap;
                    dp[start][end] = Integer.MAX_VALUE;
                    for(int mid = start ; mid< end ; mid++){
                        dp[start][end] = Math.min(dp[start][end], dp[start][mid] + dp[mid+1][end] + sum[end] - sum[start-1]);
                    }
                }
            }
            sb.append(dp[1][n]+"\n");
        }
        System.out.println(sb);
    }


}
