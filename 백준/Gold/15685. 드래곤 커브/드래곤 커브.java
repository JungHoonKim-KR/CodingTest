import java.io.*;
import java.util.*;

public class Main {
    static int N, count;
    static List<Integer>[] curveList = new ArrayList[11];
    static int[][] go = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};
    static boolean[][] map = new boolean[101][101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dragonCurveInit();

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());

            curve(x,y,dir,age);
        }
        count();
        System.out.println(count);
    }
    static void dragonCurveInit(){
        // 드래곤 커브 미리 정의
        for (int i = 0; i <= 10; i++) {
            curveList[i] = new ArrayList<>();
        }
        curveList[0].add(0);
        for (int i = 1; i <= 10; i++) {
            curveList[i].addAll(curveList[i - 1]);
            for (int j = (int) Math.pow(2, i - 1) - 1; j >= 0; j--) {
                int dir = curveList[i].get(j);
                curveList[i].add((dir + 1) % 4);
            }
        }
    }

    static void curve(int startX, int startY, int initDir, int age){
        map[startY][startX] = true;
        int x = startX;
        int y = startY;
        for(int i = 0; i<curveList[age].size(); i++){
            int dir = (initDir + curveList[age].get(i)) % 4;
            x += go[dir][0];
            y += go[dir][1];

            map[y][x] = true;
        }
    }
    static void count(){
        for(int i = 0; i<100;i++){
            for(int j = 0; j<100;j++){
                if(map[i][j] && map[i+1][j] && map[i][j+1] && map[i+1][j+1]){
                    count ++;
                }
            }
        }
    }

}