import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int vertex, weight;
        Node(int v, int w){
            vertex = v;
            weight = w;
        }
    }
    static List<Node>[] list;
    static int[] dist;
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        list = new List[v+1];
        dist = new int[v+1];
        visit = new boolean[v+1];
        for(int i =0; i<=v; i++){
            list[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for(int i =0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, weight));
        }


        dist[start] = 0;
        PriorityQueue<Node>pq = new PriorityQueue<>((n1, n2)->{
            return Integer.compare(n1.weight, n2.weight);
        });
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(visit[cur.vertex])
                continue;

            visit[cur.vertex] = true;
            for(Node next : list[cur.vertex]){
                // 현재 지점에서 다음 지점을 가는 게 더 빠르다면
                if(dist[next.vertex] > dist[cur.vertex] + next.weight){
                    dist[next.vertex] = dist[cur.vertex] + next.weight;
                    pq.add(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }

        for(int i = 1; i<=v; i++){
            if(visit[i])
                sb.append(dist[i]+"\n");
            else sb.append("INF\n");
        }

        System.out.println(sb);
    }

}
