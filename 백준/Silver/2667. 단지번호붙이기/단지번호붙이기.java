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
        arr = new int[n][n];
        visit = new boolean[n][n];
        ArrayList<Integer> town = new ArrayList<>();

        for(int i =0; i<n; i++){
            String s = br.readLine();
            for(int j=0; j<n; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }
        for(int i =0; i<n; i++){
            for(int j =0; j<n; j++){
                if(arr[i][j] == 1 && !visit[i][j]){
                    town.add(dfs(i,j));
                }
            }
        }
        town.sort(Comparator.naturalOrder());
        sb.append(town.size()+"\n");
        for(int t : town){
            sb.append(t+"\n");
        }
        System.out.println(sb);

    }

    static int dfs(int x, int y){
        int result=0;
        if(!visit[x][y]){
            visit[x][y] = true;
            result = 1;
            for(int i =0 ; i<4; i++){
                int moveX = x + goX[i];
                int moveY = y+goY[i];
                if(moveX <0 || moveY <0 || moveX>arr.length-1 || moveY>arr[0].length-1 || arr[moveX][moveY] == 0)
                    continue;

                result += dfs(moveX, moveY);

            }
        }
        return result;
    }



}
