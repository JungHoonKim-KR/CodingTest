import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        //set으로 받기
        Set<String> set = new TreeSet<>();
        for(int i =0; i<n; i++){
            set.add(br.readLine());
        }
        List<String> list = set.stream().sorted((a, b) -> {
            if (a.length() != b.length())
                return a.length() - b.length();
            return 0;
        }).collect(Collectors.toList());

        for(String s : list){
            bw.write(s+"\n");
        }
        bw.flush();
        bw.close();
    }
}