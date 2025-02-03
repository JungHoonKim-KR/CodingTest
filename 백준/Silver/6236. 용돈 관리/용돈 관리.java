import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        long min = 0;
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            min = Math.max(arr[i],min);
        }
        long max = Arrays.stream(arr).sum();
        long result = Long.MAX_VALUE;

        while(min<=max){
            long mid = (min + max)/2;
            int count = m;
            long money = 0;

            for(int i =0; i<n; i++){
                // 돈이 모자라면 출금
                if(arr[i] > money){
                    money = mid;
                    money -= arr[i];
                    count --;
                }
                else money -= arr[i];
            }

            if(count >=0){
                max= mid-1;
                result = mid;
            }
            else min = mid+1;

        }
        System.out.print(result);

    }




}
