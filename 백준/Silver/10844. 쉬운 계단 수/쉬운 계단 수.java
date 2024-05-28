import java.io.*;

public class Main{
    static long Mod = 1000000000L;
    private static Long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        dp = new Long[num+1][10];
        for(int i =0; i<10; i++){
            dp[1][i] = 1L;
        }
        long result=0;
        for(int i =1; i<=9;i++){
            result += recur(num,i);
        }
        bw.write(result%Mod+"");
        bw.flush();
        bw.close();

    }

    private static Long recur(int digit, int val){
        if(digit==1)
            return dp[digit][val];
        if(dp[digit][val]== null){
            if(val==0)
                dp[digit][val] = recur(digit-1,1);
            else if(val == 9)dp[digit][val] = recur(digit-1,8);
            else{
                dp[digit][val] =recur(digit-1,val-1) + recur(digit-1,val+1);
            }
        }

        return dp[digit][val]%Mod;
    }
}