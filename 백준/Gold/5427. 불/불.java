import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char arr[][];
    static int map[][], dist[][];
    static int go[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            arr = new char[m][n];
            map = new int[m][n];
            dist = new int[m][n];
            int humanX = 0, humanY = 0;
            for (int i = 0; i < m; i++) {
                String input = br.readLine();
                Arrays.fill(map[i], -1);
                Arrays.fill(dist[i], -1);
                for (int j = 0; j < n; j++) {
                    char c = input.charAt(j);
                    arr[i][j] = c;
                    if (c == '@') {
                        humanX = i;
                        humanY = j;
                    }
                }
            }

            Queue<int[]> q = new ArrayDeque<>();
            // 불 먼저 세팅
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == '*') {
                        map[i][j] = 0;
                        q.add(new int[]{i, j});
                    }
                }
            }

            while (!q.isEmpty()) {
                int[] cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int moveX = cur[0] + go[i][0];
                    int moveY = cur[1] + go[i][1];

                    if (moveX < 0 || moveX >= m || moveY < 0 || moveY >= n || arr[moveX][moveY] == '#' || map[moveX][moveY] != -1)
                        continue;
                    map[moveX][moveY] = map[cur[0]][cur[1]] + 1;
                    q.add(new int[]{moveX, moveY});
                }
            }

            // 사람이 지날 때 사람의 count < map이면 통과 가능
            boolean flag = false;
            dist[humanX][humanY] = 0;
            q.add(new int[]{humanX, humanY});
            outer:while (!q.isEmpty()) {
                int[] cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int moveX = cur[0] + go[i][0];
                    int moveY = cur[1] + go[i][1];
                    if (moveX < 0 || moveX >= m || moveY < 0 || moveY >= n) {
                        sb.append(dist[cur[0]][cur[1]]+ 1 + "\n");
                        flag = true;
                        break outer;
                    }
                    if (arr[moveX][moveY] == '#' || dist[moveX][moveY] != -1)
                        continue;

                    if(dist[cur[0]][cur[1]]+1 < map[moveX][moveY] || map[moveX][moveY] ==-1){
                        dist[moveX][moveY] = dist[cur[0]][cur[1]] + 1;
                        q.add(new int[]{moveX, moveY});
                    }

                }
            }
            if (!flag)
                sb.append("IMPOSSIBLE\n");
        }
        System.out.println(sb);
    }
}
