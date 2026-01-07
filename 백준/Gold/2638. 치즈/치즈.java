import java.io.*;
import java.util.*;


public class Main {
    static int go[][] = {{-1,0},{1,0},{0,-1},{0,1}};
    static int map[][];
    static boolean airMap[][];
    static int X,Y, day;
    static Queue<int[]> q = new LinkedList<int[]>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());

        map = new int[X][Y];
        airMap = new boolean[X][Y];

        for(int i = 0; i < X; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < Y; j++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;

                if(input == 1){
                    q.add(new int[]{i,j});
                }
            }
        }

        while (!q.isEmpty()) {
            airRun();
            mainRun();
        }

        System.out.println(day);

    }

    static void airRun(){

        Queue<int[]> airQueue = new LinkedList<>();
        airQueue.add(new int[]{0,0});
        airMap = new boolean[X][Y];
        airMap[0][0] = true;

        while(!airQueue.isEmpty()){
            int cur[] = airQueue.poll();

            for(int i = 0; i<4; i++){
                int moveX = cur[0] + go[i][0];
                int moveY = cur[1] + go[i][1];

                if(moveX<0 || moveX>=X || moveY<0 || moveY>=Y
                    || airMap[moveX][moveY] || map[moveX][moveY] == 1){
                    continue;
                }

                airMap[moveX][moveY] = true;
                airQueue.add(new int[]{moveX,moveY});
            }
        }
    }

    static void mainRun(){
        int qSize = q.size();
        List<int[]> meltList = new ArrayList<>();
        for(int i = 0; i < qSize; i++){
            int cur[] = q.poll();
            int airCount = 0;
            for(int j = 0; j<4; j++) {
                int moveX = cur[0] + go[j][0];
                int moveY = cur[1] + go[j][1];

                if (moveX < 0 || moveX >= X || moveY < 0 || moveY >= Y
                        || !airMap[moveX][moveY]) {
                    continue;
                }
                airCount ++;

            }
            if (airCount >= 2) {
                meltList.add(cur);
            } else{
                q.add(cur);
            }
        }
        for(int[] pos : meltList){
            map[pos[0]][pos[1]] = 0;
        }
        if(meltList.size()>0) day++;

    }

}
