
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[M][N];
        Queue<int[]> q = new ArrayDeque<>();
        int unripedCount = 0;
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;
                if(input == 1){
                    q.add(new int[]{i,j,0});
                }else if(input == 0)
                    unripedCount++;
            }
        }
        int day = 0;
        int[][]go = {{-1,0}, {1,0},{0,-1}, {0,1}};
        while(unripedCount !=0 && !q.isEmpty()) {
            int[]cur = q.poll();
            for(int i = 0; i<4; i++){
                int moveX = cur[0] + go[i][0];
                int moveY = cur[1] + go[i][1];

                if(moveX<0 || moveX>=M || moveY<0 || moveY>=N
                || map[moveX][moveY] !=0) continue;
                unripedCount--;
                day = Math.max(day, cur[2]+1);
                map[moveX][moveY] = cur[2]+1;
                q.add(new int[]{moveX,moveY,cur[2]+1});
            }
        }
        if(unripedCount != 0){
            System.out.println(-1);
        }
        else
            System.out.println(day);
    }


}