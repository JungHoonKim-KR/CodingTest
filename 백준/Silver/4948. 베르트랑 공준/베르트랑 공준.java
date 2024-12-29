import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
       // StringTokenizer st = new StringTokenizer(br.readLine());
        while (true) {
            int a = Integer.parseInt(br.readLine());
            if(a==0){
                return;
            }
            int end =2*a;
            int count=0;
            int check[] = new int[end + 1];
            for (int i = a; i <= end; i++) {
                check[i] = i;

            }

            for (int j = 2; j <= end; j++) {

                for (int k = j * 2; k <= end; k += j) {
                    check[k] = 0;

                }

                check[1] = 0;
            }
            for (int k = a+1; k <= end; k++) {
                if (check[k] != 0) {
                    count+=1;

                }
            }
            bw.write(String.valueOf(count));
            bw.newLine();
            bw.flush();
        }
    }
}

