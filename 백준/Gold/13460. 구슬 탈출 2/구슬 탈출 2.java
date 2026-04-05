import java.io.*;
import java.util.*;

public class Main {
    static int N, M, result = 11;
    static char map[][];
    static int go[][] = {{1,0}, {0,-1},{-1,0},{0,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //init
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        int rX = 0, rY=0, bX=0, bY=0;

        for(int i = 0; i < N; i++){
            char[] chars = br.readLine().toCharArray();
            for(int j = 0; j < M; j++){
                map[i][j] = chars[j];
                if(chars[j] == 'R'){
                    rX = i;
                    rY = j;
                }
                else if(chars[j] == 'B'){
                    bX = i;
                    bY = j;
                }
            }
        }
        dfs(1, rX, rY, bX, bY);
        System.out.println(result > 10 ? -1 : result);
    }

    static void dfs(int depth, int rx, int ry, int bx, int by){
        if(depth > 10){
            return;
        }
        for(int i = 0; i<4; i++){
            int nRX = rx, nRY = ry;
            int nBX = bx, nBY = by;
            int rCount = 0, bCount = 0;
            while(map[nRX + go[i][0]][nRY + go[i][1]] != '#' && map[nRX][nRY] != 'O'){
                nRX += go[i][0];
                nRY += go[i][1];
                rCount++;

            }

            while(map[nBX + go[i][0]][nBY + go[i][1]] != '#' && map[nBX][nBY] != 'O'){
                nBX += go[i][0];
                nBY += go[i][1];
                bCount++;

            }

            // 위치가 같다면?
            if(nRX == nBX && nRY == nBY){
                if(map[nRX][nBY] != 'O'){
                    if(rCount > bCount){
                        nRX -= go[i][0];
                        nRY -= go[i][1];
                    }
                    else{
                        nBX -= go[i][0];
                        nBY -= go[i][1];
                    }
                }
            }


            // O에 도착
            if(map[nBX][nBY] == 'O')
                continue;

            if(map[nRX][nRY] == 'O'){
                result = Math.min(depth, result);
                continue;
            }

            dfs(depth+1, nRX, nRY, nBX, nBY);
        }
    }
}