import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
북쪽을 시작으로 반시계 방향으로 탐색
갈 곳이 없으면 후진, 만약 벽이면 후진 못하고 그대로 정지
 */
public class Main {
    static int[][] go = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[][] map;
    static int N, M, X, Y, dir,count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        run();
        System.out.println(count);

    }

    static void run() {
        // 현재 방향 + for i _(4)
        // 1 : 벽, 0 : 청소 필요, -1 : 청소 끝(벽은 아님)
        while (true) {
            if(map[X][Y] == 0){
                map[X][Y] = -1;
                count++;
            }

            boolean isMove = false;
            for (int i = 0; i < 4; i++) {
                int turnDir = (dir + i) % 4;
                int moveX = X + go[turnDir][0];
                int moveY = Y + go[turnDir][1];

                if (moveX < 0 || moveX >= N || moveY < 0 || moveY >= M
                        || map[moveX][moveY] != 0) {
                    continue;
                }
                isMove = true;
                break;
            }

            if (!isMove) {
                int reverseDir = (dir + 2) % 4;
                int moveX = X + go[reverseDir][0];
                int moveY = Y + go[reverseDir][1];

                if (moveX < 0 || moveX >= N || moveY < 0 || moveY >= M
                        || map[moveX][moveY] == 1)
                    return;

                // 후진
                X = moveX;
                Y = moveY;
                //방향은 유지

            }
            else{
                dir = (dir+3) %4;

                int moveX = X + go[dir][0];
                int moveY = Y + go[dir][1];

                if(moveX <0 || moveX >= N || moveY <0 || moveY >= M
                || map[moveX][moveY] !=0)
                    continue;

                X = moveX;
                Y = moveY;
            }

        }
    }


}