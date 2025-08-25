import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N,M, start, end,result;
    static List<int[]>[]graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        for(int i = 0; i < N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b,c});
            graph[b].add(new int[]{a,c});
        }
        solve();

    }
    static void solve(){
        int dist[] = new int[N];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->o2[1]-o1[1]);
        dist[start] = Integer.MAX_VALUE;
        pq.add(new int[]{start, Integer.MAX_VALUE});

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(cur[1] < dist[cur[0]]){
                continue;
            }
            for(int[] next : graph[cur[0]]){
                int nextDist = Math.min(cur[1], next[1]);
                if(nextDist > dist[next[0]]){
                    dist[next[0]] = nextDist;
                    pq.add(new int[]{next[0], nextDist});
                }
            }
        }
        System.out.println(dist[end]);
    }


}