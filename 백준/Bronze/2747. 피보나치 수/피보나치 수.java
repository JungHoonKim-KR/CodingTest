import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
       int n = Integer.parseInt(br.readLine());

       int dp[] = new int[n+1];
       dp[1]=1;
       if(n>=2){
           for(int i =2; i<=n; i++){
                dp[i] = dp[i-2] + dp[i-1];
           }
       }
        System.out.println(dp[n]);

    }

}
