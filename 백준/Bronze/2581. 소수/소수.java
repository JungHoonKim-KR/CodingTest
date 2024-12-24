import java.io.*;

public class Main {

    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(bufferedReader.readLine());
        int n = Integer.parseInt(bufferedReader.readLine());
        int sum=0;
        int min = Integer.MAX_VALUE;
        prime = new boolean[n+1];
        getPrime();

        for(int i=m; i<=n; i++){
            if(!prime[i]){
                sum+=i;
                min = Math.min(min, i);
            }
        }

        if(sum == 0 )
            bufferedWriter.write("-1");
        else{
            bufferedWriter.write(sum+"\n");
            bufferedWriter.write(min+"");
        }
            
        bufferedWriter.flush();
    }

    static void getPrime(){
        prime[0] = true;
        prime[1] = true;

        for(int i =2; i<Math.sqrt(prime.length); i++){
            if(prime[i]) continue;
            for(int j=i*i; j< prime.length; j+=i){
                prime[j] = true;
            }
        }

    }


}
