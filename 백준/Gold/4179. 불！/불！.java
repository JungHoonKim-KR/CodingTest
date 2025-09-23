
import java.io.*;
import java.util.*;


/*
해당 좌표가 큰 사각형 기준 몇 사분면에 속하는지 확인
한 사분면의 길이 : 2^N, 즉
 */
public class Main {
    static int N,M, jX,jY;
    static int[][] jihoonMap;
    static int[][] fireMap;
    static char[][] map;
    static int[][] go = {{-1,0},{1,0},{0,-1},{0,1}};
    static Queue<int[]>fireQueue = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        jihoonMap = new int[N][M];
        fireMap = new int[N][M];

        for(int i=0;i<N;i++){
            Arrays.fill(jihoonMap[i],Integer.MAX_VALUE);
            Arrays.fill(fireMap[i],Integer.MAX_VALUE);
            char input[] = br.readLine().toCharArray();
            for(int j=0;j<M;j++){
                char c = input[j];
                map[i][j] = c;

                if(c == 'J'){
                    jX=i;
                    jY=j;
                    if(i == 0 || i==N-1 || j==0 || j==M-1){
                        System.out.println(1);
                        return;
                    }
                }
                if(c == 'F'){
                    fireQueue.add(new int[] {i,j});
                    fireMap[i][j] = 0;
                }
            }
        }
        fireBfs();
        JBFS();
        System.out.println("IMPOSSIBLE");
    }

    static void fireBfs(){

        while(!fireQueue.isEmpty()){
            int[] cur = fireQueue.poll();

            for(int i = 0; i<4; i++){
                int moveX = cur[0] + go[i][0];
                int moveY = cur[1] + go[i][1];

                if(moveX<0 || moveX>=N || moveY<0 || moveY>=M
                    || map[moveX][moveY] =='#')
                    continue;

                if(fireMap[moveX][moveY] > fireMap[cur[0]][cur[1]] + 1){
                    fireMap[moveX][moveY] = fireMap[cur[0]][cur[1]] +1;
                    fireQueue.add(new int[]{moveX,moveY});
                }
            }
        }
    }

    static void JBFS(){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{jX,jY});
        jihoonMap[jX][jY] = 0;
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i = 0; i<4; i++){
                int moveX = cur[0] + go[i][0];
                int moveY = cur[1] + go[i][1];
                if(moveX<0 || moveX>=N || moveY<0 || moveY>=M
                || map[moveX][moveY] =='#')
                    continue;
                int next = jihoonMap[cur[0]][cur[1]] + 1;


                if(fireMap[moveX][moveY] > next && jihoonMap[moveX][moveY] > next){
                    jihoonMap[moveX][moveY] = next;

                    if(moveX == 0 || moveX == N-1 || moveY == 0 || moveY == M-1){
                        System.out.println(next+1);
                        System.exit(0);
                    }
                    queue.add(new int[]{moveX,moveY});
                }

            }
        }

    }



}