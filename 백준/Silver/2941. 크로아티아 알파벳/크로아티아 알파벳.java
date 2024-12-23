import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String target = bufferedReader.readLine();
        int result = 0;
        for(int i = 0; i<target.length(); i++) {
            if(target.charAt(i)=='c' && i<target.length()-1){
                if(target.charAt(i+1)=='=' || target.charAt(i+1)=='-'){
                    i++;
                }
            }
            else if(target.charAt(i) =='d' && i<target.length()-1){
                if(target.charAt(i+1)=='-')
                    i++;
                else if(target.charAt(i+1)=='z' && i<target.length()-2 && target.charAt(i+2)=='=')
                    i+=2;
            }
            else if(target.charAt(i)=='l' && i<target.length()-1){
                if(target.charAt(i+1)=='j')
                    i++;
            }
            else if(target.charAt(i)=='n' && i<target.length()-1){
                if(target.charAt(i+1)=='j')
                    i++;
            }
            else if(target.charAt(i)=='s' && i<target.length()-1){
                if(target.charAt(i+1)=='=')
                    i++;
            }
            else if(target.charAt(i)=='z' && i<target.length()-1){
                if(target.charAt(i+1)=='=')
                    i++;
            }
            result ++;
        }
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.flush();
    }
}