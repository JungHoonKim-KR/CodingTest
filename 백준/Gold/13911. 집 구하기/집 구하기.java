import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main {
    static int N;
    static List<int[]>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new  StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        while (E-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new int[]{b, c});
            graph[b].add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        long[] macDistances = new long[N + 1];
        Arrays.fill(macDistances, Integer.MAX_VALUE);
        ArrayList<Integer>macList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        PriorityQueue<long[]> macQueue = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));

        while (M-- > 0) {
            int m = Integer.parseInt(st.nextToken());
            macList.add(m);
            macDistances[m] = 0;
            macQueue.add(new long[]{m, 0});
        }

        dijkstra(macQueue, macDistances);

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());


        long[] startDistances = new long[N + 1];
        Arrays.fill(startDistances, Integer.MAX_VALUE);
        ArrayList<Integer>startList = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        PriorityQueue<long[]> startQueue = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        while (S-- > 0) {
            int s = Integer.parseInt(st.nextToken());
            startList.add(s);
            startDistances[s] = 0;
            startQueue.add(new long[]{s, 0});
        }
        dijkstra(startQueue, startDistances);
        long result = Long.MAX_VALUE;
        for(int i = 1; i<=N; i++){
            if(!macList.contains(i) && !startList.contains(i)){
                if(macDistances[i] <=x && startDistances[i] <=y){
                    result = Math.min(result, startDistances[i]+macDistances[i]);
                }
            }
        }

        System.out.println(result ==  Long.MAX_VALUE? -1 : result);

    }

    static void dijkstra(PriorityQueue<long[]> pq, long[] dist) {
        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            int curPoint = (int)cur[0];
            long curDist = cur[1];

            if(dist[curPoint] < curDist) {
                continue;
            }

            for(int[] next : graph[curPoint]) {
                if(dist[next[0]] > dist[curPoint] + next[1]) {
                    dist[next[0]] = dist[curPoint] + next[1];
                    pq.offer(new long[]{next[0], dist[next[0]]});
                }
            }

        }

    }

}