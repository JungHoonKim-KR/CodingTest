import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Integer list [] = new Integer[s.length()];
        for(int i =0; i<s.length(); i++){
            list[i] = Integer.parseInt(s.charAt(i)+"");
        }
        Arrays.sort(list, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<s.length(); i++){
            sb.append(list[i]+"");
        }
        bw.write(sb.toString());
        bw.flush();
    }
}


