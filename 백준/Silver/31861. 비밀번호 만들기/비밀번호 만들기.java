import java.util.*;
import java.io.*;



public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long MOD = 1_000_000_007;
        long[][]dp = new long[M+1][27];
        Arrays.fill(dp[1],1);

        // 길이
        for(int i = 2; i<=M; i++){
            // 기준 알파벳
            for(int j = 1; j<=26; j++){
                for(int k = 1; k<=26; k++){
                    if(Math.abs(j-k) >= N){
                        dp[i][j] = (dp[i][j] + dp[i-1][k])%MOD;
                    }
                }
            }
        }

        long result = 0;
        for(int i = 1; i<=26; i++){
            result = (result + dp[M][i])%MOD;
        }

        System.out.println(result);

    }

}