import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n =5;
        String [] data = new String[n];
        int max = 0;
        for(int i=0; i<n; i++) {
            data[i] = bufferedReader.readLine();
            max = Math.max(data[i].length(), max);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<max; i++){
            for(int j=0; j<n; j++) {
                if(data[j].length()>i){
                    sb.append(data[j].charAt(i));
                }
            }
        }
        bufferedWriter.write(sb.toString());
        bufferedWriter.flush();

    }
}
