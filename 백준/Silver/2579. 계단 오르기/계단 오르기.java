import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static int arr[];
    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        bw.write(fun(n)+"");

        bw.flush();
    }


    static int fun(int n) {
        
          dp[1] = arr[1];
          if(n==1)
              return dp[1];
          
          dp[2] = arr[1] + arr[2];

        if (n >= 3) {
            for (int i = 3; i <= n; i++) {
                dp[i] = arr[i] + Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]);
            }
        }
        return dp[n];
    }
}
