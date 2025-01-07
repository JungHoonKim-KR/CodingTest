import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 자릿수
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        int dp[] = new int[1001];
        Arrays.fill(dp,1 );
        StringTokenizer st  = new StringTokenizer(br.readLine());
        for(int i =0; i<n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int max = 1;
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j]) {
                        dp[arr[i]] = Math.max(dp[arr[j]] + 1, dp[arr[i]]);
                        max = Math.max(max, dp[arr[i]]);
                    }
                }
        }
        System.out.println(max);


    }



}
