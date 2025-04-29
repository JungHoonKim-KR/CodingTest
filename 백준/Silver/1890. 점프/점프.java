import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static long dp[][];
    static int arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        dp = new long[n][n];
        dp[0][0] = 1;

        for(int i =0; i<n; i++){
            for(int j =0; j<n; j++){
                int distance = arr[i][j];
                if(distance == 0) continue;
                if(i + distance < n) dp[i+distance][j] += dp[i][j];
                if(j+distance <n) dp[i][j+distance] += dp[i][j];
            }
        }
        System.out.println(dp[n - 1][n - 1]);
    }


}