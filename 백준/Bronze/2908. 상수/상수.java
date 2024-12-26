import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        StringBuilder reverseA = new StringBuilder();
        for(int i = a.length()-1; i>=0; i--){
            reverseA.append(a.charAt(i));
        }
        String b = st.nextToken();
        StringBuilder reversB = new StringBuilder();
        for(int i = b.length()-1; i>=0; i--){
            reversB.append(b.charAt(i));
        }
        bw.write(Math.max(Integer.parseInt(reverseA.toString()), Integer.parseInt(reversB.toString())) +"");
        bw.flush();
        bw.close();
    }
}