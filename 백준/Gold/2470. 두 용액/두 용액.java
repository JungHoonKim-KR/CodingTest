import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Long arr[] = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        int left = 0, right = arr.length - 1;
        long sum = 2000000000;
        int resultLeft = 0;
        int resultRight = 0;
        while(left < right){
            if(Math.abs(arr[left] + arr[right]) < sum){
                resultLeft = left;
                resultRight = right;
                sum = Math.abs(arr[left] + arr[right]);

            }

            if(sum ==0)
                break;
            if(arr[left] + arr[right] < 0){
                left++;
            }
            else right--;

        }

        if(resultLeft < resultRight)
            System.out.println(arr[resultLeft] + " "+arr[resultRight]);
        else
            System.out.println(arr[resultRight] + " "+arr[resultLeft]);

    }


}
