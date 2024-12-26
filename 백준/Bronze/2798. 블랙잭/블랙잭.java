import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        int card[] = new int[n];
        st = new StringTokenizer(bufferedReader.readLine());
        for(int i =0; i<n; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        for(int i =0; i<n-2; i++){
            for(int j =i+1; j<n-1; j++){
                for(int k = j+1; k<n; k++){
                    int cur = card[i] + card[j] + card[k];
                    if(cur <= m){
                        max = Math.max(cur, max);
                    }
                }
            }
        }

        bufferedWriter.write(max+"");
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}