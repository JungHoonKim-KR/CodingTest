import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int x, y, z;

        Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int gox[] = {-1, 0, 1, 0, 0, 0};
        int goY[] = {0, 1, 0, -1, 0, 0};
        int goZ[] = {0, 0, 0, 0, 1, -1};
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int z = Integer.parseInt(st.nextToken());

        int unripeCount = 0, max = 0;
        int map[][][] = new int[z][y][x];
        boolean visit[][][] = new boolean[z][y][x];
        Queue<Point> queue = new LinkedList<>();
        for (int k = 0; k < z; k++) {
            for (int i = 0; i < y; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < x; j++) {
                    int stance = Integer.parseInt(st.nextToken());
                    if (stance == 1) {
                        queue.add(new Point(j, i, k));
                        visit[k][i][j] = true;
                    } else if (stance == 0) {
                        unripeCount++;
                    }
                    map[k][i][j] = stance;
                }
            }
        }
        //1: 출발지, -1: 막힌 길: 0: 아직 안 간 길

        while (unripeCount > 0 && !queue.isEmpty()) {
            Point poll = queue.poll();

            for (int i = 0; i < 6; i++) {
                int moveX = poll.x + gox[i];
                int moveY = poll.y + goY[i];
                int moveZ = poll.z + goZ[i];
                if (moveX < 0 || moveX >= x || moveY < 0 || moveY >= y || moveZ < 0 || moveZ >= z || map[moveZ][moveY][moveX] == -1 || visit[moveZ][moveY][moveX])
                    continue;

                if (--unripeCount == 0) {
                    max = map[poll.z][poll.y][poll.x];
                    break;
                }
                queue.add(new Point(moveX, moveY, moveZ));
                visit[moveZ][moveY][moveX] = true;
                map[moveZ][moveY][moveX] = map[poll.z][poll.y][poll.x] + 1;
            }

        }

        if (unripeCount != 0) {
            System.out.println(-1);
        } else {
            System.out.println(max);
        }


    }
}
