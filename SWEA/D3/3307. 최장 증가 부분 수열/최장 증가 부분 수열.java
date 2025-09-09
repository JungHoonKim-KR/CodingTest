import java.util.*;
import java.io.*;


public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            int N = Integer.parseInt(br.readLine());

            int[]dp =  new int[N];
            int[]arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.fill(dp, 1);

            int max = 0;
            for(int i =0; i<N; i++){
                for(int j = 0; j<i; j++){
                    if(arr[j] <arr[i]){
                        dp[i] = Math.max(dp[j]+1, dp[i]);
                        max = Math.max(dp[i],max);
                    }
                }
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }




}