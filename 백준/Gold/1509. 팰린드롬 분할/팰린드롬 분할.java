import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class Main {
    static String input;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        input = br.readLine();

        int dp[] = new int[input.length() + 1];
        dp[1] = 1;

        for (int i = 2; i <= input.length(); i++) {
            for (int j = 1; j < i; j++) {
                if (isPalindrome(j, i)) {
                    // 1개가 늘었을 수도

                    if (dp[i] == 0) {
                        dp[i] = dp[i - 1] + 1;
                    }
                    dp[i] = Math.min(dp[j - 1] + 1, dp[i]);

                }
            }
            // 팰린드롬이 아예 발견되지 않았을 경우
            if (dp[i] == 0)
                dp[i] = dp[i - 1] + 1;
        }
        System.out.println(dp[input.length()]);
    }

    static boolean isPalindrome(int a, int b) {
        a-=1; b-=1;

        while(a<b){
            if(input.charAt(a) != input.charAt(b)) return false;
            a++;
            b--;
        }
        return true;
    }


}
