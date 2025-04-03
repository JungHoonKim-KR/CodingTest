import java.util.*;
import java.io.*;

public class Main {
    static int goX[] = {-1, 0, 1, 0};
    static int goY[] = {0, -1, 0, 1};
    static char arr[][];
    static boolean visit[][];
    static StringBuilder sb = new StringBuilder();
    static List<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int node = Integer.parseInt(st.nextToken());

        arr = new char[node][node];
        visit = new boolean[node][node];
        for (int i = 0; i < node; i++) {
            arr[i] = br.readLine().toCharArray();
        }
        int count = 0;
        for (int i = 0; i < node; i++) {
            for (int j = 0; j < node; j++) {
                if (arr[i][j] == '1' && !visit[i][j]) {
                    result.add(dfs(i,j));
                    count++;
                }
            }
        }
        result.sort(Comparator.naturalOrder());
        System.out.println(count);
        for(int r : result){
            sb.append(r).append("\n");
        }
        System.out.println(sb);
    }

    static int dfs(int x, int y) {
        visit[x][y] = true;
        int result = 1;
        for (int i = 0; i < 4; i++) {
            int moveX = goX[i] + x;
            int moveY = goY[i] + y;

            if (moveX < 0 || moveX >= arr.length || moveY < 0 || moveY >= arr[0].length || visit[moveX][moveY] || arr[moveX][moveY] == '0') {
                continue;
            }

            result += dfs(moveX, moveY);
        }
        return result;
    }

}