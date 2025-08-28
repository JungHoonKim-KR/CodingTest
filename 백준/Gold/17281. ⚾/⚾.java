import java.io.*;
import java.util.*;

public class Main {
    static int N, max;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][9];
        for(int i = 0; i < N; i++){
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        int[] player = new int[9];
        boolean[] select = new boolean[9];
        player[3] = 0;
        select[0] = true;
        dfs(0, player, select);
        System.out.print(max);
    }

    static void dfs(int depth, int[] player, boolean[] select) {
        if (depth == 9) {
            solve(player);
            return;
        }
        if (depth == 3) {
            dfs(depth + 1, player, select);
            return;
        } else {
            for (int i = 0; i < 9; i++) {
                if (!select[i]) {
                    select[i] = true;
                    player[depth] = i;
                    dfs(depth + 1, player, select);
                    select[i] = false;
                }
            }
        }


    }

    static void solve(int[] player) {
        int score = 0;
        int lastPlayer = 0;
        for (int ining = 0; ining < N; ining++) {
            int outCount = 0;
            boolean[] base = new boolean[3];
            while (outCount < 3) {
                int curResult = arr[ining][player[lastPlayer]];
                if (curResult == 0) {
                    outCount++;
                } else {
                    for (int i = 2; i >= 0; i--) {
                        if (base[i]) {
                            if (i + curResult >= 3) {
                                score++;
                            } else {
                                base[i + curResult] = true;
                            }
                            base[i] = false;
                        }
                    }
                    // 진루타수들 미리 계산하고 홈런이면 타자도 계산
                    if(curResult == 4){
                        score++;
                    }
                    else{
                        base[curResult-1] = true;
                    }
                }
                lastPlayer = (lastPlayer+1)%9;

            }
        }

        max = Math.max(max, score);
    }
}