import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            set.add(Integer.valueOf(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
         st = new StringTokenizer(br.readLine());

        for(int i =0; i<m; i++){
            if(set.contains(Integer.valueOf(st.nextToken()))){
                sb.append(1+"\n");
            }
            else sb.append(0+"\n");
        }
        System.out.println(sb);


    }





}