import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static long arr [] =new long[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i =0; i<n; i++){
            bw.write(fib(Integer.parseInt(br.readLine()))+"");
            bw.newLine();
        }
        bw.flush();
    }

    static long fib( int n) {
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;

        if(n>=3) {
            if(arr[n]!=0){
                return arr[n];
            }
            for (int i = 3; i <= n; i++) {
                arr[i] = (arr[i - 2] + arr[i - 3]);
            }
        }
        return arr[n];
    }


}
