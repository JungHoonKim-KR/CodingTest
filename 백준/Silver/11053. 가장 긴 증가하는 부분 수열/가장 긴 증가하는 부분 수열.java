import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int length = Integer.parseInt(bufferedReader.readLine().trim());
        Integer [] arr = new Integer[length];
        Integer [] dp  = new Integer[length];
        Arrays.fill(dp,1);
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int ans = 0;
        for(int i =0; i<length; i++){
            int data = Integer.parseInt(st.nextToken());
            arr[i] = data;
        }

        for(int i = 0; i < length; i++){
            for(int j = 0; j < i ; j++){
                if(arr[i]>arr[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            ans = Math.max(ans,dp[i]);
        }

        bufferedWriter.write(ans+"");

        bufferedWriter.close();
        bufferedReader.close();
    }
}