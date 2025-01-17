import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static boolean dp[][];
    static int n;
    static int w[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int memoryArr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        int sumMemory=0;
        for(int i =0; i<n; i++){
            int parseInt = Integer.parseInt(st.nextToken());
            memoryArr[i] = parseInt;
        }

        int costArr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            costArr[i] = Integer.parseInt(st.nextToken());
        }

        int dp[] = new int[10001];

        for(int i =0; i<n; i++){
            int memory = memoryArr[i];
            int cost = costArr[i];
            for(int c = 10000; c>=cost; c--){
                if(dp[c - cost] + memory > dp[c]){
                    dp[c] = dp[c - cost] + memory;
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i =0; i<10001; i++){
            if(dp[i] >= target){
                min = i;
                break;
            }
        }
        System.out.println(min);
    }

}
