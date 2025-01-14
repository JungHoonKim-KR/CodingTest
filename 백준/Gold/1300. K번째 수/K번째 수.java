import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int min =1;
        int max = k;
        while(min < max){
            int mid = (min + max)/2;

            int count = 0;

            for(int i =1; i<=n; i++){
                count += Math.min(n, mid/i);
            }
            if(count <k){
                min = mid+1;
            }
            else {
                max = mid;
            }
        }
        System.out.println(min);
    }
}