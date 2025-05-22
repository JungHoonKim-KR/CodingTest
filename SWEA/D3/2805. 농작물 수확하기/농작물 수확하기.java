import java.util.*;
import java.io.*;

 class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= n; tc++) {
            int size = Integer.parseInt(br.readLine());
            result.append("#" + tc + " ");

            int [][]arr = new int[size][size];
            for(int i = 0; i < size; i++){
                String input = br.readLine();
                for(int j = 0; j < size; j++){
                    arr[i][j] = input.charAt(j) - '0';
                }
            }
            int sum = 0;
            int startPoint=size /2;
            for(int i =0; i<size/2+1; i++){
                sum += arr[startPoint][i] + arr[startPoint][size -1 -i];
                for(int j = 1; j<=i; j++){
                    sum += arr[startPoint + j][i] + arr[startPoint - j][i] + arr[startPoint +j][size - 1 -i] + arr[startPoint -j][size - 1 -i];
                }
            }
            for(int i =0; i<size; i++){
                sum -= arr[i][startPoint];
            }
            result.append(sum+"\n");

        }
        System.out.println(result);
    }

}