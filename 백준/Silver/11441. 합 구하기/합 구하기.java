import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        long sum[] = new long[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int input = Integer.parseInt(st.nextToken());
            arr[i] = input;
            sum[i+1] = sum[i] + arr[i];
        }

        int t = Integer.parseInt(br.readLine());
        while(t -->0){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            sb.append(sum[end] - sum[start-1]+"\n");
        }

        System.out.println(sb);
    }


}


