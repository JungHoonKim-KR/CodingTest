import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long arr[] = new long[n + 1];
        fib(arr, n);
        bw.write(arr[n] + "");
        bw.flush();
    }

    static void fib(long arr[], int n) {
        arr[0] = 0;
        arr[1] = 1;
        if(n>=2) {
            arr[2] = 2;
            for (int i = 3; i <= n; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2]) % 15746;
            }
        }
    }


}
