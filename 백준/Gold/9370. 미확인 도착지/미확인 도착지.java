import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<int[]>graph[];
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (tc-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int cross1 = Integer.parseInt(st.nextToken());
            int cross2 = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n+1];
            for(int i =1; i<=n; i++){
                graph[i] = new ArrayList<>();
            }
            for(int i =0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                graph[a].add(new int[]{b, d});
                graph[b].add(new int[]{a, d});

            }

            ArrayList<Integer> result = new ArrayList<>();
            for(int i =0; i<k; i++){
                int target = Integer.parseInt(br.readLine());
                int path1 = func(n,start,cross1) + func(n,cross1, cross2) + func(n,cross2,target);
                int path2 = func(n,start,cross2) + func(n,cross2, cross1) + func(n,cross1,target);
                int path = func(n,start,target);
                if(path == path1 || path == path2){
                    result.add(target);
                }
            }
            result.sort(Comparator.naturalOrder());

            for(int r : result){
                sb.append(r+" ");
            }
            sb.append('\n');

        }
        System.out.println(sb);
    }

    static int func(int n , int start, int end){
        visit = new boolean[n+1];
        int distance[] = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->{
            return Integer.compare(o1[1],o2[1]);
        });
        q.add(new int[]{start,0});
        distance[start]=0;
        while(!q.isEmpty()){
            int cur[] = q.poll();

            if(!visit[cur[0]]){
                visit[cur[0]] = true;
                for(int next[] : graph[cur[0]]){
                    if(distance[next[0]] > distance[cur[0]] + next[1]){
                        distance[next[0]] = distance[cur[0]] + next[1];
                        q.add(new int[]{next[0], distance[next[0]]});
                    }
                }

            }
        }
        return distance[end];
    }



}