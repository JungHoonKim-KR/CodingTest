import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            StringTokenizer st =new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());
            long gcd = getGCD(a, b);

            bw.write(a*b/gcd+"\n");
        bw.flush();
    }

    static long getGCD(long a, long b){
        long r=0;
        while(b!=0){
            r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}



