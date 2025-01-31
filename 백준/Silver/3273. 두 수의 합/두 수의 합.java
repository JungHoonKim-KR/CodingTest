import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int arr[];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int left = 0, right = n-1, count=0;
        while(left < right){
            int sum = arr[left] + arr[right];

            if(sum == target){
                count ++;
                left++;
                right --;
            }
            else if(sum > target){
                right--;
            }
            else left++;
        }

        System.out.print(count);


    }


}
