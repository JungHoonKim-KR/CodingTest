import java.io.*;
import java.util.*;

/*
 1. 각 좌표를 이동할 때 마다 필요한 비용을 기록하기 위한 map 생성
 2. queue에서는 이동할 좌표와 해당 좌표로 이동할 때 발생하는 값을 저장한 int[]값을 저장
 */
public class Main {
    static int n, l, r, result;
    static boolean isFind = false;
    static int map[][];
    static int go[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        while (true) {
            isFind = false;
            visit = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j] && canMove(i,j)) {
                        find(i, j);
                    }
                }
            }
            if (isFind)
                result++;
            else break;
        }
        System.out.println(result);
    }

    static boolean canMove(int startX, int startY) {
        for (int i = 0; i < 4; i++) {
            int moveX = startX + go[i][0];
            int moveY = startY + go[i][1];
            if (moveX < 0 || moveX >= n || moveY < 0 || moveY >= n || visit[moveX][moveY])
                continue;

            int gap = Math.abs(map[startX][startY] - map[moveX][moveY]);
            if (gap >= l && gap <= r) {
                return true;
            }
        }
        return false;

    }

    static void find(int startX, int startY) {
        Queue<int[]> q = new ArrayDeque<>();
        Queue<int[]> mainQueue = new ArrayDeque<>();
        visit[startX][startY] = true;
        q.add(new int[]{startX, startY});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int moveX = cur[0] + go[i][0];
                int moveY = cur[1] + go[i][1];
                if (moveX < 0 || moveX >= n || moveY < 0 || moveY >= n || visit[moveX][moveY])
                    continue;

                int gap = Math.abs(map[cur[0]][cur[1]] - map[moveX][moveY]);
                if (gap >= l && gap <= r) {
                    visit[moveX][moveY] = true;
                    q.add(new int[]{moveX, moveY});
                    mainQueue.add(new int[]{moveX, moveY});
                }

            }
        }

        if (!mainQueue.isEmpty()) {
            mainQueue.add(new int[]{startX, startY});
            move(mainQueue);
            isFind = true;
        }

    }

    static void move(Queue<int[]> mainQueue) {
        int sum = 0;
        for (int[] cur : mainQueue) {
            sum += map[cur[0]][cur[1]];
        }
        sum /= mainQueue.size();

        while (!mainQueue.isEmpty()) {
            int[] cur = mainQueue.poll();
            map[cur[0]][cur[1]] = sum;
        }
    }

}
