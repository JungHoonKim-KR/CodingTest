import java.util.*;
import java.io.*;

public class Main {
    static int R, C;
    static char[][] map;
    static int[][] go = {{-1,1},{0,1},{1,1}};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            if (dfs(i, 0)) {
                count++;
            }
        }

        System.out.println(count);
    }

    static boolean dfs(int r, int c) {
        map[r][c] = 'x';

        if (c == C - 1) {
            return true; // 성공
        }

        for (int i = 0; i < 3; i++) {
            int moveX = r + go[i][0];
            int moveY = c + go[i][1];

            if (moveX < 0 || moveX >= R || moveY < 0 || moveY >= C) {
                continue;
            }

            if (map[moveX][moveY] == '.') {
                if (dfs(moveX, moveY)) {
                    return true;
                }
            }
        }

        return false;
    }
}