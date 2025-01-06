import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int fibRecursiveCount = 0;
    static int fibDPCount=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        fibRecursive(n);
        int arr[] = new int[n];
        fibDP(arr, n);
        bw.write(fibRecursiveCount+ " "+ fibDPCount);
        bw.flush();
    }

    static int fibRecursive(int n){
        if(n==1 || n==2){
            fibRecursiveCount++;
            return 1;
        }

        return fibRecursive(n-1) + fibRecursive(n-2);
    }

    static void fibDP(int arr[], int n){
        arr[0] = 0; arr[1] = 1;
        for(int i =2; i<n; i++){
            fibDPCount++;
            arr[i] = arr[i-1] + arr[i-2];
        }
    }





}
