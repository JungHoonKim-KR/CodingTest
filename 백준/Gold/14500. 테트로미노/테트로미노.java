import java.io.*;
import java.util.*;
public class Main {
    static int N,M,max;
    static int[][] scores;
    static int[][] go = {{-1,0},{1,0},{0,-1},{0,1}};
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        scores = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                scores[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visit[i][j]) {
                    visit[i][j] = true;
                    dfs(0,i,j,scores[i][j]);
                    visit[i][j] = false;
                }

                max = Math.max(max, T(i,j));
            }
        }
        System.out.println(max);

    }
    static void dfs(int depth, int startX, int startY, int sum){
        if(depth == 3){
            max = Math.max(max, sum);
            return;
        }


        for(int i = 0; i<4; i++){
            int moveX = startX + go[i][0];
            int moveY = startY + go[i][1];

            if(moveX <0 || moveX>=N || moveY <0 || moveY>=M || visit[moveX][moveY]){
                continue;
            }

            visit[moveX][moveY] = true;
            dfs(depth+1, moveX, moveY, sum + scores[moveX][moveY]);
            visit[moveX][moveY] = false;
        }
    }

    static int T(int startX, int startY){
        int result = 0;
        //T
        if(startX <= N-2 && startY <= M-3){
            int sum = 0;
            for(int i =0; i<3; i++){
                sum += scores[startX][startY+i];
            }
            sum += scores[startX+1][startY+1];
            result = Math.max(result, sum);
        }
        // ㅏ
        if(startX <= N-3 && startY <= M-2){
            int sum = 0;
            for(int i  =0; i<3; i++){
                sum += scores[startX+i][startY];
            }
            sum += scores[startX+1][startY+1];
            result = Math.max(result, sum);
        }
        //ㅗ
        if(startX >=1 && startY<=M-3){
            int sum = 0;
            for(int i=0; i<3; i++){
                sum += scores[startX][startY+i];
            }
            sum += scores[startX-1][startY+1];
            result = Math.max(result, sum);
        }
        // ㅓ

        if(startX <= N-3 && startY>=1){
            int sum = 0;
            for(int i=0; i<3; i++){
                sum += scores[startX+i][startY];
            }
            sum += scores[startX+1][startY-1];
            result = Math.max(result, sum);
        }
        return result;
    }
}