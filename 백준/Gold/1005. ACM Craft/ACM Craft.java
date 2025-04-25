import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer> graph[];
    static int indegree[];
    static int weights[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            graph= new ArrayList[n+1];
            indegree= new int[n+1];
            weights = new int[n+1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
                weights[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 1; i <= m; i++){
                st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                graph[first].add(second);
                indegree[second]++;
            }

            int target = Integer.parseInt(br.readLine());

            int dp[] = new int[n+1];
            Queue<Integer> q = new LinkedList<>();

            for(int i=1; i<=n; i++){
                if(indegree[i] == 0){
                    q.add(i);
                    dp[i] = weights[i];
                }
            }
            while(!q.isEmpty()){
                int cur = q.poll();
                for(int next: graph[cur]){
                    dp[next] = Math.max(dp[next], dp[cur] + weights[next]);
                    if(--indegree[next] == 0){
                        q.add(next);
                    }
                }
            }
            sb.append(dp[target]+"\n");
        }
        System.out.println(sb);

    }

}