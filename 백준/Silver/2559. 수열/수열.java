import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int sum [] = new int[n+1];
        int arr[] = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i =1; i<=n; i++){
            arr[i] =  Integer.parseInt(st.nextToken());
        }
        for(int i =1; i<=n; i++){
            sum[i] = sum[i-1] + arr[i];
        }
        int max = Integer.MIN_VALUE;
        for(int i =1; i<=n -k +1; i++){
            max = Math.max(max, sum[i-1+k] - sum[i-1]);
        }
        System.out.println(max);
    }

}