import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static int [][] costArr;
    static int[][] go = {{-1,0},{1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc=1;
        while(true){
            n =Integer.parseInt(br.readLine());
            if(n == 0)
                break;

            map = new int[n][n];
            costArr = new int[n][n];
            for(int i = 0; i < n; i++){
                Arrays.fill(costArr[i], Integer.MAX_VALUE);
            }
            for(int i=0;i<n;i++){
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            costArr[0][0] = map[0][0];
            PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)-> a[2] - b[2]);
            pq.add(new int[]{0,0,map[0][0]});
            while(!pq.isEmpty()){
                int[]cur = pq.poll();
                for(int i =0; i<4; i++){
                    int moveX = cur[0] + go[i][0];
                    int moveY = cur[1] + go[i][1];
                    if(moveX <0 || moveX>=n || moveY<0 || moveY>=n)
                        continue;

                    if(costArr[cur[0]][cur[1]] + map[moveX][moveY] < costArr[moveX][moveY]){
                        costArr[moveX][moveY]=costArr[cur[0]][cur[1]] + map[moveX][moveY];
                        pq.add(new int[]{moveX, moveY, costArr[moveX][moveY]});
                    }
                }
            }
            sb.append("Problem ").append(tc++).append(": ").append(costArr[n-1][n-1]).append("\n");
        }
        System.out.println(sb);

    }
}
