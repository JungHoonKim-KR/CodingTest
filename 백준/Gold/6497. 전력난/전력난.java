import java.util.*;
import java.io.*;
class Edge{
    int from, to, weight;

    Edge(int from, int to, int weight){
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

public class Main {
    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0) break;
            Edge[] edges = new Edge[m];
            parent = new int[n];

            for(int i = 0; i < n; i++){
                parent[i] = i;
            }
            for(int i =0; i<m; i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());

                edges[i] = new Edge(from, to, weight);
            }
            Arrays.sort(edges, (e1, e2)->{
                return e1.weight - e2.weight;
            });

            long sum = Arrays.stream(edges).mapToInt(e -> e.weight).sum();
            for(Edge edge : edges){
                if(!isSameRoot(edge.from, edge.to)){
                    union(edge.from, edge.to);
                    sum -= edge.weight;
                }
            }
            sb.append(sum+"\n");
        }

        System.out.println(sb);

    }
    static boolean isSameRoot(int a, int b){
        return find(a) == find(b);
    }

    static void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);

        parent[parentB] = parentA;
    }

    static int find(int a){
        if(a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }
}