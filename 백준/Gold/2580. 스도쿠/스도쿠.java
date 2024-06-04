import java.io.*;
import java.lang.String;
import java.util.*;



public class Main {
    static int arr[][];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr=new int[9][9];
        //문제 받기
        for (int i = 0; i < 9; i++) {
           StringTokenizer st=new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < 9; j++) {

                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        sudoku(0,0);
    }

    public static void sudoku(int row,int col) {
        if(col==9) {
            sudoku(row + 1, 0);
            return;
        }
        if (row == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j] + " ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

            if (arr[row][col] == 0) {
                for (int k = 1; k <= 9; k++) {
                    if (check(row, col, k)) {
                        arr[row][col]=k;
                        sudoku(row,col+1);

                    }

                }
                arr[row][col]=0;
                return;
            }
            sudoku(row,col+1);

        }



    public static boolean check(int y, int x, int value) {
        for (int i = 0; i < 9; i++) {

                if (arr[y][i] == value)
                    return false;

        }
        for (int j = 0; j < 9; j++) {

                if (arr[j][x] == value)
                    return false;

        }
        int X = x / 3 * 3;
        int Y = y / 3 * 3;
        for (int row = Y; row < Y + 3; row++) {
            for (int col = X; col < X + 3; col++) {

                    if (arr[row][col] == value)
                        return false;

            }
        }
        return true;

    }
}






























