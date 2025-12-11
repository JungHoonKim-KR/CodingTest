import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        int resultT  =0;
        int resultPenSet = 0;
        int resultPen=0;

        for(int num : arr){
            if(num % t == 0){
                resultT += num/t;
            }
            else{
                resultT += num/t +1;
            }

        }

        resultPenSet = n/p;
        resultPen = n % p;

        System.out.println(resultT);
        System.out.println(resultPenSet + " " + resultPen);

    }



}
