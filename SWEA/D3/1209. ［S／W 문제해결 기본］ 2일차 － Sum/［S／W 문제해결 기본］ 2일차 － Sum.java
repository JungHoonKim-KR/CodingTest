import java.util.*;
import java.io.*;

 class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            result.append("#"+tc+" ");

            int arr[][] = new int[100][100];

            for (int i = 0; i < 100; i++) {
                arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            int max = 0, maxCross1=0, maxCross2=0;
            for (int i = 0; i < 100; i++) {

                int maxRow = 0;
                int maxCol = 0;
                for(int j = 0; j < 100; j++){
                    maxRow += arr[j][i];
                    maxCol += arr[i][j];
                }
                max = Math.max(max, Math.max(maxRow, maxCol));

                maxCross1 += arr[i][i];
                maxCross2 += arr[i][99-i];
            }

            max = Math.max(max, Math.max(maxCross1, maxCross2));
            result.append(max+"\n");
        }
        System.out.println(result);
    }
}