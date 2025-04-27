import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if(n==1){
            System.out.println(1);
            System.out.println(arr[0]);
            return;
        }
        StringBuilder sb=  new StringBuilder();
        int dp[][] = new int[n][2];

        for(int i = 0; i < n; i++){
            dp[i][0] =1;
        }

        int maxLength=0;
        int maxIndex = 0;
        for(int i = 1; i<n; i++){
            for(int j =0; j<i; j++){
                if(arr[i] > arr[j] && dp[i][0] < dp[j][0]+1){
                    dp[i][0] = dp[j][0]+1;
                    dp[i][1] = j;
                }
            }
            if(maxLength < dp[i][0]){
                maxLength = dp[i][0];
                maxIndex=i;
            }
        }

        int result[] = new int[maxLength];
        int valueIndex = maxIndex;
        int resultIndex = maxLength-1;
        while(true){
            int value = arr[valueIndex];
            int nextIndex = dp[valueIndex][1];

            result[resultIndex--] = value;

            if(resultIndex ==-1)
                break;
            valueIndex = nextIndex;

        }
        System.out.println(maxLength);
        for(int re:result){
            sb.append(re+" ");
        }
        System.out.println(sb);
    }

}