import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        while(tc-->0){
            int n = Integer.parseInt(br.readLine());
            int coin[] = new int[n];
            coin = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int money = Integer.parseInt(br.readLine());

            int dp[] = new int[money+1];
            dp[0] = 1;

            for(int m : coin){
                for(int i = m ; i<=money; i++){
                    dp[i] +=dp[i-m];
                }
            }
            System.out.println(dp[money]);
        }
    }
}