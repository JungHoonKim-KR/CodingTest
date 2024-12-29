import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static int num = 1000000;
    static boolean isOpen[] = new boolean[num + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int count=0;
        for(int i = 1; i*i<=n;i++){
            count++;
        }
        bw.write(count+"");
        bw.flush();

    }





}



