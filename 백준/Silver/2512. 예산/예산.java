import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        long budget = Long.parseLong(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int min = 0;
        int max = arr[n - 1] +1;

        while (min < max) {
            int mid = (min + max) / 2;
            long sum = 0;
            for (int money : arr) {
                if(money > mid){
                    sum+= mid;
                }
                else sum+=money;
            }

            if(sum > budget){
                max = mid;
            }
            else min = mid+1;
        }

        System.out.println(min-1);


    }
}