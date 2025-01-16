import java.awt.image.ImageProducer;
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int goX[] = {-1, 0, 1, 0};
    static int goY[] = {0, -1, 0, 1};
    static int n;
    static int m;
    static int map[][];
    static int dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        // 4방향으로 이동
        System.out.println(dfs(0,0));

    }

    static int dfs(int startX, int startY) {
        // 4 방향의 합으로 현재 경우의 수가 결정, 단 방문하지 않은 곳은 예외.
        // 4방향은 (x+1, y), (x,y+1), (x, y-1), (x-1, y)
        if (startX >= n - 1 && startY >= m - 1) {
            return 1;
        }
        // 방문한 적 없으면 계산 방문한 적 있으면 계산할 필요 없음
        if(dp[startX][startY] ==-1){
            dp[startX][startY] = 0;
            for (int i = 0; i < 4; i++) {
                int moveX = startX + goX[i];
                int moveY = startY + goY[i];

                if (moveX < 0 || moveY < 0 || moveX > n - 1 || moveY > m - 1)
                    continue;
                if (map[startX][startY] > map[moveX][moveY]) {
                    dp[startX][startY] += dfs(moveX, moveY);
                }
            }
        }


        return dp[startX][startY];
    }


}