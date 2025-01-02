import java.io.*;
import java.util.*;


public class Main {
    static int [][]dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        dp = new int[30][30];
        for(int i =0; i<num;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            bw.write(binomial(m,n)+"\n");

        }
        bw.flush();
    }

    static int binomial(int n, int k) {
        if(k==0 || n==k)return 1;
        if(dp[n][k]==0)
            dp[n][k] = binomial(n-1,k-1) + binomial(n-1,k);
        return dp[n][k];
    }

}


