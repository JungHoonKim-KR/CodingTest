import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int dp[] = new int[1001];

        dp[1] =1;
        dp[2] =3;
        for(int i=3; i<=n; i++){
            dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
        }
        System.out.println(dp[n]);
    }

}