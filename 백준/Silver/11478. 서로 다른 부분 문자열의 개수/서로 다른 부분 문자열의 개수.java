import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Set<String> set = new HashSet<>();
        for(int i =1; i<=s.length(); i++){
            for(int j=0; j<s.length()+1-i;j++){
               set.add(s.subSequence(j, j + i).toString());
            }
        }
        bw.write(set.size()+"");
        bw.flush();
    }
}



