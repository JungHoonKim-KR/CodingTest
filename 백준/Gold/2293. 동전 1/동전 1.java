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
        int money = Integer.parseInt(st.nextToken());
        int dp[] = new int[money+1];
        int coin[] = new int[n];
        for(int i =0; i<n; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        dp[0] = 1;
        for(int i=0; i<n; i++){
            for(int j=1; j<=money; j++){
                // 1원 부터 money까지 경우의 수 조사, 0원은 경우의수 1임(coin으로 나눠지는 경우이므로 경우의수 1이 추가됨)
                if(j >= coin[i]){
                    dp[j] += dp[j-coin[i]];
                }
            }
        }

        System.out.println(dp[money]);

    }

}
