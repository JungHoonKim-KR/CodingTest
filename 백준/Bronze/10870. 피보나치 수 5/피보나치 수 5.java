import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        bw.write(fibonacci(n) + "\n");
        bw.flush();

    }
    static int fibonacci(int n){
        if(n == 0) return 0;
        else if(n==1) return 1;
        else return fibonacci(n-1) + fibonacci(n-2);
    }
}