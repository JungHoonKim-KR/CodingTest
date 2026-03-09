import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/*
    4방 탐색
    지점 값이 -1 or 1이면 진행 X
 */
public class Main {
    static int N, M, K;
    static BufferedWriter bw= new BufferedWriter(new OutputStreamWriter(System.out));
    static char[][][] map;
    static int[][] go = {{-1, 0, 0}, {0, 1, 0}, {1, 0, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int startK = 0, startN = 0, startM = 0;

        while (true) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (K == 0 && N == 0 && M == 0) break;

            map = new char[K][N][M];
            //입력
            for (int k = 0; k < K; k++) {
                for (int i = 0; i < N; i++) {
                    char[] input = br.readLine().toCharArray();
                    for (int j = 0; j < M; j++) {
                        char data = input[j];
                        map[k][i][j] = data;
                        if (data == 'S') {
                            startK = k;
                            startN = i;
                            startM = j;
                        }
                    }
                }
                br.readLine();
            }

            bfs(startK, startN, startM);
        }
        bw.flush();

    }

    static void bfs(int startK, int startN, int startM) throws IOException {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startK, startN, startM, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nk = cur[0] + go[i][0];
                int nn = cur[1] + go[i][1];
                int nm = cur[2] + go[i][2];
                if (nk < 0 || nk >= K || nn < 0 || nn >= N || nm < 0 || nm >= M
                        || map[nk][nn][nm] == '#' || map[nk][nn][nm] == 'S') continue;

                if (map[nk][nn][nm] == 'E') {
                    int result = cur[3] + 1;
                    bw.write("Escaped in " + result + " minute(s).\n");
                    return;
                } else {
                    queue.add(new int[]{nk, nn, nm, cur[3] + 1});
                    map[nk][nn][nm] = '#';
                }


            }
        }
        bw.write("Trapped!\n");
    }

}

