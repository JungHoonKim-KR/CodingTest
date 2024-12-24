import java.io.IOException;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt((br.readLine()));
        int collect[] = new int[b - a+1];
        int k = 0;

        for (int i = a; i <= b; i++) {
            if(b==1){
                break;
            }
            if (i == 1) {
                i++;
            }
            if (i == 2) {
                collect[0] = 2;
                k++;

            }

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    break;
                }
                else if (j == i - 1) {

                    collect[k] += i;
                    k++;
                }
            }
        }
        if (k == 0) {
            System.out.println(-1);
        } else {
            System.out.println(Arrays.stream(collect).sum());
            System.out.println(collect[0]);
        }
    }
}