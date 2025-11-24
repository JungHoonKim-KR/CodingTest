import java.io.*;
import java.util.*;

public class Main {
    static boolean[][] visited;
    static char[][] map;
    static int N, M, K, count = 0;
    static int[][] go = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char input = s.charAt(j);
                map[i][j] = input;
            }
        }
        visited[N-1][0] = true;
        solve(N - 1, 0, 1);
        System.out.println(count);


    }

    static void solve(int startX, int startY, int dist) {
        if (startX == 0 && startY == M - 1) {
            if (dist == K) {
                count++;
            }
            return;
        }
        for (int i = 0; i < 4; i++) {
            int moveX = startX + go[i][0];
            int moveY = startY + go[i][1];

            if (moveX < 0 || moveX >= N || moveY < 0 || moveY >= M
                    || visited[moveX][moveY] || map[moveX][moveY] == 'T') {
                continue;
            }
            visited[moveX][moveY] = true;
            solve(moveX, moveY, dist + 1);
            visited[moveX][moveY] = false;
        }


    }

}
