import java.io.*;
import java.util.*;


public class Main {
    static int histogram[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long arr[] = new long[n];

        long max = 0;
        st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        long min = 0;
        while(min <max){
            long mid = min + (max - min)/2;

            long count=0;
            for(long line : arr){
               if(line > mid) count+= line - mid;
            }
            if(count>=m)
                min = mid+1;
            else max = mid;
        }

        System.out.println(min-1);





    }

}
