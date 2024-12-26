import java.io.*;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int []dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for(int i =3; i<=n; i++){
            if(i>=3 && dp[i-3] != Integer.MAX_VALUE){
                dp[i] = Math.min(dp[i-3] +1, dp[i]);
            }
            if(i>=5 && dp[i-5] != Integer.MAX_VALUE){
                dp[i] = Math.min(dp[i-5] +1, dp[i]);
            }
        }
        if(dp[n] == Integer.MAX_VALUE){
            bw.write("-1\n");
        }
        else
            bw.write(dp[n]+"");
        bw.flush();
    }
}


