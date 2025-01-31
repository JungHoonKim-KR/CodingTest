import java.io.*;
import java.util.*;

public class Main {

    static boolean isPrime[];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n= Integer.parseInt(br.readLine());

        isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        prime();

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=2; i<=n; i++){
            if(isPrime[i]){
                list.add(i);
            }
        }


        int left = 0;
        int right = 0;
        int sum=0;
        int count=0;
        int size = list.size();
        while(right < size){
            sum += list.get(right);

            while(sum> n){
                sum -= list.get(left);
                left++;
            }

            if(sum == n) count++;

            right++;
        }
        System.out.print(count);


    }

    static void prime(){
        isPrime[0] = false;
        isPrime[1] = false;

        for(int i =2; i*i<=n; i++){
            if(isPrime[i]){
                for(int j = i*i; j<=n; j+=i){
                    isPrime[j] = false;
                }
            }
        }

    }


}
