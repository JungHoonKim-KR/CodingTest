import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int originN = Integer.parseInt(br.readLine());
        int n = originN;
        for(int i =2; i<=Math.sqrt(originN); i++) {

            if(n %i == 0) {
                bw.write(i+"\n");
                n /= i;
                i--;
            }
        }
        if(n != 1)
            bw.write(n+"");
        bw.flush();
        bw.close();
    }
}