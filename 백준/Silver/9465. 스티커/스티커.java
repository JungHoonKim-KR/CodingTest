import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(n-->0){
            int N = Integer.parseInt(br.readLine());
            // 0번 열은 0
            int arr[][] = new int[2][N+1];
            int dp[][] = new int[2][N+1];

            for(int i =0; i<2; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j =1; j<=N; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for(int i=2; i<=N; i++){
                dp[0][i] = arr[0][i] + Math.max(dp[1][i-1], dp[1][i-2]);
                dp[1][i] = arr[1][i] + Math.max(dp[0][i-1], dp[0][i-2]);
            }
            sb.append(Math.max(dp[0][N], dp[1][N])+"\n");

        }
        System.out.println(sb);
    }

}
