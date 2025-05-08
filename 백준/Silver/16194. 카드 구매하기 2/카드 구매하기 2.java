import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n+1];
        int dp[][] = new int[n+1][n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= n; i++){
            int cur = arr[i];
            for(int price = 1; price <= n; price++){
                if(i == 1){
                    dp[i][price] = cur * price;
                }
                else{
                    if(i <= price){
                        dp[i][price] = Math.min(dp[i][price - i] + cur, dp[i-1][price]);
                    }
                    else dp[i][price] = dp[i-1][price];
                }
            }
        }

        System.out.println(dp[n][n]);





    }
}