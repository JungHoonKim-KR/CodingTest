import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int gox[] = {-1, 0 ,1, 0};
        int goY[] = {0, 1 ,0 ,-1};

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int unripeCount=0, max=0;
        int map[][] = new int[y][x];
        boolean visit [][] = new boolean[y][x];
        Queue<Point> queue = new LinkedList<>();
        for(int i =0; i<y; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<x; j++){
                int stance = Integer.parseInt(st.nextToken());
                if(stance == 1){
                    queue.add(new Point(j,i));
                    visit[i][j] = true;
                }
                else if(stance == 0){
                    unripeCount++;
                }
                map[i][j] = stance;
            }
        }

        //1: 출발지, -1: 막힌 길: 0: 아직 안 간 길

        while(unripeCount>0 && !queue.isEmpty()){
            Point poll = queue.poll();

            for(int i =0; i<4; i++){
                int moveX = poll.x + gox[i];
                int moveY = poll.y + goY[i];

                if(moveX<0 || moveX>=x || moveY<0 || moveY>=y || map[moveY][moveX] == -1 || visit[moveY][moveX])
                    continue;

                if(--unripeCount == 0){
                    max = map[poll.y][poll.x];
                    break;
                }
                queue.add(new Point(moveX, moveY));
                visit[moveY][moveX] = true;
                map[moveY][moveX] = map[poll.y][poll.x] + 1;
            }

        }

        if(unripeCount !=0){
            System.out.println(-1);
        }
        else{
            System.out.println(max);
        }


    }
}
