import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Queue<String>q = new ArrayDeque<>();

        String input= null;
        while(!(input = br.readLine()).equals(String.valueOf(-1))){
            if(input.equals("0"))
                q.poll();
            else {
                q.add(input);
            }
            if(q.size() >=n)
                q.clear();
        }
        for(String s : q)
            sb.append(s+" ");
        System.out.println(sb);







    }

}

