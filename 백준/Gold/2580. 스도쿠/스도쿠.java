import java.io.*;
import java.util.*;

public class Main {

    static int arr[][] = new int[9][9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;

        for(int i =0; i<9;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<9; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        br.close();
        bw.close();
    }


    static void dfs(int x, int y){
        if(x ==9){
            // 다음 행으로 이동
            dfs(0,y+1);
            return;
        }
        //탐색 끝
        if(y==9){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<9; j++){
                for(int i =0; i<9; i++){
                    sb.append(arr[j][i]+" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        if(arr[y][x]==0) {
            for (int i = 1; i <= 9; i++) {
                if (check(x, y, i)) {
                    arr[y][x] = i;
                    dfs(x + 1, y);
                }
            }
            // 다른 경우의 수 고려해서 초기화
            arr[y][x] = 0;
            return;
        }
        dfs(x + 1, y);
    }

    static boolean check(int x, int y, int n){
        // 열 체크
        for(int i=0; i<9; i++){
            if(arr[y][i] == n)
                return false;
        }
        // 행 체크
        for(int j =0; j<9; j++){
            if(arr[j][x] ==n)
                return false;
        }

        //3x3 영역 체크
        // 해당 영역의 시작점
        int col = x/3 *3;
        int row = y/3 *3;

        for(int j = row; j<row+3;j++){
            for(int i = col; i<col+3;i++){
                if(arr[j][i] == n)
                    return false;
            }
        }

        return true;


    }


}
