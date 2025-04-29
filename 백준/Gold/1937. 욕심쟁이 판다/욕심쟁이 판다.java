import java.util.*;
import java.io.*;

public class Main {
    static  int arr[][];
    static int dp[][];
    static int goX[] = {-1, 0, 1, 0};
    static int goY[] = {0, 1, 0, -1};
    static int n;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        for(int i =0; i<n; i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

       dp = new int[n][n];

        for(int i =0; i<n; i++){
            for(int j =0; j<n; j++){
               max = Math.max(max,dfs(i,j));
            }
        }
        System.out.println(max);
    }
    static int dfs(int x, int y){
        if(dp[x][y] != 0) return dp[x][y];
        dp[x][y] =1;
        for(int k=0; k<4; k++){
            int moveX = x + goX[k];
            int moveY = y + goY[k];

            if(moveX < 0 || moveX >= n || moveY < 0 || moveY >= n)
                continue;

            //이미 탐색 했다는 것
            if(arr[moveX][moveY] > arr[x][y]){
                dp[x][y] = Math.max(dp[x][y], dfs(moveX, moveY) + 1);
            }

        }
        return dp[x][y];
    }


}