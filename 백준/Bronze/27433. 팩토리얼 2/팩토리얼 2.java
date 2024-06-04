import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        if(num == 0)bw.write(1+"");
        else{
            long result = 1;
            while(num != 1){
                result *=num --;
            }
            bw.write(result+"");
        }
        bw.flush();
        bw.close();
    }
}