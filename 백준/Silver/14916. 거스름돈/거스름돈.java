import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        if (n == 1) {
            System.out.println(-1);
            return;
        }
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = -1;
        for (int i = 2; i <= n; i++) {
            if (i >= 2) {
                if (dp[i - 2] != -1 && dp[i-2] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - 2]) + 1;
            }
            if (i >= 5){
                if (dp[i - 5] != -1 && dp[i-5] != Integer.MAX_VALUE)
                    dp[i] = Math.min(dp[i], dp[i - 5]) + 1;
            }
        }
        System.out.println((dp[n] == Integer.MAX_VALUE) ? -1 : dp[n]);
    }

}