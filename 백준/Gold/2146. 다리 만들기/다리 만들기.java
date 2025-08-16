import java.io.*;
import java.util.*;

/*
 1. 각 대륙의 노드들 대륙별로 넘버링
 2. 각 대륙의 엣지 노드들 찾기 ( 각 노드에서 4방 탐색을 하여 한 방향이라도 0이 있으면 엣지)
 3. 엣지 노드를 bfs 큐에 모두 넣고 가장 먼저 다른 대륙에 도착하면 최소 길이의 다리
 */
class Node{
    int groupNumber, x, y;
    Node(int g, int x, int y){
        groupNumber = g;
        this.x = x;
        this.y = y;
    }
}
class Bridge{
    Node node;
    int length;
    boolean[][]visit;
    Bridge(Node node, int length, boolean[][]visit){
        this.node = node;
        this.length = length;
        this.visit = visit;
    }
}
public class Main {
    static int n, groupNumber=1;
    static int[][] map;
    static boolean[][] visit;
    static int[][] go = {{-1,0},{1,0},{0,1},{0,-1}};
    static List<Node>nodeList = new ArrayList();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n =Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 1
        visit = new boolean[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!visit[i][j] && map[i][j] == 1){
                    ++groupNumber;
                    nodeList.add(new Node(groupNumber, i, j));
                    visit[i][j] = true;
                    map[i][j] = groupNumber;
                    dfs(i, j);
                }
            }
        }
        Queue<Bridge> q = new ArrayDeque<>();
        // 2
        for(Node node : nodeList){
            if(isEdgeNode(node.x, node.y)){
                q.add(new Bridge(node, 0, new boolean[n][n]));
            }
        }

        // 3
//        visit = new boolean[n][n];
        outer: while(!q.isEmpty()){
            Bridge curBridge = q.poll();
            Node curNode = curBridge.node;
            curBridge.visit[curNode.x][curNode.y] = true;
            for(int i = 0; i<4; i++){
                int nextX = curBridge.node.x + go[i][0];
                int nextY = curBridge.node.y + go[i][1];
                if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || map[nextX][nextY] == curNode.groupNumber || curBridge.visit[nextX][nextY])
                    continue;

                if(map[nextX][nextY] != 0 && map[nextX][nextY] != curNode.groupNumber){
                    System.out.println(curBridge.length);
                    break outer;
                }
                curBridge.visit[nextX][nextY] = true;
                q.add(new Bridge(new Node(curNode.groupNumber, nextX, nextY), curBridge.length+1, curBridge.visit));
            }
        }


    }
    static void dfs(int startX, int startY){
        for(int i = 0; i<4; i++){
            int nextX = startX + go[i][0];
            int nextY = startY + go[i][1];
            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || visit[nextX][nextY]|| map[nextX][nextY] == 0){
                continue;
            }
            nodeList.add(new Node(groupNumber, nextX, nextY));
            visit[nextX][nextY] = true;
            // 다리 제작 시 도착 node가 같은 대륙인지 판단하는 자료
            map[nextX][nextY] = groupNumber;
            dfs(nextX, nextY);
        }
    }

    static boolean isEdgeNode(int startX, int startY){
        for(int i  =0; i<4; i++){
            int nextX = startX + go[i][0];
            int nextY = startY + go[i][1];

            if(nextX < 0 || nextX >= n || nextY < 0 || nextY >= n)
                continue;
            if(map[nextX][nextY] == 0){return true;}
        }
        return false;
    }

}
