import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 97; i<=122; i++){
            sb.append(s.indexOf((char)i)+" ");

        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}