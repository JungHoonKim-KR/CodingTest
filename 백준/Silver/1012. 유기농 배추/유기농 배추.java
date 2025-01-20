import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int goX[]={-1, 0, 1, 0};
    static int goY[]={0, -1, 0, 1};
    static int arr[][];
    static boolean visit[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while(n -->0){
            StringTokenizer st =new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int count=0;

            arr = new int[y][x];
            visit = new boolean[y][x];

            for(int i = 0; i<k; i++){
                st = new StringTokenizer(br.readLine());
                int posX = Integer.parseInt(st.nextToken());
                int posY = Integer.parseInt(st.nextToken());
                arr[posY][posX] = 1;
            }


            for(int i =0; i<y; i++){
                for(int j = 0; j<x; j++){
                    if(arr[i][j] ==1 && !visit[i][j]){
                        dfs(i,j);
                        count++;
                    }
                }
            }

            sb.append(count+"\n");
        }

        System.out.println(sb);


    }

    static void dfs(int x, int y){
        if(!visit[x][y]){
            visit[x][y] = true;
            for(int i =0; i<4; i++){
                int moveX = x + goX[i];
                int moveY = y + goY[i];

                if(moveX<0|| moveY<0||moveX>arr.length-1||moveY>arr[0].length-1 || visit[moveX][moveY] || arr[moveX][moveY] == 0)
                    continue;
                dfs(moveX, moveY);
            }
        }
    }



}
