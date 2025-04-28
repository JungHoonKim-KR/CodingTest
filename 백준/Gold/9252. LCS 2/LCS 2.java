import java.util.*;
import java.io.*;

public class Main {
    static char[] string1;
    static char[] string2;
    static int dp[][];
    static char resultArr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        string1 = br.readLine().toCharArray();
        string2 = br.readLine().toCharArray();

        dp = new int[string2.length+1][string1.length+1];

        for(int i =0; i<string1.length; i++){
            for(int j = 0; j<string2.length; j++){
                if(string1[i] == string2[j]){
                    dp[j+1][i+1] = dp[j][i] +1;
                }
                else {
                    dp[j+1][i+1] = Math.max(dp[j][i+1], dp[j+1][i]);
                }
            }
        }
        int result = dp[string2.length][string1.length];
        resultArr = new char[result];
        System.out.println(result);
        print(string2.length, string1.length, result-1);
        for(char re : resultArr){
              sb.append(re);
        }
        System.out.println(sb);


    }
    static void print(int i, int j, int index){
        if(dp[i][j]==0){
            return;
        }
        if(string2[i-1] == string1[j-1]){
           resultArr[index] = string2[i-1];
           print(i-1,j-1, index-1);
        }
        else {
            if (dp[i][j - 1] > dp[i - 1][j]) {
                print(i, j - 1, index);
            } else {
                print(i - 1, j, index);
            }
        }



    }

}