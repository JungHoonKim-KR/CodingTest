import java.util.*;
import java.io.*;

public class Solution {
    static boolean[][] visit;
    static int N, K, MAX;
    static int[][] map;
    static int[][] go = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            int max = 0;
            MAX = 0;
            map = new int[N][N];
            visit = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int input = Integer.parseInt(st.nextToken());
                    map[i][j] = input;
                    max = Math.max(max, input);
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == max && !visit[i][j]) {
                        visit[i][j] = true;
                        dfs(i, j, false, 1);
                        visit[i][j] = false;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(MAX).append("\n");
        }
        System.out.println(sb);

    }

    static void dfs(int startX, int startY, boolean isCut, int length) {
        MAX = Math.max(MAX, length);
        for (int i = 0; i < 4; i++) {
            int moveX = startX + go[i][0];
            int moveY = startY + go[i][1];

            if (moveX < 0 || moveX >= N || moveY < 0 || moveY >= N
                    || visit[moveX][moveY])
                continue;

            // 안깎음
            if (map[startX][startY] > map[moveX][moveY]) {
                visit[moveX][moveY] = true;
                dfs(moveX, moveY, isCut, length + 1);
                visit[moveX][moveY] = false;
            }
            // 깎아야 하는데, 이전에 깎은 적 있는지 확인
            else if (!isCut) {
                // 얼마나 깎아야 하는지?
                int depth = map[moveX][moveY] - map[startX][startY] + 1;
                if (depth > K || depth < 1) continue;
                map[moveX][moveY] -= depth;
                visit[moveX][moveY] = true;

                dfs(moveX, moveY, true, length + 1);

                map[moveX][moveY] += depth;
                visit[moveX][moveY] = false;
            }
        }
    }


}