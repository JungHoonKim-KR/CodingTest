import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        int dp[] = new int[n];
        Arrays.fill(dp, 1);

        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int max = 1;
        for(int i = 1; i<n; i++){
            for(int j = 0; j<i; j++){
                if(arr[j] < arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] +1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        System.out.println(n - max);



    }
}