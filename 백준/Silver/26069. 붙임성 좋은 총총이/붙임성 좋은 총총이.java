import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        set.add("ChongChong");
        for(int i=0; i<num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String man1 = st.nextToken();
            String man2 = st.nextToken();
            if(set.contains(man1) || set.contains(man2)){
                set.add(man1);
                set.add(man2);
            }
        }
        bw.write(set.size()+"");
        bw.flush();
        bw.close();
    }
}