import java.io.*;
import java.util.*;

public class Main {
    static int n, groupNumber, result = Integer.MAX_VALUE;
    static int arr[][];
    static int map[][][];
    static boolean visit[][];
    static int go[][] = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        map = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j] && arr[i][j] != 0) {
                    visit[i][j] = true;
                    groupNumber++;
                    arr[i][j] = groupNumber;
                    buildIsland(i, j);
                }
            }
        }
        queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != 0) {
                    insertEdgeNode(i, j);
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int moveX = cur[0] + go[i][0];
                int moveY = cur[1] + go[i][1];

                if (moveX < 0 || moveX >= n || moveY < 0 || moveY >= n
                        || map[cur[0]][cur[1]][0] == map[moveX][moveY][0]
                        || map[cur[0]][cur[1]][0] == arr[moveX][moveY])
                    continue;

                if (arr[moveX][moveY] == 0 && map[moveX][moveY][0] == 0) {
                    map[moveX][moveY][0] = map[cur[0]][cur[1]][0];
                    map[moveX][moveY][1] = map[cur[0]][cur[1]][1] + 1;
                    queue.add(new int[]{moveX, moveY});
                } else {
                    result = Math.min(result, map[cur[0]][cur[1]][1] + map[moveX][moveY][1]);
                }
            }
        }
        System.out.println(result);

    }

    static void buildIsland(int startX, int startY) {
        queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int moveX = cur[0] + go[i][0];
                int moveY = cur[1] + go[i][1];

                if (moveX < 0 || moveX >= n || moveY < 0 || moveY >= n || visit[moveX][moveY] || arr[moveX][moveY] == 0)
                    continue;

                visit[moveX][moveY] = true;
                arr[moveX][moveY] = groupNumber;
                queue.add(new int[]{moveX, moveY});
            }
        }

    }

    static void insertEdgeNode(int startX, int startY) {
        for (int i = 0; i < 4; i++) {
            int moveX = startX + go[i][0];
            int moveY = startY + go[i][1];

            if (moveX < 0 || moveX >= n || moveY < 0 || moveY >= n || map[moveX][moveY][0] != 0 || arr[moveX][moveY] != 0)
                continue;
            map[moveX][moveY][0] = arr[startX][startY];
            // 겹쳐도 상관 X
            map[moveX][moveY][1] = 1;
            queue.add(new int[]{moveX, moveY});
        }
    }


}
