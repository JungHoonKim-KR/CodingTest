import java.util.*;
import java.io.*;

public class Main {
    static int goX[] = {-1, 1, 0, 0, 0, 0};
    static int goY[] = {0, 0, -1, 1, 0, 0};
    static int goH[] = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int arr[][][] = new int[x][y][h];
        int unripedCount = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int k = 0; k < h; k++) {
            for (int i = 0; i < x; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < y; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr[i][j][k] = num;
                    if (num == 0)
                        unripedCount ++;
                    else if (num == 1) {
                        queue.add(new int[]{i, j, k});
                    }
                }
            }
        }
        int max = 1;
        while (unripedCount > 0 && !queue.isEmpty()) {
            int cur[] = queue.poll();
            for (int i = 0; i < 6; i++) {
                int moveX = goX[i] + cur[0];
                int moveY = goY[i] + cur[1];
                int moveH = goH[i] + cur[2];
                if (moveX < 0 || moveX >= x || moveY < 0 || moveY >= y || moveH < 0 || moveH >= h || arr[moveX][moveY][moveH] == -1 || arr[moveX][moveY][moveH] >= 1) {
                    continue;
                }
                unripedCount--;
                arr[moveX][moveY][moveH] = arr[cur[0]][cur[1]][cur[2]] + 1;
                max = Math.max(arr[moveX][moveY][moveH], max);
                queue.add(new int[]{moveX, moveY, moveH});
            }

        }
        if (unripedCount != 0) {
            System.out.println(-1);
        } else
            System.out.println(max - 1);

    }


}