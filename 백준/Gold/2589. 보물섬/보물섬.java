import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] go = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        int result = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    result = Math.max(result, bfs(i,j));
                }
            }
        }
        System.out.println(result);
    }
    static int bfs(int sX, int sY) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{sX, sY, 0});
        int result = 0;
        boolean[][] visit = new boolean[N][M];
        int[][] distanceMap = new int[N][M];
        visit[sX][sY] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int moveX = cur[0] + go[i][0];
                int moveY = cur[1] + go[i][1];

                if (moveX < 0 || moveX >= N || moveY < 0 || moveY >= M
                        || visit[moveX][moveY] || map[moveX][moveY] == 'W')
                    continue;

                visit[moveX][moveY] = true;
                distanceMap[moveX][moveY] = cur[2] + 1;
                result = Math.max(result, distanceMap[moveX][moveY]);
                queue.add(new int[]{moveX, moveY, cur[2] + 1});
            }


        }
        return result;
    }

}