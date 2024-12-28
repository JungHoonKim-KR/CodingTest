import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i =0; i<n; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int gcd = getGCD(a, b);

            bw.write(a*b/gcd+"\n");
        }
        bw.flush();
    }

    static int getGCD(int a, int b){
        int r=0;
        while(b!=0){
            r = a%b;
            a = b;
            b = r;
        }
        return a;
    }
}



