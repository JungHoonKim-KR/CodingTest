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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];

        for(int i =1; i<=n; i++) parent[i] = i;

        List<Edge>edgeList = new ArrayList<>();
        for(int i =0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            edgeList.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        edgeList.sort((e1, e2)->{
            return Integer.compare(e1.weight, e2.weight);
        });
        long minWeight=0;

        for(Edge edge : edgeList){
            if(isSameRoot(edge.from, edge.to)){
                continue;
            }
            union(edge.from, edge.to);
            minWeight += edge.weight;
        }
        System.out.println(minWeight);
    }
    static boolean isSameRoot(int a, int b){
        return find(a) == find(b);
    }

    static void union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);

        if(parentA != parentB){
            parent[parentB] = parentA;
        }
    }

    static int find(int a){
        if(a == parent[a]) return a;
        else return parent[a] = find(parent[a]);
    }

}
