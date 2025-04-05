import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int goX[] = new int[]{-1, 0, 1, 0};
        int goY[] = new int[]{0, -1, 0, 1};
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean visit[][][] = new boolean[n][m][2];
        char arr[][] = new char[n][m];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (!visit[cur[0]][cur[1]][cur[3]]) {
                if (cur[0] == n - 1 && cur[1] == m - 1) {
                    System.out.println(cur[2]);
                    return;
                }
                visit[cur[0]][cur[1]][cur[3]] = true;
                if (arr[cur[0]][cur[1]] == '1') {
                    cur[3] = 1;
                }

                for (int i = 0; i < 4; i++) {
                    int moveX = goX[i] + cur[0];
                    int moveY = goY[i] + cur[1];

                    if (moveX < 0 || moveX >= n || moveY < 0 || moveY >= m || visit[moveX][moveY][cur[3]] || (cur[3] == 1 && arr[moveX][moveY] == '1')) {
                        continue;
                    }

                    queue.add(new int[]{moveX, moveY, cur[2] + 1, cur[3]});
                }
            }
        }

        System.out.println(-1);
    }
}