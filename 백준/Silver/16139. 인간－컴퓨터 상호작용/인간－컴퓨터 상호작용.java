import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] charArray = br.readLine().toCharArray();

        int sumArr[][] = new int[charArray.length+1][26];

        for(int i = 1; i<=charArray.length; i++){
            for(int j=0; j<26; j++){
                sumArr[i][j] = sumArr[i-1][j];
            }
            sumArr[i][charArray[i-1]-'a'] = sumArr[i-1][charArray[i-1]-'a'] +1;

        }

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int firstIndex = Integer.parseInt(st.nextToken()) +1;
            int secondIndex = Integer.parseInt(st.nextToken()) +1;

            bw.write(sumArr[secondIndex][c-'a'] - sumArr[firstIndex-1][c-'a']+"\n");
        }

        bw.flush();
    }

}