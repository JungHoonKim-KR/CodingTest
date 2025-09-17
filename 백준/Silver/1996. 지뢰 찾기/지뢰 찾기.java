import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int N;
    static char[][] resultMap;
    static int[][]go={{-1,0},{-1,-1},{-1,1},{1,0},{1,1},{1,-1},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        resultMap = new char[N][N];
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                char cell = input[j];
                if(cell == '.'){
                    map[i][j] = 0;
                }
                else{
                    map[i][j] = cell - '0';
                }
            }
        }
        run();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                sb.append(resultMap[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);

    }
    static void run(){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                // 지뢰
                if(map[i][j]> 0){
                    resultMap[i][j] = '*';
                }
                else{
                    int sum = 0;
                    for(int k = 0; k<8; k++){
                        int moveX = i + go[k][0];
                        int moveY = j + go[k][1];

                        if(moveX < 0 || moveX >= N || moveY < 0 || moveY >= N)
                            continue;

                        sum +=  map[moveX][moveY];
                    }

                    if(sum >=10){
                        resultMap[i][j] = 'M';
                    }
                    else{
                        resultMap[i][j] = (char)(sum + '0');
                    }
                }
            }
        }
    }



}