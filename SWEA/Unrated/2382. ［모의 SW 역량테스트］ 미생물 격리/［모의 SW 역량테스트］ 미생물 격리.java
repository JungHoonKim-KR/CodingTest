
import java.io.*;
import java.util.*;
class Node{
    int x,y, size, dir;
    Node(int x,int y, int size, int dir){
        this.x=x;
        this.y=y;
        this.size=size;
        this.dir=dir;
    }
}

public class Solution {
    static int N, M,K;
    static int[][]go = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            // nodeList 생성
            List<Node> nodeList = new ArrayList<>();

            for(int i = 0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                nodeList.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()) ));
            }
            // nodeList 반복하면서 각 노드들 방향대로 움직임
            for(int i = 0; i<M; i++){
                HashMap<Integer, List<Node>> map = new HashMap<>();
                for(Node node : nodeList){
                    // 이동
                    node.x += go[node.dir][0];
                    node.y += go[node.dir][1];
                    if(node.x == 0 || node.x == N-1 || node.y == 0 || node.y == N-1){
                        node.size/=2;
                        if(node.dir == 1){
                            node.dir = 2;
                        }
                        else if(node.dir == 2){
                            node.dir = 1;
                        }
                        else if(node.dir == 3){
                            node.dir = 4;
                        }
                        else if(node.dir == 4){
                            node.dir = 3;
                        }
                    }

                    // 살아있다면
                    if(node.size != 0){
                        int key = node.x * N + node.y;
                        map.computeIfAbsent(key, k-> new ArrayList<Node>()).add(node);
                    }
                }

                // 집계
                // 움직일 때 각 좌표에 노드들을 넣고 합치기 처리
                List<Node>tempList = new ArrayList<>();
                for(List<Node>list : map.values()){
                    if(list.size() == 1){
                        tempList.add(list.get(0));
                    }
                    else{
                        int maxSize = 0;
                        int dir = 0;
                        int sum = 0;
                        for(Node node : list){
                            if(maxSize< node.size){
                                maxSize = node.size;
                                dir = node.dir;
                            }
                            sum += node.size;
                        }
                        tempList.add(new Node(list.get(0).x,list.get(0).y,sum,dir));
                    }

                }
                nodeList = tempList;
            }
            int result = 0;
            for(Node node : nodeList){
                result += node.size;
            }
            sb.append(result).append("\n");

        }
        System.out.println(sb);
    }

}