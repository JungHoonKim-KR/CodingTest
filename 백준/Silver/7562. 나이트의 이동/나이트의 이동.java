import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        int gox[] = {-2, -2, -1, -1, 1, 1, 2, 2};
        int ogY[] = {1, -1, 2, -2, 2, -2, 1, -1};

        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());

            boolean[][] visit = new boolean[n][n];
            int map[][] = new int[n][n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            Point curP = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            st = new StringTokenizer(br.readLine());
            Point targetP = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            Queue<Point> queue = new LinkedList<>();
            queue.add(curP);
            visit[curP.y][curP.x] = true;
            while (!queue.isEmpty()) {
                Point poll = queue.poll();

                if(poll.x == targetP.x && poll.y == targetP.y) {
                    sb.append(map[poll.y][poll.x] + "\n");
                    break;
                }

                for(int i =0; i<8; i++){
                    int moveX = poll.x + gox[i];
                    int moveY = poll.y + ogY[i];

                    if(moveX<0 || moveX>n-1 || moveY<0 || moveY>n-1 || visit[moveY][moveX])
                        continue;

                    queue.add(new Point(moveX, moveY));
                    map[moveY][moveX] = map[poll.y][poll.x] + 1;
                    visit[moveY][moveX] = true;
                }
            }
        }
        System.out.println(sb);
    }
}
