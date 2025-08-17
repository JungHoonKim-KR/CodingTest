import java.io.*;
import java.util.*;

/*
 1. 각 좌표를 이동할 때 마다 필요한 비용을 기록하기 위한 map 생성
 2. queue에서는 이동할 좌표와 해당 좌표로 이동할 때 발생하는 값을 저장한 int[]값을 저장
 */
public class Main {
    static int n;
    static int input[][];
    static int map[][];
    static int gp[][]={{1,0}, {0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        input = new int[n][n];
        map = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(map[i], Integer.MAX_VALUE);
        }
        map[0][0] = 0;
        for (int i = 0; i < n; i++) {
            input[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        PriorityQueue<int[]>pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if(cur[2] > map[cur[0]][cur[1]])
                continue;

            for(int i = 0; i < 2; i++) {
                int moveX = cur[0] + gp[i][0];
                int moveY = cur[1] + gp[i][1];
                if(moveX<0 || moveX>=n || moveY<0 || moveY>=n)
                    continue;

                int cost =0;
                if(input[cur[0]][cur[1]] <= input[moveX][moveY]){
                    cost = input[moveX][moveY] - input[cur[0]][cur[1]] +1;
                }

                if(map[cur[0]][cur[1]] + cost < map[moveX][moveY]){
                    map[moveX][moveY]=map[cur[0]][cur[1]] + cost;
                    pq.add(new int[]{moveX, moveY, map[moveX][moveY]});
                }
            }
        }
        System.out.println(map[n-1][n-1]);
    }
}
