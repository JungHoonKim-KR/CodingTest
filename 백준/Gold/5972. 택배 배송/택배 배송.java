import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static List<int[]>graph[];
    static long distance[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n+1];
        distance = new long[n+1];
        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[1] = 0;
        for(int i  =0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new int[]{b,c});
            graph[b].add(new int[]{a,c});
        }
        PriorityQueue<int[]>pq = new PriorityQueue<>((o1, o2)->o1[0]-o2[0]);
        pq.add(new int[]{1,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            for(int[] next : graph[cur[0]]){
                if(distance[cur[0]] + next[1] < distance[next[0]]){
                    distance[next[0]] = distance[cur[0]] + next[1];
                    pq.add(new int[]{next[0], (int) distance[next[0]]});
                }
            }
        }
        System.out.println(distance[n]);
    }
}
