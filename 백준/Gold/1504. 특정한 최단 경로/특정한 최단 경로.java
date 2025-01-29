import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int vertex;
        long weight;
        Node(int v, long w){
            vertex = v;
            weight = w;
        }
    }
    static long INF = 200000 * 1000;
    static List<Node>[] list;
    static long[] dist;
    static boolean visit[];
    static int v,e;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        visit = new boolean[v+1];
        list = new List[v+1];
        dist = new long[v+1];
        for(int i =0; i<=v; i++){
            list[i] = new ArrayList<>();
        }

        for(int i =0; i<e; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[from].add(new Node(to, weight));
            list[to].add(new Node(from, weight));
        }
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 다엑스트라를 여러 번 하기
        // 1 -> v1 -> v2 -> v
        long result1 = d(1, v1) + d(v1, v2) + d(v2, v);

        // 1 -> v2 -> v1 ->v
        long result2 = d(1, v2) + d(v2, v1) + d(v1, v);
        if(result1 >= INF && result2 >= INF){
            System.out.println(-1);
        }
        else System.out.println(Math.min(result1, result2));

    }

    static long d(int start, int end){
        // 초기화
        Arrays.fill(dist, INF);
        visit = new boolean[v+1];

        PriorityQueue<Node> pq = new PriorityQueue<>((p1, p2)->{
            return Long.compare(p1.weight, p2.weight);
        });

        pq.add(new Node(start, 0));
        dist[start] = 0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(visit[cur.vertex])
                continue;

            visit[cur.vertex] = true;
            for(Node next : list[cur.vertex]){
                if(!visit[end] && dist[next.vertex] > dist[cur.vertex] + next.weight){
                    dist[next.vertex] = dist[cur.vertex] + next.weight;
                    pq.add(new Node(next.vertex, dist[next.vertex]));
                }

            }
        }
        return dist[end];
    }

}
