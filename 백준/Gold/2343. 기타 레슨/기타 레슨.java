import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static long[]arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());

        long min = 0;
        long max = 0;
        arr = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());

            min = Math.max(min, arr[i]);
            max += arr[i];
        }

        while(min < max){
            long mid = min + (max - min)/2;
            int count = getCount(mid);

            if(count < M){
                max = mid;
            }
            else{
                min = mid + 1;
            }

        }
        System.out.println(min);

    }

    static int getCount(long mid){
        int count = 0;
        long sum = 0;
        for(int i = 0; i<N; i++){
            long cur = arr[i];

            if(cur > mid) return Integer.MAX_VALUE;

            if(cur + sum > mid){
                count++;
                sum = 0;
            }
            sum += cur;
        }
        return count;
    }
}