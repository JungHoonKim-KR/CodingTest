import java.io.*;

public class Main {
    static long mod = 1000000007;
    static long result[][] = {{1,0}, {0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());

        long matrix [][] = {{1,1}, {1,0}};

        long[][] pow = pow(matrix, n);
        System.out.println(pow[1][0]);


    }

    static long[][] pow(long matrix[][], long exp){


        if(exp %2 ==1){
            result = multiply(result, matrix);
        }

        if(exp ==0)
            return result;
        matrix = multiply(matrix, matrix);
        pow(matrix, exp/2);

        return result;
    }


    static long[][] multiply(long a[][], long b[][]){
        long N = a.length;
        long c[][] = {{0,0}, {0,0}};
        for(int i = 0; i<N; i++){
            for(int j =0; j<N; j++){
                for(int k=0; k<N; k++){
                   c[i][j] =  (c[i][j] + a[i][k]*b[k][j])%mod;
                }
            }
        }
        return c;
    }
}