import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = 1000000;
        boolean arr[] = new boolean[num+1];
        for (int i = 0; i <=num; i++)
            arr[i] = true;

        for (int i = 2; i * i <=num; i++) {
            for (int j = i * i; j <=num; j+=i) {
                arr[j] = false;
            }
        }

        int n = Integer.parseInt(br.readLine());
        for (int z = 0; z < n; z++) {
            int count=0;
            int k = Integer.parseInt(br.readLine());

            for (int i = 2; i <=k/2; i++) {
                if(arr[i]==true && arr[k-i]==true)
                    count++;
            }

            System.out.println(count);
        }

    }
}