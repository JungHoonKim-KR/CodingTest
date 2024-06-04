import java.io.*;

public class bigFibonacci {
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader("bigFibonacci.inp"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("bigFibonacci.out"));
        int T = Integer.parseInt(bufferedReader.readLine());

        for (int i = 0; i < T; i++) {
            long n = Long.parseLong(bufferedReader.readLine());
            bufferedWriter.write(n + " " + fib(n)+"\n");
        }

        bufferedWriter.close();

    }

    private static long fib(long n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        long[][] result = {{1, 0}, {0, 1}};
        long[][] base = {{1, 1}, {1, 0}};
        n -= 1;

        while (n > 0) {
            if (n % 2 == 1) {
                result = multiplyMatrices(result, base);
            }
            base = multiplyMatrices(base, base);
            n /= 2;
        }

        return result[0][0];
    }

    private static long[][] multiplyMatrices(long[][] a, long[][] b) {
        long[][] c = new long[2][2];
        c[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD;
        c[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
        c[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
        c[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;
        return c;
    }
}
