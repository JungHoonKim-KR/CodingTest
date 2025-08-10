import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int cnt[] = new int[100_000+1];
        int start = 0, end=0, result=0;

        while(end<n){
            while(end <n && cnt[arr[end]] < m){
                cnt[arr[end++]]++;
            }
            result = Math.max(result, end-start);
            cnt[arr[start++]]--;
        }
        System.out.println(result);
    }
}

