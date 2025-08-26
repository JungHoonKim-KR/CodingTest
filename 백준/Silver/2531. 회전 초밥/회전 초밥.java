import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N,D, K,C;
    static int[] input;
    static int[] rice;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        input = new int[N];
        rice = new int[D+1];
        for(int i = 0; i<N; i++){
            input[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        int count=0;
        for(int i = 0; i<K; i++){
            if(rice[input[i]] == 0){
                count++;
            }
            rice[input[i]]++;
        }

        result = rice[C]==0 ? count+1 : count;

        for(int i = 1; i<N; i++){
            rice[input[i-1]]--;

            if(rice[input[i-1]] == 0){
                count--;
            }

            int nextIndex = (i + K -1)%N;
            if(rice[input[nextIndex]] == 0){
                count++;
            }
            rice[input[nextIndex]]++;


            if(rice[C]==0){
                result = Math.max(result, count+1);
            }
            else result = Math.max(result, count);
        }
        System.out.println(result);
    }


}