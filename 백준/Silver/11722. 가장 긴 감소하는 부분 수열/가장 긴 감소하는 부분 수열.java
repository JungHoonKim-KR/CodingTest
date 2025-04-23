import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        // 오름차순이면 감소하는 부분이 없이 때문에 1로 시작
        int result = 1;
        for(int i = n-2; i>=0; i--){
            for(int j = n-1; j>i; j--){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] +1);
                    result = Math.max(result, dp[i]);
                }
            }
        }
        System.out.println(result);

    }

}
