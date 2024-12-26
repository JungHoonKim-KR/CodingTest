import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int initFiveCoins = n/5;
        int result = -1;
        for(int i =0; i<=initFiveCoins; i++){
            int fiveCoins = initFiveCoins - i;
            int remain = n - (5 * fiveCoins);
            if(remain %3 == 0){
                result =fiveCoins + remain/3;
                break;
            }
        }
        bw.write(result+"");
        bw.flush();
    }



}


