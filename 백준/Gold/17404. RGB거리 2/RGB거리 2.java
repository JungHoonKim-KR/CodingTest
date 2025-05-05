import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][3];
        long dp[][] = new long[n][3];
        for(int i =0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long result = Integer.MAX_VALUE;
        for(int firstColor = 0; firstColor<3; firstColor++){
            for(int i = 0; i<3; i++){
                if(i == firstColor) dp[0][firstColor] = arr[0][firstColor];
                else dp[0][i] = Integer.MAX_VALUE;
            }

            for(int i = 1; i<n; i++){
                dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
            }


            for(int lastColor = 0; lastColor<3; lastColor++){
                if(firstColor == lastColor)continue;
                result = Math.min(result, dp[n-1][lastColor]);
            }

        }
        System.out.println(result);





    }
}