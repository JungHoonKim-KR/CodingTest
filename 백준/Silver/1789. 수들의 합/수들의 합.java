import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long sum=0;
        for(long i =1; ; i++){
            sum+=i;
            if(n - sum <=i){
                System.out.println(i);
                break;
            }

        }


    }

}