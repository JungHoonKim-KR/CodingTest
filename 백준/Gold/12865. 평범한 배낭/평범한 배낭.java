import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int arr[][] = new int[n+1][2];
        int dp[][] = new int[n+1][w+1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        for(int i =1; i<=n; i++){
            for(int j=1; j<=w; j++){
                int cur[] = arr[i];
                if(j>=cur[0]){
                    dp[i][j] =Math.max(dp[i-1][j-cur[0]] + cur[1],dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }

            }
        }
        System.out.println(dp[n][w]);





    }

}
