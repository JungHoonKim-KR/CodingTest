import java.io.*;
import java.util.*;


public class Main {
    static int[] arr;
    static boolean isPossible;
    static int n, result = Integer.MAX_VALUE;
    static int[] go = {-1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        n = Integer.parseInt(br.readLine());

        if(n == 1){
            System.out.println(0);
            return;
        }
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int first = arr[0] + go[i];
                int second = arr[1] + go[j];
                int count = 0;
                int d = second - first;

                if (go[i] != 0) count++;
                if (go[j] != 0) count++;
                isPossible = true;
                int value = second;
                for (int k = 2; k < n; k++) {
                    value += d;
                    int diff = Math.abs(arr[k] - value);

                    if (diff <= 1) {
                        if (diff == 1)
                            count++;
                    } else {
                        isPossible = false;
                        break;
                    }
                }
                if (isPossible)
                    result = Math.min(result, count);
            }

        }
        System.out.println(result == Integer.MAX_VALUE ? -1 : result);
    }


}