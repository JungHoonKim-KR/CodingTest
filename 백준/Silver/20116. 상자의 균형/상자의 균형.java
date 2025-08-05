import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        long arr[] = new long[n];
        long sum[] = new long[n+1];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            long input = Long.parseLong(st.nextToken());
            arr[i] = input;
            sum[i+1] = sum[i] + arr[i];
        }
        boolean isStable = true;
        for(int i = 1; i<=n-1; i++){
            double center = (double) (sum[n] - sum[i]) / (n-i);
            if(center > arr[i-1] - l && center < arr[i-1] + l){
                continue;
            }
            isStable = false;
            break;
        }
        System.out.println(isStable == true? "stable":"unstable");
    }


}


