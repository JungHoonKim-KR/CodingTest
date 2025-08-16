import java.io.*;
import java.util.*;


public class Main {
    static int n, m, count;
    static char[][] map;
    static boolean[][] visit;
    static int[][] go = {{-1, 0}, {-1,1}, {-1, -1}, {1, 0},{1,-1},{1,1},{0,-1},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if(n == 0 && m ==0)
                break;

            count=0;
            map = new char[m][n];
            visit = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = st.nextToken().charAt(0);
                }
            }

            for(int i = 0; i<m; i++){
                for(int j=0; j<n; j++){
                   if(!visit[i][j] && map[i][j] == '1'){
                       dfs(i, j);
                       count++;
                   }
                }
            }
            sb.append(count+"\n");

        }
        System.out.println(sb);
    }
    static void dfs(int startX, int startY){
        visit[startX][startY] = true;
        for(int i =0; i<8; i++){
            int moveX = go[i][0] + startX;
            int moveY = go[i][1] + startY;

            if(moveX<0 || moveX>=m || moveY<0 || moveY>=n || visit[moveX][moveY] || map[moveX][moveY] == '0'){
                continue;
            }

            visit[moveX][moveY] = true;
            dfs(moveX, moveY);
        }
    }


}
