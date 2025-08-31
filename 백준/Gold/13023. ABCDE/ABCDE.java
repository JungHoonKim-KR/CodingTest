
import java.io.*;
import java.util.*;

public class Main {
    static int N,M;
    static boolean flag;
    static List<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new List[N];
        for(int i = 0; i<N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        for(int i = 0; i<N; i++){
            dfs(0,i, new boolean[N]);
            if (flag)
                break;
        }
        if(flag)
            System.out.println(1);
        else System.out.println(0);

    }

    static void dfs(int depth, int start, boolean[] visit){
        if(depth == 4){
            flag=true;
            return;
        }
        visit[start] = true;
        for(int next : graph[start]){
            if(!visit[next]){
                visit[next]=true;
                dfs(depth+1, next,visit);
                visit[next]=false;
            }
        }
        visit[start]=false;
    }


}