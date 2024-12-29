import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int arr [] =new int[n];
        int dArr [] = new int[n-1];
        arr[0] = Integer.parseInt(br.readLine());

        for(int i = 1; i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            dArr[i-1] = arr[i] - arr[i-1];
        }
        int gcd = gcd(dArr[0], dArr[1]);
        for(int i =2; i<n-1; i++){
            gcd = gcd(gcd, dArr[i]);
        }
        int result = Arrays.stream(dArr).sum() / gcd - (n-1);

        bw.write(result+"");


        bw.flush();
        bw.close();
    }

    static int gcd(int a, int b){
        int r;
        while(b!=0){
            r = a%b;
            a = b;
            b = r;

        }
        return a;
    }
}