import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr= new int[n][2];
        double result = 0.0;
        for(int i = 0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<n-1; i++){
            result += ccw(arr[0], arr[i], arr[i+1]);
        }
        double area = Math.abs(result/2.0);
        System.out.println(String.format("%.1f",area));
    }

    static double ccw(int[]a, int[]b, int[]c){
        long sum = ((long)a[0] * b[1] - (long)b[0] * a[1])
                + ((long)b[0] * c[1] - (long)c[0] * b[1])
                + ((long)c[0] * a[1] - (long)a[0] * c[1]);
        return (double)sum;
    }
}
