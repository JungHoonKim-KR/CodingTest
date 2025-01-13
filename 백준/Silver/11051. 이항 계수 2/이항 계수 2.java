import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int mod = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println((factorial(n) * mod_inverse(factorial(k) * factorial(n-k) % mod, mod -2)) % mod);
    }
    static int factorial(int n){
        if(n<=1) return 1;
        return n * factorial(n-1) % mod;
    }
    static int mod_inverse(int a, int exp){
        int result=1;

        while(exp >0){
            if(exp % 2==1){
                result *= a;
                exp --;
                result %= mod;
            }
            a *= a;
            a %= mod;
            exp /= 2;
        }

        return result;

    }

}