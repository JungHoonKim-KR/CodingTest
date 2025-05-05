import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int schedule[][] = new int[n+1][2];
        for(int i =1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()) };
        }

        int dp[] = new int[n+2];
        for(int day = 1; day<=n; day++){
            int duration = schedule[day][0];
            int cost = schedule[day][1];
                //상담을 하는 경우
            if(day + duration <= n+1){
                dp[day + duration] = Math.max(dp[day + duration], dp[day] + cost);
            }

            // 상담을 안하는 경우
                dp[day+1] = Math.max(dp[day + 1], dp[day]);
        }
        System.out.println(dp[n+1]);

    }
}