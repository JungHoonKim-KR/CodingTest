import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int tc = Integer.parseInt(br.readLine());

        while (tc-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for(int i =0; i<m;i++){
                br.readLine();
            }
            sb.append(n-1+"\n");
        }
        System.out.println(sb);
    }

}