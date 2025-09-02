import java.io.*;
import java.util.*;

public class Main {
    static int N, M, D;
    static int[][] originalMap;
    static int maxKills = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        originalMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                originalMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        combination(0, 0, new int[3]);
        System.out.println(maxKills);
    }

    static void combination(int depth, int start, int[] archers) {
        if (depth == 3) {
            int currentKills = simulate(archers);
            maxKills = Math.max(maxKills, currentKills);
            return;
        }

        for (int i = start; i < M; i++) {
            archers[depth] = i;
            combination(depth + 1, i + 1, archers);
        }
    }

    static int simulate(int[] archers) {
        int kills = 0;
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            map[i] = originalMap[i].clone();
        }
        // 매 턴 마다 궁수 한 칸 내리기
        for (int archerRow = N; archerRow > 0; archerRow--) {
            List<int[]> targets = new ArrayList<>();
            for (int archerCol : archers) {
                int[] target = findTarget(archerRow, archerCol, map);
                if (target != null) {
                    targets.add(target);
                }
            }

            for (int[] target : targets) {
                int r = target[0];
                int c = target[1];
                if (map[r][c] == 1) {
                    map[r][c] = 0;
                    kills++;
                }
            }
        }
        return kills;
    }

    static int[] findTarget(int archerRow, int archerCol, int[][] map) {
        int[] bestTarget = null;
        int minDistance = Integer.MAX_VALUE;

        for (int c = 0; c < M; c++) {
            for (int r = archerRow-1; r >= 0; r--) {
                if (map[r][c] == 1) {
                    int dist = Math.abs(archerRow - r) + Math.abs(archerCol - c);
                    if (dist <= D){
                        if (dist < minDistance) {
                            minDistance = dist;
                            bestTarget = new int[]{r, c};
                        }
                    }

                    break;
                }
            }
        }
        return bestTarget;
    }
}