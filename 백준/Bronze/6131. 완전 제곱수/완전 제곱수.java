import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int count=0;
        for(int A = 2; A<=500; A++){
            // A*A - n  == B*B;
            if(A*A > n){
                double B = Math.sqrt(A*A-n);
                if(B == (long)B){
                    count++;
                }
            }
        }
        System.out.println(count);





    }
}