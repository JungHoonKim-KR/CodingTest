import java.io.*;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int morning = Integer.parseInt(stringTokenizer.nextToken());
        int evening = Integer.parseInt(stringTokenizer.nextToken());
        int v = Integer.parseInt(stringTokenizer.nextToken());
        int day;

        v -= morning;

        day = (int) (Math.ceil((double) v /(morning - evening)) + 1);

        bufferedWriter.write(day+"");
        bufferedWriter.flush();
    }


}
