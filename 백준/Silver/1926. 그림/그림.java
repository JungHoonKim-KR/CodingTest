import java.io.*;
import java.util.*;

public class Main {
    static int n,m,count=0,max=0;
    static char[][] map;
    static boolean[][]visit;
    static int[][] go = {{-1, 0}, {1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m=Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visit = new boolean[n][m];
        for(int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = st.nextToken().charAt(0);
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(map[i][j] == '1' && !visit[i][j]){
                    visit[i][j]=true;
                    max = Math.max(max,dfs(i,j));
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(max);
    }

    static int dfs(int startX, int startY){
        int result = 1;
        for(int i = 0; i<4; i++){
            int moveX = startX + go[i][0];
            int moveY = startY + go[i][1];
            if(moveX<0 || moveX>=n || moveY<0 || moveY>=m || visit[moveX][moveY] || map[moveX][moveY] == '0'){
                continue;
            }
            visit[moveX][moveY] = true;
            result += dfs(moveX, moveY);
        }
        return result;
    }


}
