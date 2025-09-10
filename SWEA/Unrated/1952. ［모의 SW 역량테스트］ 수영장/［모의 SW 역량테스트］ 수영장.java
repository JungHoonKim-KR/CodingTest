import java.util.*;
import java.io.*;


public class Solution {
    static int[] tickets;
    static int[] monthlyUsing;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T =  Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            tickets = new int[4];
            monthlyUsing = new int[13];
            int[] dp = new int[13];
            Arrays.fill(dp, Integer.MAX_VALUE);
            dp[0] = 0;
            tickets = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i =1; i<=12; i++){
                monthlyUsing[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i<=12; i++){
                // 1일 or 1달은 무조건 가능
                // 처음은 0번 달(무시)
                dp[i] = dp[i-1] + Math.min(monthlyUsing[i] * tickets[0], tickets[1]);
                //3달 이상이라면
                if(i>=3){
                    dp[i] = Math.min(dp[i], dp[i-3] + tickets[2]);
                }
            }
            sb.append("#").append(tc).append(" ");
            sb.append(Math.min(dp[12], tickets[3])).append("\n");
        }
        System.out.println(sb);
    }
}