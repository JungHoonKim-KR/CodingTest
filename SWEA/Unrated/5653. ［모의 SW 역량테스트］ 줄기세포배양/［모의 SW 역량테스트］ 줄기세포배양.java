import java.util.*;
import java.io.*;
/*
 생명이 1이라고 가정했을 때가 가장 번식이 빠름
 K는 최대 300이므로 최대 150칸 번식됨
 즉 배열 크기는 350 X 350 (N<=50, M<=50)
 */

class Node{
    int x, y, originTime, activeStartTime, activeTime;
    boolean isBreed;
    Node(int x, int y, int originTime, int activeStartTime, int activeTime) {
        this.x = x;
        this.y = y;
        this.originTime = originTime;
        this.activeStartTime = activeStartTime;
        this.activeTime = activeTime;
        this.isBreed = false;
    }
}
public class Solution {
    static int N, M, K, TIME;
    static int[][] go = {{-1,0},{1,0},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            TIME = 1;
            // 입력 값들의 좌표에서 + 150씩 해야함
            // x,y,time
            PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2)->{
                if(n1.activeStartTime == n2.activeStartTime){
                    // 생명력이 높은 순서
                    return  Integer.compare(n2.originTime,n1.originTime);
                }
                return  Integer.compare(n1.activeStartTime,n2.activeStartTime);
            });
            PriorityQueue<Node>breedQueue = new PriorityQueue<>((n1, n2)->n2.originTime - n1.originTime);

            boolean[][] visit = new boolean[350][350];
            for(int i = 0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j<M; j++){
                    int time = Integer.parseInt(st.nextToken());
                    if(time != 0){
                        pq.add(new Node(i+150, j+150, time, time, time));
                        visit[i+150][j+150] = true;
                    }

                }
            }

            while(TIME<=K){
                List<Node>tempList = new ArrayList<>();
                while (!breedQueue.isEmpty()){
                    Node cur = breedQueue.poll();
                    // 아직 번식 안 한 애들 있을 때
                    if(!cur.isBreed){
                        cur.isBreed = true;
                        for(int j = 0; j<4; j++){
                            int moveX = cur.x + go[j][0];
                            int moveY = cur.y + go[j][1];

                            if(!visit[moveX][moveY]){
                                pq.add(new Node(moveX, moveY, cur.originTime, cur.activeStartTime + cur.originTime +1, cur.originTime));
                                visit[moveX][moveY] = true;
                            }
                        }
                    }
                    cur.activeTime--;
                    if(cur.activeTime > 0){
                        tempList.add(cur);
                    }
                }
                breedQueue.addAll(tempList);

                // 번식 가능
                while(!pq.isEmpty() && pq.peek().activeStartTime == TIME){
                    breedQueue.add(pq.poll());
                }

                TIME++;
            }

            sb.append("#").append(tc).append(" ").append(pq.size() + breedQueue.size()).append("\n");
        }
        System.out.println(sb);
    }


}