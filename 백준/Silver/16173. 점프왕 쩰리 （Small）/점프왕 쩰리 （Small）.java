import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] go = {{1,0},{0,1}};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0,new boolean[N][N]);
        System.out.println("Hing");
    }
    static void dfs(int startX, int startY, boolean[][] visit){
        if(startX == N-1 && startY == N-1){
            System.out.println("HaruHaru");
            System.exit(0);
        }
        for(int i = 0; i<2; i++){
            int moveX = startX + go[i][0] * map[startX][startY];
            int moveY = startY + go[i][1] * map[startX][startY];

            if(moveX<0 || moveX>=N || moveY<0 || moveY>=N || visit[moveX][moveY]){
                continue;
            }
            visit[moveX][moveY] = true;
            dfs(moveX,moveY, visit);
        }
    }
}