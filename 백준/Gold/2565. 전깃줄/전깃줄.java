import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 자릿수
        int n = Integer.parseInt(br.readLine());
        int line[][] = new int[n][];
        int dp[] = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            line[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            dp[i] = 1;
        }

        Arrays.sort(line, (o1, o2) -> {
            if(o1[0]> o2[0])
                return 1;
            else if(o1[0]< o2[0])
                return -1;
            return 0;
        });
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if(line[i][1] > line[j][1]) {
                    dp[i] = Math.max(dp[j] +1, dp[i]);
                }
            }
        }

        for(int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(n-max);
    }


}
