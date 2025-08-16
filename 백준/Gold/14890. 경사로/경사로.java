import java.io.*;
import java.util.*;


/*
 1. first, second 구조로 행 및 열 탐색
 2. 한 줄이 모두 first == second 이면 패스, 같은 경우 count를 누적해서 다음 칸이 1 차이인 경우 경사로를 설치할 수 있도록 함
 */

public class Main {
    static int n, l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        int result = 0;
        int[][] map = new int[n][];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // 행
        for (int i = 0; i < n; i++) {
            int first = map[i][0];
            // count >= l 이면 다음 칸이 1 차이나도 상관 X
            int count = 1;
            boolean isOK = true;
            for (int j = 1; j < n; j++) {
                int second = map[i][j];
                if (first == second)
                    count++;
                    // upStair
                else if (second - first == 1 && count >= l) {
                    count = 1;
                } else if (first - second == 1) {
                    if (downStair(j, map[i])) {
                        j += l-1;
                        count = 0;
                    } else {
                        isOK = false;
                        break;
                    }
                } else {
                    isOK = false;
                    break;
                }

                first = second;
            }
            if (isOK)
                result++;
        }
        // 열
        for (int i = 0; i < n; i++) {
            int first = map[0][i];
            // count >= l 이면 다음 칸이 1 차이나도 상관 X
            int count = 1;
            boolean isOK = true;
            for (int j = 1; j < n; j++) {
                int second = map[j][i];
                if (first == second)
                    count++;
                else if (second - first == 1 && count >= l) {
                    count = 1;
                } else if (first - second == 1) {
                    int[] tempArr = new int[n];
                    for (int k = 0; k < n; k++)
                        tempArr[k] = map[k][i];
                    if (downStair(j, tempArr)) {
                        j += l-1;
                        count = 0;
                    } else {
                        isOK = false;
                        break;
                    }
                } else {
                    isOK = false;
                    break;
                }

                first = second;
            }
            if (isOK)
                result++;
        }
        System.out.println(result);

    }

    static boolean downStair(int start, int arr[]) {
        if (start + l > n)
            return false;

        int target = arr[start];
        for (int i = start + 1; i < start + l; i++) {
            if (target != arr[i])
                return false;
        }

        return true;
    }


}
