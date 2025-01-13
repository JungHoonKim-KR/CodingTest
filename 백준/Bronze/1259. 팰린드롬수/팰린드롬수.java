import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s;
        while(true){
            boolean result = true;
            s = br.readLine();
            if(s.charAt(0)=='0') break;

            for(int i =0; i<s.length()/2; i++){
                if(s.charAt(i) != s.charAt(s.length()-i-1)){
                    bw.write("no\n");
                    result = false;
                    break;
                }
            }

            if(result) bw.write("yes\n");
        }
        bw.flush();

    }

}