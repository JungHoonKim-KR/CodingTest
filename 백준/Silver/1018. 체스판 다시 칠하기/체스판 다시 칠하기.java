import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static char [][] data;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        data = new char[y][x];
        for(int j=0; j<y; j++) {
            String s = bufferedReader.readLine();
            for(int i =0; i<x; i++) {
                data[j][i] = s.charAt(i);
            }
        }
        int min = x*y;

        for(int j = 0; j < y-7; j++) {
            for(int i=0; i<x-7; i++){
                min = Math.min(min, check(i,j));
            }
        }
        bufferedWriter.write(min+"");
        bufferedWriter.flush();

    }

    static int check(int x, int y){
        int count=0;
        for(int j =y; j<y+8;j++){
            for(int i =x; i<x+8;i++){
               if((x+y)%2 == (i+j)%2){
                   if(data[y][x] != data[j][i])
                       count++;
               }
               else if((x+y)%2 != (i+j)%2){
                   if(data[y][x] == data[j][i])
                       count++;
               }
            }
        }
        return Math.min(count, 64-count);
    }


}


