import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] map;
    static int[][] go = {{1, 0}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }
        
        // 시작점이자 도착점인 경우
        if (M == 1 && N == 1 && map[0][0] == '1') {
            System.out.println("Yes");
            return;
        }

        if (bfs()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    // BFS 로직을 별도 함수로 분리
    static boolean bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[M][N];

        // 시작점이 갈 수 없는 곳이면 바로 false
        if (map[0][0] == '0') return false;

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 2; i++) {
                int moveX = cur[0] + go[i][0];
                int moveY = cur[1] + go[i][1];

                if (moveX < 0 || moveX >= M || moveY < 0 || moveY >= N
                        || map[moveX][moveY] == '0' || visited[moveX][moveY]) {
                    continue;
                }

                if (moveX == M - 1 && moveY == N - 1) {
                    return true;
                }

                visited[moveX][moveY] = true;
                queue.add(new int[]{moveX, moveY});
            }
        }
        return false;
    }
}