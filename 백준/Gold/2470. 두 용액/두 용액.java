import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int arr[];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arr);
        int left = 0, right = n-1;
        int min = Integer.MAX_VALUE;
        int minL=0, minR=0;
        while(left < right){
            int sum = arr[left] + arr[right];

            if(Math.abs(min) > Math.abs(sum)){
                min = sum;
                minL = left;
                minR = right;
            }

            if(sum > 0){
                right--;
            }
            else if(sum <0){
                left++;
            }
            else break;
        }

        System.out.print(arr[minL]+" "+arr[minR]);


    }


}
