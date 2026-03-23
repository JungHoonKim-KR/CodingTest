import java.io.*;
import java.util.*;

/*
    4방 탐색
    지점 값이 -1 or 1이면 진행 X
 */
public class Main {
    static int N;
    static int[][] go = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] map;
    static ArrayList<Integer> answer = new ArrayList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        // init

        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = ch[j] - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    dfs(i, j);
                }
            }
        }

        bw.write(answer.size() + "\n");
        Collections.sort(answer);

        for (int i = 0; i < answer.size(); i++) {
            bw.write(answer.get(i) + "\n");
        }
        bw.flush();


    }

    static void dfs(int x, int y) {
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        visited[x][y] = true;
        q.add(new int[]{x, y});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            count++;
            for (int i = 0; i < 4; i++) {

                int nx = cur[0] + go[i][0];
                int ny = cur[1] + go[i][1];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] == 0)
                    continue;

                visited[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }

        answer.add(count);
    }


}

