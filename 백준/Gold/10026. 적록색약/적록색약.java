import java.io.*;
import java.util.*;

/*
    4방 탐색
    지점 값이 -1 or 1이면 진행 X
 */
public class Main {
    static int N;
    static char[] charset = {'R', 'G', 'B'};
    static int[][] go = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static char[][] map;
    static ArrayList<Integer> answer = new ArrayList<>();
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // init
        int normalCount = 0, specialCount = 0;
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            char[] ch = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                map[i][j] = ch[j];
            }
        }

        // 적록 X
        visited = new boolean[N][N];
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]) {
                    normal(i, j);
                    normalCount++;
                }
            }
        }

        visited = new boolean[N][N];
        for(int i = 0; i< N; i++){
            for(int j = 0; j < N; j++){
                if(!visited[i][j]){
                    special(i, j);
                    specialCount++;
                }
            }
        }

        System.out.println(normalCount + " " + specialCount);

    }


    static void normal(int x, int y){
        char initC = map[x][y];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + go[i][0];
                int ny = cur[1] + go[i][1];

                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny] || initC != map[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }

    static void special(int x, int y){
        char initC = map[x][y];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur[0] + go[i][0];
                int ny = cur[1] + go[i][1];


                if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                if(visited[nx][ny]) continue;
                if((initC == 'R' || initC == 'G') && map[nx][ny] == 'B') continue;
                if(initC == 'B' && (initC != map[nx][ny])) continue;
                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny});
            }
        }
    }

}

