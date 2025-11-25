import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++) {
            String s = br.readLine();

            String result = divide(s) ? "YES" : "NO";
            System.out.println(result);
        }


    }

    static boolean divide(String s){
        if(s.length() ==1){
            return true;
        }
        int mid = s.length()/2;
        String left = s.substring(0,mid);
        String right = s.substring(mid+1, s.length());

        for(int i = 0; i<mid; i++){
            char l = left.charAt(i);
            char r = right.charAt(mid - 1 - i);

            if(l == r)
                return false;
        }

        return divide(left);

    }


}
