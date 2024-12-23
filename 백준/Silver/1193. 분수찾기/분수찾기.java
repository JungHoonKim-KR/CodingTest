import java.io.*;
public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int target = Integer.parseInt(bufferedReader.readLine());

        for(int i=1; i<10000000;i++){
            if(target >= 0 && target <=i){
                if(i % 2 == 0){
                    bufferedWriter.write(target + "/" + (i+1-target));
                }
                else bufferedWriter.write((i+1-target) + "/" + target);

                break;

            }
            else {
                target -= i;
            }
        }
        bufferedWriter.flush();

    }


}
