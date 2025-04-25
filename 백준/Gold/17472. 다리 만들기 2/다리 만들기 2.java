import java.util.*;
import java.io.*;

class Node{
    int no,x,y;
    Node(int no,int x, int y){
        this.no=no;
        this.x = x;
        this.y = y;

    }
}

class Edge{
    Node from, to;
    int distance;
    Edge(Node from, Node to, int distance){
        this.from = from;
        this.to = to;
        this.distance = distance;
    }
}

public class Main {
    static int parent[];
    static boolean visit[][];
    static int arr[][];
    static ArrayList<Node>nodeList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visit = new boolean[n][m];
        // 지역의 개수
        arr = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int groupNumber = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] != 0 && !visit[i][j]){
                    buildIsland(i, j, ++groupNumber);
                }
            }
        }

        parent = new int[groupNumber+1];
        for(int i =1; i <= groupNumber; i++){
            parent[i] = i;
        }


        PriorityQueue<Edge>pq = new PriorityQueue<>((e1, e2)->{
            return  e1.distance - e2.distance;
        });

        // n x n 으로 각 좌표끼리 검증한다
        // 1. x, y 모두 다르면 continue
        // 2. x 혹은 y 가 같은 경우, 거리가 2 이상이면 ok

        for(int i = 0; i<nodeList.size()-1; i++){
            Node node1 = nodeList.get(i);
            for(int j = i+1; j<nodeList.size(); j++){
                Node node2 = nodeList.get(j);
                if((node1.x != node2.x && node1.y != node2.y) || node1.no == node2.no || isSameIsland(node1, node2))
                    continue;


                if(node1.x == node2.x){
                    int distance = Math.abs(node1.y - node2.y)-1;
                    if(distance>=2) pq.add(new Edge(node1,node2,distance));
                }
                else if(node1.y == node2.y){
                    int distance = Math.abs(node1.x - node2.x)-1;
                    if(distance>=2) pq.add(new Edge(node1,node2,distance));
                }
            }

        }

        int result =0;
        int count=0;
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int fromNumber = cur.from.no;
            int toNumber = cur.to.no;
            if(isSameRoot(fromNumber, toNumber))
                continue;

            union(fromNumber, toNumber);
            result += cur.distance;
            count++;
        }


        System.out.println((count == groupNumber -1)? result : -1);

    }

    static int goX[] = {-1, 0, 1, 0};
    static int goY[] = {0, -1, 0, 1};

    static void buildIsland(int x, int y, int groupNumber){
        visit[x][y] = true;
        arr[x][y] = groupNumber;
        nodeList.add(new Node(groupNumber,x,y));
        for(int i =0; i<4; i++){
            int moveX = goX[i] + x;
            int moveY = goY[i] + y;

            if(moveX < 0 || moveX > arr.length-1 || moveY < 0 || moveY > arr[0].length-1 || arr[moveX][moveY]==0 || visit[moveX][moveY])
                continue;
            buildIsland(moveX, moveY, groupNumber);
        }

    }

    static int find(int no){
        if(no == parent[no]) return no;
        else return parent[no] = find(parent[no]);
    }
    static boolean isSameIsland(Node n1, Node n2){
        if(n1.x == n2.x){
            for(int y = Math.min(n1.y, n2.y) +1; y < Math.max(n1.y,n2.y); y++){
                if(arr[n1.x][y] !=0)
                    return true;
            }
        }
        else if(n1.y == n2.y){
            for(int x = Math.min(n1.x, n2.x)+1; x < Math.max(n1.x, n2.x); x++){
                if (arr[x][n1.y] !=0)
                    return true;
            }
        }
        return false;
    }


    static boolean isSameRoot(int fromNumber, int toNumber){
        return find(fromNumber) == find(toNumber);
    }

    static void union(int fromNumber, int toNumber){
        parent[find(toNumber)] = find(fromNumber);
    }
}