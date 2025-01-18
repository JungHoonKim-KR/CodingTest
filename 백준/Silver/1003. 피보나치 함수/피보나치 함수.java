import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int dpZero[] = new int[41];
        int dpOne[] = new int[41];

        dpZero[0] =1;
        dpOne[0] =0;

        dpZero[1] =0;
        dpOne[1] =1;
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            for(int j = 2; j<=num; j++){
                dpZero[j] = dpZero[j-1] + dpZero[j-2];
                dpOne[j] = dpOne[j-1] + dpOne[j-2];
            }
            sb.append(dpZero[num] + " " + dpOne[num]+"\n");
        }
        System.out.println(sb);
    }

}