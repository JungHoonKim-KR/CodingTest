import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private static StringBuilder result= new StringBuilder();
    private static void fun(String s, int n){
        int num = n/3;
        if(num ==1){
            result.append(s.substring(0,num));
        }
        else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < num; i++)
                sb.append(" ");
            fun(s.substring(0, num), num);
            fun(String.valueOf(sb), num);
            fun(s.substring(num * 2, num * 3), num);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        while((line =bufferedReader.readLine())!=null){
            int n = Integer.parseInt(line);
            if(n == 0 )bufferedWriter.write("-\n");
            else{
                int num = (int) Math.pow(3,n+1);
                StringBuilder sb= new StringBuilder();
                for(int i =0; i<num;i++){
                    sb.append("-");
                }
                fun(String.valueOf(sb),num);
                bufferedWriter.write(result+"\n");
                result = new StringBuilder();
            }
        }
        bufferedWriter.close();
    }
}