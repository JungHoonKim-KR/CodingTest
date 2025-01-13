import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long mod = 1000000007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        System.out.println((factorial(n) * mod_inverse(factorial(k) * factorial(n-k) % mod, mod -2)) % mod);
    }
    static long factorial(int n){
        long result=1;
        while(n>1){
            result *= n;
            result %= mod;
            n--;
        }
        return result;
    }
    static long mod_inverse(long a, long exp){
        long result=1;

        while(exp >0){
            if(exp % 2==1){
                result *= a;
                result %= mod;
            }
            a *= a;
            a %= mod;
            exp /= 2;
        }

        return result;

    }

}