import java.util.*;
import java.io.*;

class Node{
    int no;
    double x,y;
    Node(int no,double x,double y){
        this.no=no;
        this.x=x;
        this.y=y;
    }
}

class Edge{
    Node from, to;
    double weight;
    Edge(Node from,Node to,double weight){
        this.from=from;
        this.to=to;
        this.weight=weight;
    }
}

public class Main {
    static int parent[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        parent = new int[n+1];

        for(int i =1; i<=n; i++) parent[i] = i;

        Node nodeList[] = new Node[n+1];
        StringTokenizer st;
        for(int i =1; i<=n; i++){
            st = new StringTokenizer(br.readLine());
            nodeList[i] = new Node(i,Double.parseDouble(st.nextToken()),Double.parseDouble(st.nextToken()));
        }

        ArrayList<Edge> edgeList = new ArrayList<>();

        for(int i =1; i<=n-1; i++){
            Node node1 = nodeList[i];
            for(int j = i+1; j<=n; j++){
                Node node2 = nodeList[j];
                edgeList.add(new Edge(node1, node2, calDistance(node1, node2)));
            }
        }

        edgeList.sort((e1, e2)->{
            return Double.compare(e1.weight,e2.weight);
        });

        double minDistance=0.0;

        for(Edge edge: edgeList){
            if(!isSameRoot(edge.from, edge.to)){
                minDistance += edge.weight;
                union(edge.from, edge.to);
            }
        }
        System.out.println(Math.round(minDistance * 100.0) / 100.0);

    }
    static double calDistance(Node from, Node to){
        return Math.sqrt(Math.pow(from.x-to.x,2)+Math.pow(from.y-to.y,2));
    }

    static boolean isSameRoot(Node node1, Node node2){
        return find(node1.no) == find(node2.no);
    }

    static void union(Node node1, Node node2){
        if(!isSameRoot(node1, node2)){
            parent[find(node2.no)]=parent[find(node1.no)];
        }
    }

    static int find(int n){
        if(n == parent[n]) return n;
        return parent[n] = find(parent[n]);
    }

}
