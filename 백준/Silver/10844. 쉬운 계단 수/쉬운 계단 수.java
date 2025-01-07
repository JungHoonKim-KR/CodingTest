import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long div = 1000000000;
        // 자릿수
        int n = Integer.parseInt(br.readLine());

        // 자릿수 / 앞자리 수
        long dp [][] = new long[n+1][10];

        // 일의 자리 수의 계단 수는 1밖에 없음
        for(int i=0 ; i<=9 ; i++){
            dp[1][i] =1L;
        }

        for(int i=2; i<=n; i++){
            for(int j=0; j<10;j++){
                if(j == 0){
                    dp[i][j] =  dp[i-1][j+1] % div;
                }
                else if(j == 9){
                    dp[i][j] = dp[i-1][j-1] %div;
                }
                else{
                    dp[i][j] = (dp[i-1][j+1]% div+ dp[i-1][j-1] %div);
                }
            }
        }

        long result=0;

        for(int i=1;i<=9;i++){
            result += (int) dp[n][i];
        }

        System.out.println(result % div);


    }



}
