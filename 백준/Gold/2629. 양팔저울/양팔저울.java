import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean dp[][];
    static int n;
    static int w[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());

        w = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int parseInt = Integer.parseInt(st.nextToken());
            w[i] = parseInt;
        }

        dp = new boolean[n+1][40001];
        dfs(0,0);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<m; i++){
            int beads = Integer.parseInt(st.nextToken());

            if(beads>15000) sb.append("N ");
            else if(dp[n][beads]) sb.append("Y ");
            else sb.append("N ");
        }

        System.out.println(sb);
    }
    static void dfs(int idx, int weight){
        if(dp[idx][weight])return;

        dp[idx][weight] = true;
        if(idx ==n) return;

        dfs(idx+1, weight);
        dfs(idx+1, weight + w[idx]);
        dfs(idx+1, Math.abs(weight - w[idx]));

    }
}
