import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a0 = Integer.parseInt(st.nextToken());

        int c = Integer.parseInt(bufferedReader.readLine());
        int n0 = Integer.parseInt(bufferedReader.readLine());

        int f = a1 * n0 + a0;
        int g = c * n0;
        if(f<=g &&  a1<=c) bufferedWriter.write(1+"");
        else bufferedWriter.write(0+"");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}