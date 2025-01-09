import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int arr[];
    static int rightDP[];
    static int leftDP[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 자릿수
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        rightDP = new int[n];
        leftDP = new int[n];

        Arrays.fill(rightDP, 1);
        Arrays.fill(leftDP, 1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int max = 1;
        for (int i = 0; i < n; i++) {
           left(i);
        }
        for(int i = n-1; i>=0; i--){
            right(i);
        }
        for(int i=0; i<n; i++){
            max = Math.max(max, leftDP[i] + rightDP[i]);
        }
        System.out.println(max-1);


    }

    static void left(int n) {
        for (int j = 0; j < n; j++) {
            if (arr[n] > arr[j]) {
                leftDP[n] = Math.max(leftDP[j] + 1, leftDP[n]);
            }
        }
    }

    static void right(int n) {
        for (int i = arr.length-1; i >= n; i--) {
            if (arr[n] > arr[i]) {
                rightDP[n] = Math.max(rightDP[i] + 1, rightDP[n]);
            }
        }
    }


}
