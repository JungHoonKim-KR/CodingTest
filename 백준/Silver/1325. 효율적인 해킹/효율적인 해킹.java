import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>graph[];
    static boolean visit[];
    static int cnt[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        cnt = new int[n+1];
        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList();
        }

        for(int i =0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            graph[c].add(p);
        }

        for(int i = 1; i<=n; i++){
            visit = new boolean[n+1];
            dfs(i);
        }
        int max =0;
        for(int i : cnt){
            max = Math.max(max, i);
        }

        for(int i = 1; i<=n; i++){
            if(max == cnt[i])
                sb.append(i).append(" ");
        }
        System.out.println(sb);

    }

    static void dfs(int start){
        visit[start] = true;
        cnt[start]++;
        for(int next : graph[start]){
            if(!visit[next]){
                dfs(next);
            }
        }
    }
}

