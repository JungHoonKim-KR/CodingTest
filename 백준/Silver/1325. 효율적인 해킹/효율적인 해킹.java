import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean visit[];
    static int[] maxArr;
    static int max=0;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph =new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        maxArr = new int[n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            graph[c].add(p);
        }

        for(int i = 1; i<=n; i++){
            visit = new boolean[n+1];
            dfs(i);
        }
        for(int v : maxArr){
            max = Math.max(max,v);
        }
        for(int i = 1; i<=n; i++){
            if(max == maxArr[i]){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);


    }
    static void dfs(int start){
        visit[start] = true;
        for(int next : graph[start]){
            if(!visit[next]){
                maxArr[next]++;
                dfs(next);
            }
        }
    }


}

