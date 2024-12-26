import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n;
        StringBuilder sb;
        while ((n = Integer.parseInt(br.readLine())) != -1) {
            sb = new StringBuilder();
            int sum = 0;
            for (int i = 1; i < n; i++) {
                if (n % i == 0) {
                    sum += i;
                    sb.append(" " + i + " +");
                }
            }
            if (sum == n) {
                sb.deleteCharAt(sb.length() - 1);
                bw.write(n + " =" + sb);
            } else bw.write(n + " is NOT perfect.");
            bw.newLine();
        }


        bw.flush();
        bw.close();
    }
}