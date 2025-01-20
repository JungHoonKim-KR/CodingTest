import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean visit[];
    static List<ArrayList<Integer>> graph;
    static int count = 0;
    static List<Integer> seq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nodeNum = Integer.parseInt(st.nextToken());
        int edgeNum = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        visit = new boolean[nodeNum+1];
        seq = new ArrayList<>();

        for(int i =0; i<=nodeNum; i++){
            graph.add(new ArrayList<>());
        }

        for(int i =0; i<edgeNum; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(ArrayList<Integer> list : graph){
            list.sort(Integer::compareTo);
        }

        dfs(startNode);
        for(int node : seq){
            sb.append(node+" ");
        }
        sb.append("\n");

        count=0;
        visit = new boolean[nodeNum+1];
        seq =new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);

        while(!queue.isEmpty()){
            int poll = queue.poll();
            if(!visit[poll]){
                visit[poll] = true;
                seq.add(poll);
                ArrayList<Integer> list = graph.get(poll);
                queue.addAll(list);
            }
        }

        for(int node : seq){
            sb.append(node+" ");
        }
        System.out.println(sb);

    }

    static void dfs(int node){
        visit[node] = true;
        seq.add(node);
        ArrayList<Integer> integers = graph.get(node);
        for(int n : integers){
            if(!visit[n]){
                dfs(n);
            }
        }

    }



}
