import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int count,n,m;
    static boolean[] charArr;
    static char[][] map;
    static int[][]go = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());

        charArr = new boolean[26];
        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0,map[0][0] - 'A'});
        dfs(1,0,0);
        System.out.println(count);



    }
    static void dfs(int cnt, int startX, int startY){
        charArr[map[startX][startY] - 'A'] = true;
        for(int i = 0; i<4; i++){
            int moveX = startX + go[i][0];
            int moveY = startY + go[i][1];
            if(moveX<0||moveX>=n||moveY<0||moveY>=m
                    || charArr[map[moveX][moveY]-'A'])
                continue;
            dfs(cnt+1, moveX,moveY);
        }
        charArr[map[startX][startY] - 'A'] = false;
        count = Math.max(count,cnt);
    }

}