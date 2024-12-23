import java.io.*;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int x = Integer.parseInt(stringTokenizer.nextToken());
        int y = Integer.parseInt(stringTokenizer.nextToken());
        int z = Integer.parseInt(stringTokenizer.nextToken());

        while(!(x==0 && y==0 && z==0)){
            if(x+y<=z || y+z<=x || x+z <=y){
                bufferedWriter.write("Invalid\n");
            }
            else if(x == y && x == z )
                bufferedWriter.write("Equilateral\n");
            else if(x != y && x != z && y != z)
                bufferedWriter.write("Scalene \n");
            else bufferedWriter.write("Isosceles\n");

            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
             x = Integer.parseInt(stringTokenizer.nextToken());
             y = Integer.parseInt(stringTokenizer.nextToken());
             z = Integer.parseInt(stringTokenizer.nextToken());
        }

        bufferedWriter.flush();
    }


}
