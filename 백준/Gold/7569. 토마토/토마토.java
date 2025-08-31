
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][][] map = new int[K][M][N];
        Queue<int[]> q = new ArrayDeque<>();
        int unripedCount = 0;
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    int input = Integer.parseInt(st.nextToken());
                    map[i][j][k] = input;
                    if (input == 1) {
                        q.add(new int[]{i, j,k, 0});
                    }
                    else if (input == 0)
                        unripedCount++;
                }
            }
        }
        int day = 0;
        int[][] go = {{-1, 0,0}, {1, 0,0}, {0, -1,0}, {0, 1,0},
                         {0, 0,-1}, {0,0,1}} ;
        while (unripedCount != 0 && !q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 6; i++) {
                int moveZ = cur[0] + go[i][0];
                int moveX = cur[1] + go[i][1];
                int moveY = cur[2] + go[i][2];
                if (moveX < 0 || moveX >= M || moveY < 0 || moveY >= N || moveZ <0 || moveZ >= K
                        || map[moveZ][moveX][moveY] != 0) continue;
                unripedCount--;
                day = Math.max(day, cur[3] + 1);
                map[moveZ][moveX][moveY] = cur[3] + 1;
                q.add(new int[]{moveZ, moveX,moveY, cur[3] + 1});
            }
        }
        if (unripedCount != 0) {
            System.out.println(-1);
        } else
            System.out.println(day);
    }


}