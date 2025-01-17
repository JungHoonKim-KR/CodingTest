import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int date[] = new int [n];
        int pay[] = new int [n];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            date[i] = Integer.parseInt(st.nextToken());
            pay[i] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int [n+1];
        for(int i =0; i<n; i++){
            if(i + date[i] <= n){
                // 오늘 일을 하는게 이득일까?
                dp[i + date[i]] = Math.max(dp[i+date[i]], dp[i] + pay[i]);
            }

            dp[i+1] = Math.max(dp[i], dp[i+1]);
        }

        System.out.println(dp[n]);
    }

}
