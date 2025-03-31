import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        String s = br.readLine();
        String bomb = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            sb.append(c);
            if(sb.length() >= bomb.length()){
               if (sb.substring(sb.length() - bomb.length()).equals(bomb)){
                   sb.delete(sb.length() - bomb.length(), sb.length());
               }
            }
        }
        if (sb.isEmpty())
            System.out.println("FRULA");
        else System.out.println(sb);





    }



}
