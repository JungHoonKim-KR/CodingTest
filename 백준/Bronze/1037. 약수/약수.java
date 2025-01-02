import java.io.*;
import java.util.*;


public class Main {
    static int [][]dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st  = new StringTokenizer(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        if(st.countTokens()>1){
            for(int i =0; i<num;i++){
                int n = Integer.parseInt(st.nextToken());
                max = Math.max(max,n);
                min = Math.min(min,n);
            }
            bw.write(max*min+"");
        }
        else bw.write((int)Math.pow(Integer.parseInt(st.nextToken()),2)+"");

        bw.flush();
    }

    static int binomial(int n, int k) {
        if(k==0 || n==k)return 1;
        if(dp[n][k]==0)
            dp[n][k] = binomial(n-1,k-1) + binomial(n-1,k);
        return dp[n][k];
    }

}


