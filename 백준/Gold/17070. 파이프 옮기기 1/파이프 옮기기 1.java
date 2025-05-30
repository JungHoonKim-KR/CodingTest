import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int map [][] = new int[n+1][n+1];

        for(int i =1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
           for(int j=1; j<=n; j++){
               map[i][j] = Integer.parseInt(st.nextToken());
           }
        }
        // 가로, 세로, 대각
        int dp[][][] = new int[n+1][n+1][3];
        // 초기값
        dp[1][2][0] = 1;

        for(int i=1; i<=n; i++){
            for(int j =3; j<=n; j++){
                if(map[i][j] == 0){
                    dp[i][j][0] = dp[i][j-1][0] + dp[i][j-1][2];
                    dp[i][j][1] = dp[i-1][j][1] + dp[i-1][j][2];
                    if(map[i-1][j] ==0 && map[i][j-1]==0)
                        //대각선은 3칸을 차지하기 때문
                    dp[i][j][2] = dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];

                }
            }
        }


        System.out.println(dp[n][n][0] + dp[n][n][1] + dp[n][n][2]);

    }

}