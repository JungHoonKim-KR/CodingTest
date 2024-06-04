import java.io.*;

public class Main{
    static int count1=0;
    static int count2=0;
    static int fib(int n ){
        if(n==1 || n==2){
            count1++;
            return 1;
        }
        else return fib(n-1) + fib(n-2);
    }
    static int fibonacci(int n){
        int arr[] = new int[n+1];
        arr[1]=1; arr[2]=1;
        for(int i = 3; i<= n; i++){
            count2++;
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());

        fib(num);
        fibonacci(num);

        bw.write(count1 + " "+ count2);
        bw.flush();
        bw.close();

    }
}