import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> graph[];
    static long dp[];
    static int buildTime[];
    static int maxTime = 100001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        dp = new long[n+1];
        buildTime = new int[n+1];
        for(int i = 0; i < n+1; i++){
            graph[i] = new ArrayList<>();
        }

        Arrays.fill(dp, maxTime);

        for(int i = 1; i<n+1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());
            int num;
            while((num  =Integer.parseInt(st.nextToken())) != -1){
                graph[i].add(num);
            }
        }

        StringBuilder sb = new StringBuilder();


        for(int i = 1; i<n+1; i++){
            dfs(i);
            sb.append(dp[i]+"\n");
        }

        System.out.println(sb);



    }
    static long dfs(int number){
        if(dp[number] != maxTime) return dp[number];

        long max = 0;
        for(int next : graph[number]){
            max = Math.max(max, dfs(next));
        }

        return dp[number] = buildTime[number] + max;
    }


}