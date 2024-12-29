import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i =0; i<n;i++){
            long num = Long.parseLong(br.readLine());
            if(num<2){
                bw.write(2+"\n");
            }
            else{
                while(true){
                    boolean judge = true;
                    for(int j=2; j<=Math.sqrt(num); j++){
                        if(num%j==0){
                            judge = false;
                            num++;
                            break;
                        }
                    }
                    if(judge){
                        bw.write(num+"\n");
                        break;
                    }
                }
            }


        }


        bw.flush();
        bw.close();
    }

}