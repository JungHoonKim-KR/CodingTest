import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[300];
        int arr[] = new int[300];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        dp[1] = arr[0] + arr[1];
        dp[2] = Math.max(arr[0], arr[1]) + arr[2];
        for (int i = 3; i < n; i++) {
            dp[i] = Math.max(arr[i - 1] + dp[i - 3], dp[i - 2]) + arr[i];
        }

        System.out.print(dp[n - 1]);


    }


}
