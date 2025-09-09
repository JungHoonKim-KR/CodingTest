import java.util.*;
import java.io.*;


public class Main {
   static int[][] map = new int[9][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int i =0; i<9; i++){
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        dfs(0,0);

    }
    static void dfs(int startX, int startY){
        if(startX == 9){
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i<9; i++){
                for(int j = 0; j<9; j++){
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
            System.out.println(sb.toString());
            System.exit(0);
        }

        if(startY == 9){
            dfs(startX+1, 0);
            return;
        }

        if(map[startX][startY] == 0){
            for(int i = 1; i<=9; i++){
                if(check(startX, startY, i)){
                    map[startX][startY] = i;
                    dfs(startX, startY+1);
                    map[startX][startY] = 0;
                }
            }
        }
        else dfs(startX, startY+1);
    }

    static boolean check(int X, int Y, int value){
        // 가로
        for(int i = 0; i<9; i++){
            if(map[X][i] == value)
                return false;
        }
        // 세로
        for(int i = 0; i<9; i++){
            if(map[i][Y] == value)
                return false;
        }

        // 3X3
        int startX = X/3*3;
        int startY = Y/3*3;

        for(int i = startX; i<startX+3; i++){
            for(int j = startY; j<startY+3; j++){
                if(map[i][j] == value)
                    return false;
            }
        }

        return true;
    }
}