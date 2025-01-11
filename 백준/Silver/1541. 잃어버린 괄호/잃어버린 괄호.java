import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String[] split = br.readLine().split("-");

        int sum = 0;
        for(String plusNums :split[0].split("\\+")){
            sum += Integer.parseInt(plusNums);
        }

        for(int i=1; i<split.length; i++){
            for(String num :split[i].split("\\+")){
                sum -= Integer.parseInt(num);
            }
        }

        System.out.println(sum);
    }

}