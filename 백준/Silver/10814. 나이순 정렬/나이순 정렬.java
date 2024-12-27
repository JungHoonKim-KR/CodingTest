import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringBuilder[] sb= new StringBuilder[201];
        for(int i =0; i<sb.length; i++){
            sb[i] = new StringBuilder();
        }

        StringTokenizer st;
        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name =st.nextToken();

            sb[age].append(age + " "+ name+"\n");

        }

        StringBuilder b = new StringBuilder();
        for(StringBuilder s: sb){
            b.append(s);
        }
        bw.write(b.toString());
        bw.flush();
        bw.close();
    }
}