import java.util.*;
import java.io.*;

public class Main {
    static int N, M,max, banCount;
    static int[][] map;
    static int[][] selectedWall;
    static int[][] copyMap;
    static List<int[]>birusList;
    static int[][] go = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        selectedWall = new int[3][2];
        copyMap = new int[N][M];
        birusList = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;

                if(input == 1){
                    banCount++;
                }
                if(input == 2){
                    birusList.add(new int[] {i,j});
                }
            }
        }
        banCount += birusList.size() + 3;
        subset(0,0);
        System.out.println(max);
    }

    static void subset(int depth, int start) {
        if (depth == 3) {
            // 실행
            for(int i = 0; i<N; i++){
                System.arraycopy(map[i], 0, copyMap[i], 0, M);
            }
            for(int i =0; i<3; i++){
                copyMap[selectedWall[i][0]][selectedWall[i][1]] = 1;
            }
            max = Math.max(max, run(copyMap));
            return;
        }
        for (int i = start; i < N * M; i++) {
            int r =  i / M;
            int c = i % M;
            if(map[r][c] == 0){
                selectedWall[depth][0] = r;
                selectedWall[depth][1] = c;
                subset(depth+1, i+1);
            }

        }

    }

    static int run(int[][] copyMap){
        int count = 0;
        Queue<int[]>q = new ArrayDeque<>();
        for(int[] b :  birusList){
            q.add(b);
        }

        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i = 0; i<4; i++){
                int moveX = cur[0] + go[i][0];
                int moveY = cur[1] + go[i][1];

                if(moveX<0 || moveX>=N || moveY<0 || moveY>=M)
                    continue;
                if(copyMap[moveX][moveY] == 0){
                    copyMap[moveX][moveY] = Integer.MAX_VALUE;
                    q.add(new int[] {moveX,moveY});
                    count++;
                }
            }

        }
        return N*M - banCount - count;
    }

}