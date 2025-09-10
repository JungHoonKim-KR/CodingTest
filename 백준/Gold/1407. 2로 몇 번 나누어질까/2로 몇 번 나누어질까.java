import java.util.*;
import java.io.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        System.out.println(solve(b) - solve(a-1));
    }

    static long solve(long n){
        if(n == 0)
            return 0;

        if(n == 1){
            return 1;
        }

        return 2 * solve(n/2) + (n+1)/2;
    }


}