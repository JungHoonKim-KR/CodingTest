import java.util.*;
import java.io.*;

 class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        for(int k = 1; k<=10; k++) {
            int number = Integer.parseInt(br.readLine());

            int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int max = 0;
            int leftMax = 0;
            int rightMax = 0;
            int result = 0;
            for (int i = 2; i < number - 2; i++) {
                rightMax = 0;
                // 오른쪽 두 칸 관측
                for (int j = i + 1; j <= i + 2; j++) {
                    if (rightMax < arr[j]) {
                        rightMax = arr[j];
                    }
                }
                max = Math.max(leftMax, rightMax);
                if(arr[i] > max){
                    result += arr[i] - max;
                    leftMax = rightMax;
                    i += 2;
                }
                else{
                    leftMax = Math.max(arr[i], arr[i-1]);
                }
            }
            sb.append("#" + k+" " + result+"\n");

        }
        System.out.println(sb);

    }


}