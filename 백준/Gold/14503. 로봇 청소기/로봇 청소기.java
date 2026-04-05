import java.io.*;
import java.util.*;


public class Main {
    static int N, M;
    static int go[][] = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int map[][];
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());


        // init
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        int initX, initY, initDir;
        st = new StringTokenizer(br.readLine());
        initX = Integer.parseInt(st.nextToken());
        initY = Integer.parseInt(st.nextToken());
        initDir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(initX, initY, initDir);

        System.out.println(result);


    }

    static void solve(int x, int y, int dir) {

        int curX = x, curY = y, curDir = dir;
        outer:
        while (true) {
            // 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다

            if (map[curX][curY] == 0) {
                map[curX][curY] = 2;
                result++;
            }

            // 현재 칸의 주변
            boolean dirty = false;
            for (int i = 0; i < 4; i++) {
                //$4$칸 중 청소되지 않은 빈 칸이 있는 경우,
                //반시계 방향으로
                //$90^\circ$ 회전한다.
                int nX = curX + go[i][0];
                int nY = curY + go[i][1];
                if (nX < 0 || nX >= N || nY < 0 || nY >= M || map[nX][nY] == 1 || map[nX][nY] == 2)
                    continue;

                if (map[nX][nY] == 0) {
                    dirty = true;
                    break;
                }
                //바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한 칸 전진한다.
            }

            if (dirty) {
                for (int i = 0; i < 4; i++) {
                    curDir = (curDir + 3) % 4;
                    int nX = curX + go[curDir][0];
                    int nY = curY + go[curDir][1];
                    if (nX < 0 || nX >= N || nY < 0 || nY >= M || map[nX][nY] == 1 || map[nX][nY] == 2)
                        continue;

                    if (map[nX][nY] == 0) {
                        curX = nX;
                        curY = nY;
                        break;
                    }
                }
            }

            else {
                //바라보는 방향을 유지한 채로 한 칸 후진할 수 있다면 한 칸 후진하고 1번으로 돌아간다.
                int nX = curX - go[curDir][0];
                int nY = curY - go[curDir][1];
                //바라보는 방향의 뒤쪽 칸이 벽이라 후진할 수 없다면 작동을 멈춘다.
                if (nX < 0 || nX >= N || nY < 0 || nY >= M || map[nX][nY] == 1) {
                    break outer;
                }

                curX = nX;
                curY = nY;

            }


        }


    }


}
