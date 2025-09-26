import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int minSix = Integer.MAX_VALUE;
        int minOne = Integer.MAX_VALUE;
        int[][] lines = new int[M][2];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            minSix = Math.min(minSix, lines[i][0]);
            lines[i][1] = Integer.parseInt(st.nextToken());
            minOne = Math.min(minOne, lines[i][1]);
        }

        int count = 0;

        if (6 * minOne < minSix) {
            count += N * minOne;
        } else {
            count += minSix * (N / 6);

            if (minOne * (N % 6) > minSix) {
                count += minSix;
            }
            else count += minOne * (N % 6);
        }
        System.out.println(count);
    }
}



