import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int [n];
        int dp[] = new int [n];
        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        for(int i =1; i<n; i++){
            for(int j =0; j<i; j++){
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
                else dp[i] = Math.max(dp[i], arr[i]);
            }
        }
        int max = 0;
        for(int d : dp){
            max = Math.max(max, d);
        }
        System.out.println(max);
    }

}
