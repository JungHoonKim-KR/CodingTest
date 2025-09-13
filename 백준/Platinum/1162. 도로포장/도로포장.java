import java.util.*;
import java.io.*;

/*
다엑스트라 + 현재 이 시뮬레이션에서 포장을 몇 번 했는가?
 */
public class Main {
    static int N, K;
    static List<int[]>[] adj;
    static long[][] distances;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //초기화
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N + 1];
        distances = new long[N+1][K+1];
        for(int i =1; i<=N; i++){
            adj[i] = new ArrayList<>();
            Arrays.fill(distances[i], Long.MAX_VALUE);
        }
        Arrays.fill(distances[1], 0);

        //입력
        for(int i = 1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj[a].add(new int[]{b,c});
            adj[b].add(new int[]{a,c});
        }

        dijkstra();

        System.out.println(Arrays.stream(distances[N]).min().getAsLong());

    }

    static void dijkstra(){
        // 시작 1
        // 목적지, 시간, 포장 횟수
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)-> Long.compare(a[1],b[1]));
        pq.add(new long[]{1,0,0});
        while (!pq.isEmpty()){
            long[] cur = pq.poll();
            int curPoint = (int) cur[0];
            long time = cur[1];
            int paveCount = (int) cur[2];
            // 가지치기
            if(distances[curPoint][paveCount] < time)
                continue;

            for(int[] next : adj[curPoint]){
                int nextPoint = next[0];
                int nextTime = next[1];

                // 이번에 포장 안하기
                if(distances[nextPoint][paveCount] > distances[curPoint][paveCount] + nextTime){
                    distances[nextPoint][paveCount] = distances[curPoint][paveCount] + nextTime;
                    pq.add(new long[]{nextPoint,distances[nextPoint][paveCount],paveCount});
                }

                // 이번에 포장 하기
                if(paveCount <K && distances[nextPoint][paveCount+1] > distances[curPoint][paveCount]){
                    distances[nextPoint][paveCount+1] = distances[curPoint][paveCount];
                    pq.add(new long[]{nextPoint,distances[nextPoint][paveCount+1],paveCount+1});
                }
            }
        }
    }
}