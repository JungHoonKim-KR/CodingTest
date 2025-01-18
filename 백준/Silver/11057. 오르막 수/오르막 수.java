import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int dp[][] = new int[1001][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        if (n >= 2) {
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j <= 9; j++) {
                        for(int k=j; k<10; k++){
                            dp[i][j] += dp[i-1][k];
                            dp[i][j] %= 10007;
                        }
                }
            }
        }
        int result=0;

        for(int i =0; i<10; i++){
            result += dp[n][i];
        }
        System.out.println(result % 10007);

    }

}