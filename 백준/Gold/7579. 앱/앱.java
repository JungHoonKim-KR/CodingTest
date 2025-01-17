import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int memoryArr[] = new int[n];
        int costArr[] = new int [n];

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            memoryArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            costArr[i] = Integer.parseInt(st.nextToken());
        }

        int dp[][] = new int[n][10001];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            int memory = memoryArr[i];
            int cost = costArr[i];
            for(int c=0; c<10001; c++){
                if(i==0){
                    if(c>= cost)
                        dp[i][c] = memory;
                }

                else{
                    if(c>= costArr[i]){
                        // 현재 어플을 지우는 경우 vs 현재 어플을 지우지 않는 경우
                        dp[i][c] = Math.max(dp[i-1][c-cost] + memory, dp[i-1][c]);
                    }
                    else
                        dp[i][c] = dp[i-1][c];
                }
                if(dp[i][c] >= m){
                    min = Math.min(min, c);
                }
            }

        }

        System.out.println(min);
    }



}