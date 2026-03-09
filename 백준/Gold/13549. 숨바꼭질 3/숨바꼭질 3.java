import java.io.*;
import java.util.*;

/*
    4방 탐색
    지점 값이 -1 or 1이면 진행 X
 */
public class Main {
    static final int MAX = 100_000;
    static int N, M;
    static int[] map = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Arrays.fill(map, Integer.MAX_VALUE);
        map[N] = 0;
        bfs(N);
    }

    static void bfs(int index) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{index, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if(cur[0] == M) {
                System.out.println(cur[1]);
                return;
            }
            if (2*cur[0] <=MAX && map[2*cur[0]] > cur[1]) {
                map[2*cur[0]] = cur[1];
                queue.add(new int[]{2*cur[0], map[2*cur[0]]});
            }
            if (cur[0] -1>=0 && map[cur[0] - 1] > cur[1] + 1) {
                map[cur[0] - 1] = cur[1] + 1;
                queue.add(new int[]{cur[0] - 1, map[cur[0] - 1]});
            }
            if (cur[0] +1<= MAX && map[cur[0] + 1] > cur[1] + 1) {
                map[cur[0] + 1] = cur[1] + 1;
                queue.add(new int[]{cur[0] + 1, map[cur[0] + 1]});
            }

        }
    }


}

