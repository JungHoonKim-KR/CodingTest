import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[1000001];
        int list[] = new int[1000001];

        dp[2]=1;
        dp[3]=1;
        list[2]=1;
        list[3]=1;
        for(int i =4 ;i<=n; i++){
            //기본
            dp[i] = dp[i-1] +1;
            list[i] = i-1;
            if(i%2==0){
                if(dp[i]>dp[i/2]+1){
                    dp[i] = dp[i/2]+1;
                    list[i] = i/2;
                }
            }

            if(i%3==0){
                if(dp[i]> dp[i/3]+1){
                    dp[i] = dp[i/3]+1;
                    list[i] = i/3;
                }
            }

        }

        bw.write(dp[n]+"\n");
        while(n>0){
            bw.write(n+" ");
            n = list[n];
        }
        bw.flush();

    }
}
