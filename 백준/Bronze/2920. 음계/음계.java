import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 6;
        StringTokenizer st = new StringTokenizer(br.readLine());

        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        String result = "";
        if(first < second){
            // ascending
            result = "ascending";
            while (n -->0){
                first = second;
                second = Integer.parseInt(st.nextToken());

                if(first > second){
                    result = "mixed";
                    break;
                }
            }
        }
        else{
            result = "descending";
            while (n -->0){
                first = second;
                second = Integer.parseInt(st.nextToken());

                if(first < second){
                    result = "mixed";
                    break;
                }
            }
        }
        System.out.println(result);
    }



}
