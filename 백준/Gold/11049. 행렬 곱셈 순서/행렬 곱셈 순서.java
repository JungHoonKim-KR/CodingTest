import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int dp[][][]= new int[n+1][n+1][3];
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            dp[i][i][0] = Integer.parseInt(st.nextToken());
            dp[i][i][1] = Integer.parseInt(st.nextToken());

        }
        for(int gap=1; gap<=n-1; gap++){
            for(int start=1; start <=n-gap; start++){
                int end = start + gap;
                dp[start][end][2] = Integer.MAX_VALUE;
                for(int mid = start; mid<end; mid++){
                    dp[start][end][2] = Math.min(dp[start][end][2],
                            dp[start][mid][0] * dp[start][mid][1] * dp[mid+1][end][1]
                            + dp[start][mid][2] + dp[mid+1][end][2]);
                }
                dp[start][end][0] = dp[start][start][0];
                dp[start][end][1] = dp[end][end][1];
            }
        }

        System.out.println(dp[1][n][2]);
    }


}
