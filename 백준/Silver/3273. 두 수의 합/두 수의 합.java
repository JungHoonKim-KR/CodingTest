import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        int target = Integer.parseInt(br.readLine());

        int start = 0;
        int end = n-1;
        int count=0;
        while(start < end){
            int sum = arr[start] + arr[end];
            if(sum == target){
                count++;
                start++;
            }
            else if(sum < target) start ++;
            else end--;
        }
        System.out.println(count);



    }


}


