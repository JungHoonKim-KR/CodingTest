import java.io.*;
import java.util.*;

public class Main {
    static long[][] resultMatrix;
    static int mod = 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long arr[][] = new long [n][n];
        //초기 행
        resultMatrix = new long[n][n];
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            resultMatrix[i][i] =1;
            for(int j=0; j<n; j++){
                arr[i][j] = Long.parseLong(st.nextToken());
            }
        }
        
        matrixPower(arr, m);

        // 거듭제곱
        // 짝수면 n/2, 홀수면 곱

        for(int i =0; i<n;i++){
            for(int j =0; j<n; j++){
                bw.write(resultMatrix[i][j]+" ");
            }
            bw.newLine();
        }
        bw.flush();
    }
    static void matrixPower(long matrix[][], long exp){

        
        // exp ==0 return
        if(exp  %2==1){
            // 결국 마지막은 exp == 1이므로 result * matrix를 하게 됨.
            // 일단 홀수면 matrix 단독으로 한번 계산
            resultMatrix = multiply(resultMatrix, matrix);
        }
        if(exp ==0){
            return;
        }
        // 홀수던 짝수던 위의 if로 인해 결국 exp는 짝수가 되므로 제곱 연산
        matrix = multiply(matrix, matrix);
        matrixPower(matrix, exp/2);

    }

    static long[][] multiply(long[][] a, long[][] b){
            int N = a.length;
            long c[][] = new long[N][N];
            
            for(int i =0; i<N; i++){
                for(int j=0; j<N; j++){
                    for(int k=0; k<N; k++){
                        c[i][j] = (c[i][j] + a[i][k] * b[k][j]) % mod;
                    }
                }
            }
            return c;
    }
}