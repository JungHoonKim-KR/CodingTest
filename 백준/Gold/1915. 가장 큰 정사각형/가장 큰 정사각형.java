import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if(n == 1 || m == 1){
            System.out.println(1);
            return;
        }
        int arr[][] = new int[n][m];
        int dp[][] = new int[n][m];

        for (int i = 0; i<n; i++){
            String s = br.readLine();
            for(int j=0;j<m;j++){
                int input = s.charAt(j) - '0';
                arr[i][j] = input;
                if(input == 1) dp[i][j] = input;
            }
        }

        int result=0;
        for(int i =0; i<n; i++){
            for(int j =0; j<m; j++){
                if(arr[i][j] == 1 && i>0 && j>0){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]) +1;
                }
                result = Math.max(result, dp[i][j]);
                
            }
        }
        System.out.println(result * result);






    }


}