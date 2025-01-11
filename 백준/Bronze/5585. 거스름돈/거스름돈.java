import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int coins[] = new int[]{500, 100, 50, 10, 5, 1};
        int n = 1000 - Integer.parseInt(br.readLine());

        int result=0;
        for(int i =0; i<coins.length; i++){
            result += n/coins[i];
            n %= coins[i];
        }
        System.out.println(result);

    }

}