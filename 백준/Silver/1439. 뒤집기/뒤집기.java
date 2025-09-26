import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int count[] = new int[2];
        int curNumber = arr[0]-'0';
        for(int i = 1; i<arr.length; i++){
            if(curNumber != arr[i] -'0'){
                count[curNumber] ++;
                curNumber = arr[i] -'0';
            }
        }

        int result = Math.max(count[0], count[1]);
        System.out.println(result);
    }

}



