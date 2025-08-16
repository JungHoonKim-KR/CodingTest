import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[n+1];
        int[] indegree = new int[n+1];

        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList();
        }
        Arrays.fill(indegree,0);
        for(int i  =0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            indegree[end]++;
            graph[start].add(end);
        }

        Queue<int[]>q = new ArrayDeque<>();
        for(int i =1; i<=n; i++){
            if(indegree[i]==0)
                q.add(new int[]{i,1});
        }
        int result[] =new int[n+1];
        while(!q.isEmpty()){
            int[] cur = q.poll();
            result[cur[0]] = cur[1];
            for(int next : graph[cur[0]]){
                if(--indegree[next] == 0)
                    q.add(new int[]{next, cur[1]+1});
            }
        }
        for(int i =1; i<=n; i++){
            sb.append(result[i]+" ");
        }
        System.out.println(sb);
    }
}
