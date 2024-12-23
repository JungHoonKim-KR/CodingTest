import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int arr[] = new int[10001];

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        for(int i = 0; i < n; i++) {
            arr[Integer.parseInt(bufferedReader.readLine())]++;
        }

        bufferedReader.close();

        int i=0;
        while(i<=10000){
            while(arr[i]>0){
                bufferedWriter.write(String.valueOf(i));
                bufferedWriter.newLine();
                arr[i]--;
            }
            i++;
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }
}