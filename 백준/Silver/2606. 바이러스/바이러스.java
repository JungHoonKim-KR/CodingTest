import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean visit[];
    static List<ArrayList<Integer>> graph;
    static int count = -1;
//    static int seq[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int edgeNum = Integer.parseInt(br.readLine());

        graph = new ArrayList<>(n+1);
        visit = new boolean[n+1];
        StringTokenizer st;

        for(int i =0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i =0; i<edgeNum; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(1);
        System.out.println(count);


    }

    static void dfs(int node){
        visit[node] = true;
        count++;
        for(int n : graph.get(node)){
            if(!visit[n]){
                dfs(n);
            }
        }
    }


}
