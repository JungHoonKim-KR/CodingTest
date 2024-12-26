import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        String target = "666";
        int count=0;
        for(int i =666; ; i++){
            String string = Integer.toString(i);
            if(string.contains(target))
                count++;

            if(count==n){
                bw.write(string);
                break;

            }
        }
        bw.flush();
    }



}


