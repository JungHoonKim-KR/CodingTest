import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] charArray1 = br.readLine().toCharArray();
        char[] charArray2 = br.readLine().toCharArray();
        int count[][] = new int[charArray2.length + 1][charArray1.length + 1];
        for (int i = 1; i <= charArray1.length; i++) {
            for (int j = 1; j <= charArray2.length; j++) {
                count[j][i] = Math.max(count[j - 1][i], count[j][i - 1]);
                if (charArray1[i - 1] == charArray2[j - 1] && count[j][i] < i && count[j][i] < j) {
                    count[j][i] = count[j-1][i-1]+1;

                }

            }
        }
        System.out.println(count[charArray2.length][charArray1.length]);
    }
}