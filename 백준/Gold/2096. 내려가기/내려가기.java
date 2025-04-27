import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int now[] = new int[3];
        int min[] = new int[3];
        int max[] = new int[3];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 3; i++) {
            int value = Integer.parseInt(st.nextToken());
            min[i] = value;
            max[i] = value;
        }
        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int tempMin[] = new int[3];
            int tempMax[] = new int[3];
            for (int j = 0; j < 3; j++) {
                now[j] = Integer.parseInt(st.nextToken());
            }
            tempMin[0] = Math.min(min[0], min[1]) + now[0];
            tempMax[0] = Math.max(max[0], max[1]) + now[0];

            tempMin[1] = Math.min(Math.min(min[0], min[1]), min[2]) + now[1];
            tempMax[1] = Math.max(Math.max(max[0], max[1]), max[2]) + now[1];

            tempMin[2] = Math.min(min[1], min[2]) + now[2];
            tempMax[2] = Math.max(max[1], max[2]) + now[2];

            min = tempMin;
            max = tempMax;
        }

        System.out.println(Math.max(Math.max(max[0], max[1]), max[2]) + " " + Math.min(Math.min(min[0], min[1]), min[2]));
    }

}