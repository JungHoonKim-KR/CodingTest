import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Queue<int[]> clouds = new ArrayDeque<>();
    static int[][] go = {{0,0},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1}};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        clouds.add(new int[]{N-1,0});
        clouds.add(new int[]{N-1,1});
        clouds.add(new int[]{N-2,0});
        clouds.add(new int[]{N-2,1});
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            run(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int result = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                result += map[i][j];
            }
        }
        System.out.println(result);

    }
    static void run(int dir, int s){
        boolean[][] rainPoint = new boolean[N][N];

        //1. 구름 이동 & 2. 비내기리

        for(int[] cloud :clouds){
            int moveX = ((cloud[0] + (go[dir][0] * s))%N + N)%N;
            int moveY = ((cloud[1] + (go[dir][1] * s))%N + N)%N;

            map[moveX][moveY]++;
            rainPoint[moveX][moveY] = true;

            cloud[0] = moveX;
            cloud[1] = moveY;

        }

        // 3. 물 복사
        for(int[] cloud :clouds){
            int water = 0;
            for(int i = 2; i<=8; i+=2){
                int nX = (cloud[0] + go[i][0]);
                int nY = (cloud[1] + go[i][1]);

                if(nX <0 || nX>=N || nY <0 || nY>=N || map[nX][nY] == 0){
                    continue;
                }
                water++;
            }
            map[cloud[0]][cloud[1]] += water;
        }

        //4 새 구름 생성
        Queue<int[]>newClouds = new ArrayDeque<>();
        for(int i = 0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(map[i][j] >=2 && !rainPoint[i][j]){
                    newClouds.add(new int[]{i,j});
                    map[i][j] -= 2;
                }
            }
        }
        clouds = newClouds;
    }


}