import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int color[];
    static List<List<Integer>>list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            list = new ArrayList<>();
            color = new int[v+1];
            for (int i = 0; i <= v; i++) {
                list.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                list.get(from).add(to);
                list.get(to).add(from);
            }
            boolean isBipartite = true;
            for(int i=1; i<=v; i++){
                int c;
                if(color[i] !=0){
                    c = color[i];
                }
                else c =1;
                if(!bfs(i, c)){
                    isBipartite=false;
                    break;
                }

            }
            if(isBipartite){
                sb.append("YES\n");
            }
            else sb.append("NO\n");
        }
        System.out.println(sb);
    }
    static boolean bfs(int vertex, int c){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        color[vertex] = c;

        while(!queue.isEmpty()){
            Integer v = queue.poll();
            List<Integer> integers = list.get(v);
            for(int i=0; i<integers.size(); i++){
                int u = integers.get(i);
                if(color[v] == color[u]){
                    return false;
                }
                if(color[u] == 0){
                    color[u] = color[v] * -1;
                    queue.add(u);
                }
            }
        }
        return true;
    }

}