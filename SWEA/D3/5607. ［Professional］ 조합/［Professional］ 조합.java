import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

/*
1:동, 2:서, 3:북, 4:남
 */

public class Solution {
    static long a, b, c;
    static final long MOD = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            long[] fact = new long[1000001];
            fact[0] = 1;
            // 팩토리얼 정의
            for(int i = 1; i<=1000000; i++){
                fact[i] = fact[i-1]*i % MOD;
            }

            // 조합
            // 분자 : N!
            long numerator = fact[N];

            // 분모 : (R! * (N-R)!) % MOD
            long denominator = (fact[R] * fact[N-R]) % MOD;

            // 조합은 분자/분모 이므로 분모의 inverse를 구해야함
            // 즉 denominator의 inverse == denominator^(MOD - 2) % MOD
            long inverse = makeInverse(denominator, MOD-2);
            long result = numerator * inverse%MOD;
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        System.out.println(sb);

    }
    static long makeInverse(long base ,long exp){
       if(exp == 1){
           return base % MOD;
       }

       long temp = makeInverse(base, exp/2);
       if(exp %2 == 1){
           return (temp * temp) % MOD *base % MOD;
       }
       else{
           return (temp * temp) % MOD;
       }
    }


}