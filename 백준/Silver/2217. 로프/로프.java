import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int lopes[] = new int[n];
        for(int i = 0; i < n; i++) {
            lopes[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(lopes);

        int max = 0;
        for(int i =0; i<n; i++) {
            max = Math.max(max, lopes[n-i-1] * (i+1));
        }
        System.out.println(max);


    }

}