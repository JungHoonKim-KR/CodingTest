import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // f(n) = f(2) * f(n-2) + 2*(f(n-4) + f(n-6) ...... + f(2)) + 2

        int dp[] = new int[n+1];
        if(n>=2){
            dp[2] = 3;

            for(int i =4; i<=n; i+=2){
                dp[i] = dp[2] * dp[i-2];
                for(int j = i-4; j>=2; j-=2){
                    // 이 문제는 타일을 최초 타일이라고 볼 수 있는 3x2를 기준으로 해서 쌓아가는 거임
                    // dp[4]를 예로 들면 d[2] x d[2]의 형태로, 최초 타일인 3가지 * 3가지가 되지만, dp[4]만의 고유한 타일 2개가 따로 존재하기 때문에 3 x 3 + 2가 됨,
                    // dp[6]은 1.dp[2] * d[4] 2.dp[4]*dp[2]의 경우가 있음. 1번에서 구하면 그냥 dp[2]*dp[4]로 33이지고 2번의 경우 역시 33으로 dp[6]은 dp[2]*dp[4]*2라고 착각할 수 있음
                    // 문제는 dp[4]역시 dp[2]를 기반으로 하기 때문에 중복된 타일이 너무나 많음. 때문에 중복을 제외하고 dp[2]*dp[4]로는 절대 구할 수 없는 경우인, dp[4]만의 특수한 타일 2개와 dp[2]의 관계에 대한 경우를 더해야 함
                    // 즉 dp[6] = dp[2] * dp[4] + dp[4]의 특수 타일 2 * dp[2] + dp[6]만의 고유 타일 2 = 33 + 6 + 2 = 41
                    // dp[8] 역시 1.dp[2]*dp[6] 2.dp[4]*dp[4] 3.dp[6]*dp[2]가 되고 1에서 기본적인 경우의 수를 다 구했으니 2와 3에서는 dp[4], dp[6]의 고유타일에 대한 곱을 더해주면 됨
                    // 여기서 2. dp[4]의 고유타일 2개 * dp[4], 3.dp[6]의 고유타일 2개 * dp[2]이므로 2*(dp[4] + dp[2])가 된다.
                    // 즉 dp[8] = dp[2] * dp[6] + 2*(dp[4] + dp[2]) + dp[8]의 고유타일 2개 = 153
                    dp[i] += 2 * dp[j];
                }
                dp[i] +=2;
            }

        }
        
        System.out.println(dp[n]);
    }

}