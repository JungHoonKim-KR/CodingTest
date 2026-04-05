import java.io.*;
import java.util.*;

public class Main {
    static int N, result;
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //init
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        backTracking(0);
        System.out.println(result);
    }

    static void backTracking(int depth) {
        if (depth == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    result = Math.max(result, map[i][j]);
                }
            }
            return;
        }

        int backup[][] = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                backup[i][j] = map[i][j];
            }
        }

        left();
        backTracking(depth + 1);
        restore(backup);
        right();
        backTracking(depth + 1);
        restore(backup);
        up();
        backTracking(depth + 1);
        restore(backup);
        down();
        backTracking(depth + 1);
        restore(backup);

    }

    static void restore(int[][] backup) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = backup[i][j];
            }
        }
    }

    static void left() {
        for (int i = 0; i < N; i++) {
            int temp[] = new int[N];
            int curIndex = 0;
            int value = 0;
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 0) {
                    if (value == map[i][j]) {
                        temp[curIndex++] = value * 2;
                        value = 0;
                    }
                    else{
                        if(value != 0){
                            temp[curIndex++] = value;
                        }
                        value = map[i][j];
                    }
                }
            }
            if(value != 0){
                temp[curIndex] = value;
            }

            for(int j = 0; j<N; j++){
                map[i][j] = temp[j];
            }
        }

    }

    static void up() {
        for(int i = 0; i<N; i++){
            int temp[] = new int[N];
            int curIndex = 0;
            int value = 0;
            for(int j =0; j<N; j ++){
                if(map[j][i] !=0){
                    if(value == map[j][i]){
                        temp[curIndex++] = value*2;
                        value = 0;
                    }
                    else{
                        if(value != 0){
                            temp[curIndex++] = value;
                        }
                        value = map[j][i];
                    }
                }

            }
            if(value != 0){
                temp[curIndex] = value;
            }
            for(int j = 0; j<N; j++){
                map[j][i] = temp[j];
            }
        }


    }

    static void right() {
        for (int i = 0; i < N; i++) {
            int temp[] = new int[N];
            int curIndex = N - 1; // 오른쪽으로 미니까 배열의 오른쪽 끝부터 채움
            int value = 0;
            // 오른쪽에서 왼쪽으로 읽어옴
            for (int j = N - 1; j >= 0; j--) {
                if (map[i][j] != 0) {
                    if (value == map[i][j]) {
                        temp[curIndex--] = value * 2; // 채우고 인덱스를 왼쪽으로 이동
                        value = 0;
                    } else {
                        if (value != 0) {
                            temp[curIndex--] = value;
                        }
                        value = map[i][j];
                    }
                }
            }
            if (value != 0) {
                temp[curIndex] = value;
            }

            for (int j = 0; j < N; j++) {
                map[i][j] = temp[j];
            }
        }
    }

    static void down() {
        for (int i = 0; i < N; i++) { // i를 열(Column)로 사용
            int temp[] = new int[N];
            int curIndex = N - 1; // 아래로 미니까 배열의 아래쪽 끝부터 채움
            int value = 0;
            // 아래에서 위로 읽어옴
            for (int j = N - 1; j >= 0; j--) { // j를 행(Row)으로 사용
                if (map[j][i] != 0) {
                    if (value == map[j][i]) {
                        temp[curIndex--] = value * 2;
                        value = 0;
                    } else {
                        if (value != 0) {
                            temp[curIndex--] = value;
                        }
                        value = map[j][i];
                    }
                }
            }
            if (value != 0) {
                temp[curIndex] = value;
            }

            for (int j = 0; j < N; j++) {
                map[j][i] = temp[j];
            }
        }
    }

}