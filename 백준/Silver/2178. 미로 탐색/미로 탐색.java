import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class point{
        int x;
        int y;
        public point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int goX[]={-1, 0, 1, 0};
    static int goY[]={0, -1, 0, 1};
    static int arr[][];
    static boolean visit[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        arr= new int[x][y];
        visit= new boolean[x][y];

        for(int i = 0; i<x; i++){
            String s = br.readLine();
            for(int j =0; j<y; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        Queue<point> queue = new LinkedList<>();
        queue.add(new point(0,0));
        visit[0][0] = true;
        while(!queue.isEmpty()){
            point poll = queue.poll();
            for(int i =0; i<4; i++){
                int moveX = poll.x + goX[i];
                int moveY = poll.y + goY[i];
                if(moveX<0 || moveX>x-1 || moveY<0 || moveY>y-1 || arr[moveX][moveY] == 0 || visit[moveX][moveY])
                    continue;

                arr[moveX][moveY] = arr[poll.x][poll.y] + 1;
                queue.add(new point(moveX, moveY));
                visit[moveX][moveY] = true;

            }
        }

        System.out.println(arr[x-1][y-1]);


    }





}
