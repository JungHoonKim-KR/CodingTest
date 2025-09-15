import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main {
    static int N, MIN;
    static boolean[] visit;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        visit = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }
        dfs(1);
        System.out.println(MIN);

    }

    static boolean dfs(int depth) {
        boolean iam = false;
        visit[depth] = true;
        for(int next : graph[depth]){
            if(!visit[next]){
                if(!dfs(next)){
                    iam = true;
                }
            }
        }
        if(iam){
            MIN++;
        }
        return iam;
    }

}