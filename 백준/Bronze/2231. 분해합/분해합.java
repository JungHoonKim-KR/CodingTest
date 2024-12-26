import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int result=0;
        for(int i = 0; i <n; i++) {
            int value = i;
            int sum= value;

            while(value!= 0){
                sum += value%10;
                value/=10;
            }
            if(sum == n){
                result = i;
                break;
            }
        }
        bw.write(result+"");
        bw.flush();
        bw.close();
    }
}