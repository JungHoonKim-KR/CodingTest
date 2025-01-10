import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int cnt[] = new int[1000];
        int sum=0;
        long result=0;
        st = new StringTokenizer(br.readLine());

        for(int i =0; i<n; i++) {
            int cur = Integer.parseInt(st.nextToken());
            sum += cur;
            sum%=m;
            result += cnt[sum];
            cnt[sum]++;
            if(sum==0) result++;
        }
        System.out.println(result);
    }

}