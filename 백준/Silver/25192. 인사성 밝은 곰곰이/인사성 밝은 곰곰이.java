import java.io.*;
import java.util.HashSet;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        int count=0;
        String C;
        HashSet<String> memberList = new HashSet<>();
        for(int i =0;i<num; i++){
            C = br.readLine();
            if(C.equals("ENTER"))
                memberList.clear();
            else {
               if(!memberList.contains(C)){
                   memberList.add(C);
                   count++;
               }
            }
        }
        bw.write(count+"");
        bw.flush();
        bw.close();
    }
}