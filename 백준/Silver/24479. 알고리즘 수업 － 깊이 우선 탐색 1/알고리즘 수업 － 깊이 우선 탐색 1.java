import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static boolean visit[];
    static List<ArrayList<Integer>> graph;
    static int count=0;
    static int seq[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());
        visit = new boolean[nodeNum+1];
        seq = new int[nodeNum+1];
        graph = new ArrayList<>(nodeNum+1);
        for (int i = 0; i <= nodeNum; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edgeNum; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (ArrayList<Integer> edge : graph) {
            edge.sort(Integer::compareTo);
        }

        dfs(startNode);
        StringBuilder sb = new StringBuilder();
        for(int i =1; i<=nodeNum;i++) {
            sb.append(seq[i]).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int node) {

        visit[node] = true;
        seq[node] = ++count;

        ArrayList<Integer> nodes = graph.get(node);

        for(int n : nodes){
            if(!visit[n]){
                dfs(n);
            }
        }
    }

}
