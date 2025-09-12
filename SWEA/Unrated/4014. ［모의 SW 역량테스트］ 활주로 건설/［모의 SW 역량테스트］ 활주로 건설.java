import java.io.*;
import java.util.*;

public class Solution {
    static int N, X, count;
    static int[][] originMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 초기화 및 입력
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            count = 0;
            originMap = new int[N][N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    originMap[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i<N; i++){
                // 가로
                int[] path = originMap[i];
                if(canBuild(path)){
                    count++;
                }

                //세로
                int[] verticalPath = new  int[N];
                for(int j = 0; j<N; j++){
                    verticalPath[j] = originMap[j][i];
                }
                if(canBuild(verticalPath)){
                    count++;
                }
            }
            sb.append("#").append(tc).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }

    static boolean canBuild(int[] path){
        /*
        다음 칸을 보고 나보다 절대값 1 차이 나면 오르막길 내리막기 체크
        길이 X 만큼 다음 칸이랑 길이 같으면 경사로 ok
         */
        boolean[] place = new  boolean[N];
        for(int i = 0; i<N-1; i++){
            int cur = path[i];
            int next = path[i+1];
            int diff = cur - next;

            if(diff == 0){
                continue;
            }

            if(Math.abs(diff)>1){
                return false;
            }

            // 현재 > 다음
            if(diff == 1){
                for(int j = 1; j<=X; j++){
                    int nextIdx = i+j;

                    // 안되는 경우
                    if(nextIdx >= N ||path[nextIdx] != next || place[nextIdx]){
                        return false;
                    }
                    place[nextIdx] = true;
                }
            }
            else if(diff == -1){
                for(int j = 0; j<X; j++){
                    int nextIdx = i-j;

                    // 안되는 경우
                    if(nextIdx <0 ||path[nextIdx] != cur || place[nextIdx]){
                        return false;
                    }
                    place[nextIdx] = true;
                }
            }


        }
        return true;
    }



}