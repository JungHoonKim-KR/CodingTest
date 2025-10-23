import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        StringTokenizer st;
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (p1,p2)->{
            if(p1[0] == p2[0])
                return p1[1] - p2[1];
            return p1[0] - p2[0];
        });

        long s = arr[0][0];
        long e = arr[0][1];
        long totalLength = 0;

        for(int i = 1; i<n; i++){
            long cs = arr[i][0];
            long ce = arr[i][1];

            // 겹칠 때
            if(cs < e){
                e = Math.max(e, ce);
            }
            else{
                totalLength +=(e-s);
                s = cs;
                e = ce;
            }

        }

        totalLength +=(e-s);
        System.out.println(totalLength);
    }


}