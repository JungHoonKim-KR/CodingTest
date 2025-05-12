import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long dp[][] = new long[n][21];

        dp[0][arr[0]] = 1;
        for(int i = 1; i<n-1; i++){
            int cur = arr[i];
            for(int j = 0; j<=20; j++){
                if(dp[i-1][j] !=0){
                    if(j - cur >=0){
                        dp[i][j-cur] += dp[i-1][j];
                    }
                    if(j+cur <=20){
                        dp[i][j+cur] += dp[i-1][j];
                    }
                }
            }
        }

        System.out.println(dp[n-2][arr[n-1]]);

    }
}