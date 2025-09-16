import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

/*
1:동, 2:서, 3:북, 4:남
 */

public class Main {
    static int[] dice;
    static int[][] map;
    static int N, M, curX, curY;
    static int[][] go = {{},{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        curX = Integer.parseInt(st.nextToken());
        curY = Integer.parseInt(st.nextToken());

        int k = Integer.parseInt(st.nextToken());
        dice = new int[7];
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        while (k-- > 0) {
            int command = Integer.parseInt(st.nextToken());
            if(run(command)){
                // 상단 주사위
                sb.append(dice[6]).append("\n");
            }

        }
        System.out.println(sb);

    }

    static boolean run(int command) {
        int moveX = curX + go[command][0];
        int moveY = curY + go[command][1];

        if (moveX < 0 || moveX >= N || moveY < 0 || moveY >= M) {
            return false;
        }
        changeDiceNumber(command);

        if(map[moveX][moveY] == 0) {
            map[moveX][moveY] = dice[1];
        }
        else{
            dice[1] = map[moveX][moveY];
            map[moveX][moveY] = 0;
        }
        curX = moveX;
        curY = moveY;
        return true;
    }
    static void changeDiceNumber(int command){
        if(command == 1){
            int temp = dice[1];
            dice[1] = dice[2];
            dice[2] = dice[6];
            dice[6] = dice[3];
            dice[3] = temp;
        }
        else if(command == 2){
            int temp = dice[1];
            dice[1]= dice[3];
            dice[3] = dice[6];
            dice[6] = dice[2];
            dice[2] = temp;
        }
        else if(command == 3){
            int temp = dice[1];
            dice[1] = dice[4];
            dice[4] = dice[6];
            dice[6] = dice[5];
            dice[5] = temp;
        }
        else{
            int temp = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[6];
            dice[6] = dice[4];
            dice[4] = temp;
        }
    }

}