import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static char[][] originMap;
    static char[][] changedMap;
    static boolean[][] visit;
    static int[][] go = {{-1,0},{1,0},{0,1},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n =Integer.parseInt(br.readLine());
        originMap = new char[n][n];
        changedMap = new char[n][n];
        for(int i = 0;i<n; i++){
            char[] charArray = br.readLine().toCharArray();
            for(int j = 0;j<n;j++){
                originMap[i][j] = charArray[j];
                if(charArray[j] == 'G'){
                    changedMap[i][j] = 'R';
                }
                else changedMap[i][j] = charArray[j];
            }

        }
        visit = new boolean[n][n];
        int originCount = 0;
        for(int i = 0;i<n;i++){
            for(int j=0; j<n; j++){
                if(!visit[i][j]){
                    dfs(i,j,originMap, originMap[i][j]);
                    originCount++;
                }
            }
        }

        visit = new boolean[n][n];
        int changedCount = 0;
        for(int i = 0;i<n;i++){
            for(int j=0; j<n; j++){
                if(!visit[i][j]){
                    dfs(i,j,changedMap, changedMap[i][j]);
                    changedCount++;
                }
            }
        }

        System.out.println(originCount +" "+ changedCount);
    }

    static void dfs(int startX, int startY, char[][] map, char target){
        visit[startX][startY] = true;
        for(int i =0; i<4; i++){
            int moveX = startX + go[i][0];
            int moveY = startY + go[i][1];
            if(moveX<0 || moveY<0 || moveX>=n || moveY>=n || visit[moveX][moveY] || map[moveX][moveY] != target){
                continue;
            }
            visit[moveX][moveY] = true;
            dfs(moveX, moveY, map, target);
        }
    }


}
