import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int sum =0, left=0, right=0, minLength = Integer.MAX_VALUE ;

        while(right<n){
            sum += arr[right];

            while(sum >= s){
                minLength = Math.min(minLength, right - left+1);
                sum -= arr[left];
                left++;
            }

            right++;
        }
        int result = minLength == Integer.MAX_VALUE? 0 : minLength;
        System.out.print(result);
    }


}
