import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        for(int i = 1; i<=2*n-1; i++){
            int value = Math.abs(n-i);

            int star = n-value;
            for(int j = 1; j<=star; j++){
                bw.write("*");
            }
            for(int j = 1; j<=2*value; j++){
                bw.write(" ");
            }
            for(int j = 1; j<=star; j++){
                bw.write("*");
            }
            bw.write("\n");
        }
        bw.flush();
    }
}