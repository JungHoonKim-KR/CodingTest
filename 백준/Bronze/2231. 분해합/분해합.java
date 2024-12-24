import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        int result=0;
        for(int i =0; i<n;i++){
            int sum=0;
            int number = i;

            while(number != 0){
                sum+= number%10;
                number/=10;
            }
            if(sum + i == n){
                result=i;
                break;
            }
        }

        bufferedWriter.write(result+"");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}