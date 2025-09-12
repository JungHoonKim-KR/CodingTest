import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            if (Math.max(N, M) < 2 * K) {
                sb.append("Yuto\n");
            } else {
                sb.append(N*M % 2 == 1 ? "Yuto" : "Platina").append("\n");
            }
        }
        System.out.println(sb);
    }
}