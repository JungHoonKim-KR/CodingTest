import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int dp[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if(sum + dp[i]>0){
                sum += dp[i];
                max = Math.max(max, sum);
            }
            else{
                max = Math.max(max, dp[i]);
                sum=0;
            }
        }
        bw.write(max+"");

        bw.flush();
        br.close();
        bw.close();

    }


}
