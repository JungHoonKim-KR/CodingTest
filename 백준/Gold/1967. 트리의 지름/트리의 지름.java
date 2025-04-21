import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<int[]> graph[];
    static boolean visit[];
    static int maxNode;
    static int maxDistance;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        visit = new boolean[n+1];
        for(int i=0; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b,c});
            graph[b].add(new int[]{a,c});
        }

        dfs(1,0);
        visit = new boolean[n+1];
        dfs(maxNode,0);
        System.out.println(maxDistance);
    }

    static void dfs(int node, int sum){
        visit[node] = true;

        if(sum > maxDistance){
            maxDistance = sum;
            maxNode = node;
        }

        for(int next[]:graph[node]){
            if(!visit[next[0]]){
                dfs(next[0], sum+next[1]);
            }
        }
    }




}
