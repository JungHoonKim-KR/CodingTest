import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int dp[][][] = new int[n][n][3];

        for(int i =0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            dp[i][i][0] = Integer.parseInt(st.nextToken());
            dp[i][i][1] = Integer.parseInt(st.nextToken());
        }

//        dp[start][end][2] = dp[start][mid][2] + dp[mid+1][end][2] + (dp[start][start][0] * dp[mid][mid][0]*dp[end][end][1])
        for(int end=1; end<n; end++){
            for(int start=end-1; start>=0; start--){
                dp[start][end][2] = Integer.MAX_VALUE;
                for(int mid = start; mid<end; mid++){
                    int value = dp[start][mid][2] + dp[mid+1][end][2] + (dp[start][start][0] * dp[mid][mid][1]*dp[end][end][1]);
                    if(dp[start][end][2] > value){
                        dp[start][end][2] = value;
                 
                    }
                }
            }
        }
        System.out.println(dp[0][n-1][2]);
    }
}
