
import java.io.*;
import java.util.*;


/*
해당 좌표가 큰 사각형 기준 몇 사분면에 속하는지 확인
한 사분면의 길이 : 2^N, 즉
 */
public class Main {
    static int L, N, M, startL, startX, startY, endL, endX, endY;
    static char[][][] map;
    static int[][][] myMap;
    static int[][] go = {{-1, 0, 0}, {1, 0, 0}, {0, -1, 0}, {0, 1, 0}, {0, 0, -1}, {0, 0, 1}};
    static Queue<int[]> fireQueue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            L = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (L == 0 && N == 0 && M == 0) {
                return;
            }
            map = new char[L][N][M];
            myMap = new int[L][N][M];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < N; j++) {
                    Arrays.fill(myMap[i][j], Integer.MAX_VALUE);
                }
            }
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < N; j++) {
                    char[] inputArr = br.readLine().toCharArray();
                    for (int k = 0; k < M; k++) {
                        char c = inputArr[k];
                        map[i][j][k] = c;
                        if (c == 'S') {
                            startL = i;
                            startX = j;
                            startY = k;
                        }
                        if (c == 'E') {
                            endL = i;
                            endX = j;
                            endY = k;
                        }

                    }
                }
                br.readLine();

            }
            bfs();

            if (myMap[endL][endX][endY] == Integer.MAX_VALUE) {
                System.out.println("Trapped!");
            } else System.out.println("Escaped in " + myMap[endL][endX][endY] + " minute(s).");

        }


    }

    static void bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startL, startX, startY});
        myMap[startL][startX][startY] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 6; i++) {
                int moveL = cur[0] + go[i][0];
                int moveX = cur[1] + go[i][1];
                int moveY = cur[2] + go[i][2];

                if (moveL < 0 || moveL >= L || moveX < 0 || moveX >= N || moveY < 0 || moveY >= M
                        || map[moveL][moveX][moveY] == '#')
                    continue;

                if (myMap[moveL][moveX][moveY] > myMap[cur[0]][cur[1]][cur[2]] + 1) {
                    myMap[moveL][moveX][moveY] = myMap[cur[0]][cur[1]][cur[2]] + 1;
                    queue.add(new int[]{moveL, moveX, moveY});
                }
            }
        }


    }


}