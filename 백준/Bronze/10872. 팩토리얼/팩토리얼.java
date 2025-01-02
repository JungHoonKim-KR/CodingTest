import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int sum=1;
        if(n>1){
            for(int i =1; i<=n;i++){
                sum*=i;
            }
        }
        bw.write(sum+"");
        bw.flush();
    }


}


