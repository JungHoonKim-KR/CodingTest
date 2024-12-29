import java.io.*;
import java.util.*;

public class Main {
    static int num = 1000000;
    static boolean isPrime[] = new boolean[num+1];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Arrays.fill(isPrime, true);
        prime();

        for(int i=n; i<=m;i++){
            if(isPrime[i])bw.write(i+"\n");
        }






        bw.flush();
        bw.close();
    }

    static void prime(){
        isPrime[0] = isPrime[1] = false;
        for(int i =2; i*i<=num;i++){
            if(isPrime[i]){
                for(int j=i*i; j<=num; j+=i){
                    isPrime[j] = false;
                }
            }
        }
    }

}