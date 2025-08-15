import java.io.*;
import java.util.*;

class Node{
    int no, x, y;
    Node(int no, int x, int y){
        this.no = no;
        this.x = x;
        this.y = y;
    }
}
class Edge{
    Node n1, n2;
    int distance;
    Edge(Node n1, Node n2, int distance){
        this.n1 = n1;
        this.n2 = n2;
        this.distance = distance;
    }
}
public class Main {
    static int n, m, groupNumber, count, result;
    static char[][] map;
    static boolean[][] visit;
    static int[][] go = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[] parent;
    static List<Node>nodeList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visit = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == '1' && !visit[i][j]) {
                    visit[i][j] = true;
                    ++groupNumber;
                    buildIsland(i,j);
                }
            }
        }

        PriorityQueue<Edge>edgeQueue = new PriorityQueue<>((e1, e2)->{
            return e1.distance - e2.distance;
        });

        for(int i = 0; i< nodeList.size()-1; i++){
            Node n1 = nodeList.get(i);
            for(int j = i+1; j< nodeList.size(); j++){
                Node n2 = nodeList.get(j);
                if(n1.no != n2.no && (n1.x == n2.x || n1.y == n2.y) && isEdge(n1,n2)){
                    int dist = 0;
                    if(n1.x == n2.x){
                        dist = Math.abs(n1.y - n2.y)-1;
                    }
                    else{
                        dist = Math.abs(n1.x - n2.x)-1;
                    }
                    if(dist >=2)
                        edgeQueue.add(new Edge(n1, n2, dist));
                }
            }
        }
        parent = new int[groupNumber+1];
        for(int i = 1; i<=groupNumber; i++){
            parent[i] = i;
        }

        while (!edgeQueue.isEmpty()){
            Edge curEdge = edgeQueue.poll();
            if(find(curEdge.n1.no) != find(curEdge.n2.no)){
                union(curEdge.n1.no, curEdge.n2.no);
                result += curEdge.distance;
                count++;
            }
        }
        System.out.println(count == groupNumber-1 ? result : -1);
    }

    static void buildIsland(int startX, int startY) {
        nodeList.add(new Node(groupNumber, startX, startY));

        for(int i = 0; i<4; i++){
            int moveX = startX + go[i][0];
            int moveY = startY + go[i][1];
            if(moveX <0 || moveX>=n || moveY<0 || moveY>=m || map[moveX][moveY] =='0' || visit[moveX][moveY])
                continue;
            visit[moveX][moveY] = true;
            buildIsland(moveX, moveY);
        }
    }
    static boolean isEdge(Node n1, Node n2){
        if(n1.x == n2.x){
            for(int y = Math.min(n1.y, n2.y)+1; y<Math.max(n1.y, n2.y); y++){
                if(map[n1.x][y] == '1')
                    return false;
            }
        }
        if(n1.y == n2.y){
            for(int x = Math.min(n1.x, n2.x)+1; x<Math.max(n1.x, n2.x); x++){
                if(map[x][n1.y] == '1')
                    return false;
            }
        }
        return true;
    }
    static int find(int no){
        if(parent[no] == no)return no;
        return parent[no] = find(parent[no]);
    }
    static void union(int n1, int n2){
        int p1 = find(n1);
        int p2 = find(n2);
        if(p1 != p2){
            parent[p2] = p1;
        }
    }

}
