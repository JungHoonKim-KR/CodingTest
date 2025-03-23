import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int arr[] = new int[8001];

        int n = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int midCount=0;
        int midNumber=-4000;
        int modeCount=0;
        int modeMax=-4000;
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            arr[num + 4000] ++;

            sum += num;
            min = Math.min(min, num);
            max = Math.max(max, num);

        }

        boolean flag = false;
        for(int i= min + 4000 ; i<= max + 4000; i++){

            if(arr[i] >0){
                // 중앙값
                if(midCount < (n+1)/2){
                    midCount += arr[i];
                    midNumber = i - 4000;
                }

                //최빈값
                if(modeCount < arr[i]){
                    modeCount = arr[i];
                    modeMax = i-4000;
                    flag = true;
                }
                else if(modeCount == arr[i] && flag){
                    flag = false;
                    modeMax = i - 4000;
                }

            }



        }


        System.out.println((int) Math.round((double)sum / n));
        System.out.println(midNumber);
        System.out.println(modeMax);
        System.out.println(max - min);

    }




}
