import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char map [][] = new char [n][m];
        int goX[] ={1,0,-1,0};
        int goY[] ={0,1,0,-1};

        boolean visit[][][] = new boolean[2][n][m];
        //꺳으면 1
        int arr[][] = new int[n][m];
        arr[0][0] = 1;

       for(int i =0; i<n; i++){
           String s = br.readLine();
           for(int j =0; j<m; j++){
               map[i][j] = s.charAt(j);
           }
        }
       Queue<int[]>queue = new LinkedList<>();
       visit[0][0][0] = true;
       queue.add(new int[]{0,0,0});

       while(!queue.isEmpty()){
           int[] poll = queue.poll();
           for(int i =0; i<4; i++){
               int moveX = poll[0] + goX[i];
               int moveY = poll[1] + goY[i];

               if(moveX<0 || moveX>n-1 || moveY<0 || moveY>m-1)
                   continue;

               // 다음 칸이 벽일 떄
               if(map[moveX][moveY]=='1'){
                   // 벽을 이때까지 안부숨
                   if(poll[2]==0 && !visit[0][moveX][moveY]){
                       visit[0][moveX][moveY] = true;
                       arr[moveX][moveY] = arr[poll[0]][poll[1]] +1;
                       //이제 부숨
                       queue.add(new int[]{moveX,moveY,1});
                   }
                   //이미 부순 경우는 어차피 없으므로 무시
               }
               else{
                   if(poll[2]==0 && !visit[0][moveX][moveY]){
                       visit[0][moveX][moveY] = true;
                       arr[moveX][moveY] = arr[poll[0]][poll[1]] +1;
                       queue.add(new int[]{moveX, moveY, 0});
                   }
                   else if(poll[2]==1 && !visit[1][moveX][moveY]){
                       visit[1][moveX][moveY] = true;
                       arr[moveX][moveY] = arr[poll[0]][poll[1]] +1;
                       queue.add(new int[]{moveX, moveY, 1});
                   }
               }

               if(moveX == n-1 && moveY == m-1){
                   System.out.println(arr[moveX][moveY]);
                   return;
               }
           }
       }
       if(visit[1][n-1][m-1] || visit[0][n-1][m-1]){
           System.out.println(arr[n-1][m-1]);
       }
       else
            System.out.println(-1);



    }
}
