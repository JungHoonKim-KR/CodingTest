import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int goX[] = {-1, 0, 1, 0};
    static int goY[] = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int arr[][] = new int[x][y];
        int map[][] = new int[x][y];
//        boolean visit[][] = new boolean[x][y];
        int unripedCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < y; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if (num == 0)
                    unripedCount++;
                else if (num == 1)
                    queue.add(new int[]{i, j});
            }
        }

        int max = 1;
        while (unripedCount > 0 && !queue.isEmpty()) {
            int cur[] = queue.poll();
            for (int i = 0; i < 4; i++) {
                int moveX = goX[i] + cur[0];
                int moveY = goY[i] + cur[1];

                if (moveX < 0 || moveX >= x || moveY < 0 || moveY >= y || arr[moveX][moveY] == -1 || arr[moveX][moveY] >= 1) {
                    continue;
                }
                unripedCount--;
                arr[moveX][moveY] = arr[cur[0]][cur[1]] + 1;
                max = Math.max(arr[moveX][moveY], max);
                queue.add(new int[]{moveX, moveY});
            }

        }
        if (unripedCount != 0) {
            System.out.println(-1);
        } else
            System.out.println(max - 1);

    }


}