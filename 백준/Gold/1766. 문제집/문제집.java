import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int indegree[] = new int[n+1];

        ArrayList<Integer> graph[] = new ArrayList[n+1];
        for(int i =1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            graph[first].add(second);
            indegree[second]++;
        }

        PriorityQueue<Integer>q = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o1,o2);
        });
        for(int i =1; i<=n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur+" ");
            for(int node : graph[cur]){
                if(--indegree[node] == 0){
                    q.add(node);
                }
            }
        }

        System.out.println(sb);
    }
}