
import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[N] = 0;

        for (int i = N - 1; i >= 0; i--) {
            for (int k = 1; k <= cards[i]; k++) {
                if (i + k <= N)
                    dp[i] = Math.min(dp[i], 1 + dp[i + k]);
            }
        }
        System.out.println(dp[0]);

    }

}



