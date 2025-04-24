import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int coin[] = new int[n];
        int dp[] = new int[k + 1];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(dp,Integer.MAX_VALUE);
        // 초기 동전

        dp[0] = 0;
        for (int i = 0; i<n; i++) {
            for(int j = coin[i]; j<=k; j++){
                if(dp[j-coin[i]]!=Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j-coin[i]]+1);
            }
        }
        System.out.println(dp[k] == Integer.MAX_VALUE ? -1 : dp[k]);

    }
}
