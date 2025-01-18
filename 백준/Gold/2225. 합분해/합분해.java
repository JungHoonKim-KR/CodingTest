import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N =  Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        long dp[][] = new long [201][201];
        dp[1][0] =1;
        for(int i =0; i<=N; i++){
            dp[1][i] = 1;
        }

        for(int i =2; i<=c; i++){
            for(int j=0; j<=N; j++){
                for(int k=j; k<=N; k++){
                    dp[i][j] +=dp[i-1][k];
                    dp[i][j] %=1000000000;
                }
            }
        }

        System.out.println(dp[c][0]%1000000000);
    }




}
