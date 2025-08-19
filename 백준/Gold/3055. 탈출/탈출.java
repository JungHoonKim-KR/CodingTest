import java.io.*;
import java.util.*;

/*
고슴도치 : S, 물 : *, 돌 : X, 도착지 : D
사람, 물은 4방으로 퍼진다
물과 고슴도치는 돌 통과 못함
고슴도치는 물에 접근 x
물은 D 접근 X
 */
public class Main {
    static int n,m, X,Y;
    static char[][] map;
    static long[][] waterMap;
    static long[][] meMap;
    static int[][] go = {{-1,0},{1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        waterMap = new long[n][m];
        meMap = new long[n][m];
        for(int i = 0; i<n; i++){
            char[] charArray = br.readLine().toCharArray();
            Arrays.fill(waterMap[i], Integer.MAX_VALUE);
            Arrays.fill(meMap[i], Integer.MAX_VALUE);
            for(int j = 0; j<m; j++){
                map[i][j] = charArray[j];
                if(map[i][j] == 'S'){
                    X = i;
                    Y = j;
                    meMap[i][j] = 0;
                }
            }

        }
        waterFunc();
        meFunc();
        System.out.println("KAKTUS");


    }

    static void waterFunc(){
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(map[i][j] == '*'){
                    q.offer(new int[]{i, j});
                    waterMap[i][j] = 0;
                }
            }
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int i = 0; i<4; i++){
                int moveX = cur[0] + go[i][0];
                int moveY = cur[1] + go[i][1];

                if(moveX<0 || moveX>=n || moveY<0 || moveY>=m
                || map[moveX][moveY] == 'D' || map[moveX][moveY] == 'X')
                    continue;

                if(waterMap[cur[0]][cur[1]] +1 < waterMap[moveX][moveY]){
                    waterMap[moveX][moveY] = waterMap[cur[0]][cur[1]] + 1;
                    q.add(new int[]{moveX, moveY});
                }
            }
        }
    }

    static void meFunc(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{X,Y});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(map[cur[0]][cur[1]] == 'D'){
                System.out.println(meMap[cur[0]][cur[1]]);
                System.exit(0);
            }
            for(int i = 0; i<4; i++){
                int moveX = cur[0] + go[i][0];
                int moveY = cur[1] + go[i][1];


                if(moveX<0 || moveX>=n || moveY<0 || moveY>=m
                || map[moveX][moveY]=='X')
                    continue;
                long next = meMap[cur[0]][cur[1]] + 1;
                if(next < meMap[moveX][moveY] && next <waterMap[moveX][moveY] ){
                    meMap[moveX][moveY] = next;
                    q.add(new int[]{moveX, moveY});
                }
            }

        }
    }

}