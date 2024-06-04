import java.io.*;
import java.util.StringTokenizer;

public class dish {

    static long[][] dp;
     static long catalan(int n, int k) {
        dp[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j] * (i - 1);
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) throws IOException {
        File file1 = new File("dish.inp");
        File file2 = new File("dish.out");
        FileReader fileReader = new FileReader(file1);
        FileWriter fileWriter = new FileWriter(file2);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        int caseNum = Integer.parseInt(bufferedReader.readLine());
        for(int i =0;i<caseNum;i++){
            StringTokenizer st= new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            dp = new long[n + 1][n + 1];
            fileWriter.append(n+" "+k + " " +catalan(n, k) + "\n");
        }
        fileWriter.flush();
        fileWriter.close();
    }
}
