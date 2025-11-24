import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());

            int arr[] = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long total = 0L;
            int max = 0;
            for(int i = n-1; i >= 0; i--) {


                // 갱신
                if(max < arr[i]) {
                    max = arr[i];
                }
                else{
                    total += max - arr[i];
                }
            }
            bw.write(total+"\n");
        }
        bw.flush();
    }



}
