import java.io.*;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char [] arr = br.readLine().toCharArray();
        int [] checkArr = new int[26];

        for(int i=0;i<arr.length;i++) {
            int c = arr[i];
            if(c >=97){
                checkArr[c-97]++;
            }
            else checkArr[c-65]++;
        }

        boolean isEqual = false;
        int maxIndex=0;
        int max = Integer.MIN_VALUE;

        for(int i =0; i<26;i++){
            if(checkArr[i] != 0 && checkArr[i] == max){
                isEqual = true;
            }
            if(checkArr[i] > max){
                max = checkArr[i];
                maxIndex = i;
                isEqual = false;
            }
        }
        if(isEqual)
            bw.write("?");
        else
            bw.write((char)(maxIndex+65));
        bw.flush();
    }
}



